package kr.or.wic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ClosetDAO;
import kr.or.wic.dao.Like_RecordDAO;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dao.ProductDAO;
import kr.or.wic.dto.ClosetDTO;
import kr.or.wic.dto.MemberDTO;
import kr.or.wic.dto.ProductDTO;

public class MemberClosetPageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		String id="";
		ProductDAO pdao = new ProductDAO();
		
		try {
			int prd_num = Integer.parseInt(request.getParameter("prd_num"));
			//id값 받아오기
			id = pdao.getIdByPrdNum(prd_num);
		}catch(NumberFormatException e) {
			id = request.getParameter("id");
		}
		
		//회원(name, profile_pic, addr, +@) 정보
		MemberDTO member = new MemberDTO();
		MemberDAO mdao = new MemberDAO();
		member = mdao.getMemberById(id); //해당 회원의 모든 정보

		//Like 받은 수
		Like_RecordDAO ldao = new Like_RecordDAO();
		int getLike = ldao.getGetLikeById(id);
		
		//closet(closet_num, closet_title, closet_content) 정보
		ClosetDTO closet = new ClosetDTO();
		ClosetDAO cdao = new ClosetDAO();
		closet = cdao.getClosetById(id);
		
		//product 객체 정보
		List<ProductDTO> productList = pdao.getEachMemberAllProductAndFileList(id);
		List<ProductDTO> cartProductList = pdao.getEachMemberAllCartProductAndFileList(id);
		
		//file(file_name) 정보(모든 파일 리스트의 name 중 각 prd_num의 첫번째 파일)
		request.setAttribute("member", member);
		request.setAttribute("getLike", getLike);
		request.setAttribute("closet", closet);
		request.setAttribute("productList", productList);
		request.setAttribute("cartProductList", cartProductList);
		request.setAttribute("ownerId", id);
		
		viewpage = "WEB-INF/views/MyCloset.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}
}
