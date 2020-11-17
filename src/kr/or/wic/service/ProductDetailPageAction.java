package kr.or.wic.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ChatroomDAO;
import kr.or.wic.dao.FilesDAO;
import kr.or.wic.dao.Like_RecordDAO;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dao.ProductDAO;
import kr.or.wic.dto.ChatroomDTO;
import kr.or.wic.dto.FilesDTO;
import kr.or.wic.dto.MemberDTO;
import kr.or.wic.dto.PriceFormat;
import kr.or.wic.dto.ProductDTO;

public class ProductDetailPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달할 페이지의 정보 구성
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		
		//product 객체
		int prd_num = Integer.parseInt(request.getParameter("prd_num"));
		ProductDAO pdao = new ProductDAO();
		ProductDTO product = pdao.getProduct(prd_num);
		
		//가격 원단위 환산
		PriceFormat format = new PriceFormat();
		String price = format.makeCommaWon(product.getPrd_price());
		
		//해당 product에 대한 fileList 객체
		List<FilesDTO> fileList = new ArrayList<FilesDTO>();
		FilesDAO fdao = new FilesDAO();
		fileList = fdao.getFilesListByPrdNum(prd_num);
		
		//member 객체
		String get_id = fileList.get(0).getId();
		MemberDTO member = new MemberDTO();
		MemberDAO mdao = new MemberDAO();
		member = mdao.getMemberById(get_id);
		
		//좋아요 count
		Like_RecordDAO ldao = new Like_RecordDAO();
		int getLike = ldao.getGetLikeById(get_id);
		
		//좋아요 여부
		String send_id = (String)request.getSession().getAttribute("id");
		int checkLike = ldao.checkLike(send_id, get_id);
	
		//prd_state check
		int saleState = pdao.checkSaleState(prd_num);
		
		int currentPage =1; // 현재
		int pageSize = 2; // 한페이지 게시글갯수 
		int maxPage = 0; 
		int chatroomCount=0;
		
		ChatroomDAO chatRoomDAO = new ChatroomDAO();
		chatroomCount = chatRoomDAO.chatRoomCount(prd_num);
		
		if(request.getParameter("currentPage")!=null ) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		if(chatroomCount%pageSize==0) {
			maxPage = chatroomCount /pageSize;
		}else {
			maxPage = (chatroomCount /pageSize)+1;
		}
		
		
		int startPage = ((currentPage -1)/5)*5+1;
		int endPage = startPage + 5 -1;
		if(endPage > maxPage) {
			endPage = maxPage ; 
		}
		System.out.println("List전");
		List<ChatroomDTO> chatRoomDTOs;
		chatRoomDTOs = chatRoomDAO.chatRoomList(prd_num, currentPage,pageSize);
		
		request.setAttribute("chatRoomDTOs", chatRoomDTOs);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("maxPage", maxPage);

		
		
		
		
		
		
		request.setAttribute("product", product);
		request.setAttribute("price", price);
		request.setAttribute("fileList", fileList);
		request.setAttribute("member", member);
		request.setAttribute("getLike", getLike);
		request.setAttribute("checkLike", checkLike);
		request.setAttribute("saleState", saleState);
		
		//이동경로(viewpage)
		viewpage = "ProductDetailPage.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}
	
	private String makeComma(int num) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		String result = formatter.format(num) + "원";
		return result;
	}

}
