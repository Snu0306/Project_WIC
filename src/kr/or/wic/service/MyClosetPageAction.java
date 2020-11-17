package kr.or.wic.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CartDAO;
import kr.or.wic.dao.ClosetDAO;
import kr.or.wic.dao.Like_RecordDAO;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dao.ProductDAO;
import kr.or.wic.dto.ClosetDTO;
import kr.or.wic.dto.MemberDTO;
import kr.or.wic.dto.ProductDTO;

public class MyClosetPageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		String id = (String)request.getSession().getAttribute("id");
		
		//회원(name, profile_pic, addr, +@) 정보
		MemberDTO member = new MemberDTO();
		MemberDAO mdao = new MemberDAO();
		member = mdao.getMemberById(id); //해당 회원의 모든 정보
		
		//Like 받은 수
		Like_RecordDAO ldao = new Like_RecordDAO();
		int getLike = ldao.getGetLikeById(id);
		
		//좋아요 여부
		String send_id = (String)request.getSession().getAttribute("id");
		int checkLike = ldao.checkLike(send_id, id);
		
		//closet
		ClosetDTO closet = new ClosetDTO();
		ClosetDAO cdao = new ClosetDAO();
		closet = cdao.getClosetById(id);
		
		//product
		ProductDAO pdao = new ProductDAO();
		List<ProductDTO> productList = pdao.getEachMemberAllProductAndFileList(id);


		//likeList
		List<Integer> likeList = new ArrayList<Integer>();
		CartDAO cartdao = new CartDAO();
		for(ProductDTO product : productList) {
			likeList.add(cartdao.getLikeByPrdnum(product.getPrd_num()));
		}

		//cartProductList
		List<ProductDTO> cartProductList = pdao.getEachMemberAllCartProductAndFileList(id);
		
		//cartLikeList
		List<Integer> cartLikeList =  new ArrayList<Integer>();
		for(ProductDTO product : cartProductList) {
			cartLikeList.add(cartdao.getLikeByPrdnum(product.getPrd_num()));
		}
		
		request.setAttribute("member", member);
		request.setAttribute("getLike", getLike);
		request.setAttribute("closet", closet);
		request.setAttribute("productList", productList);
		request.setAttribute("checkLike", checkLike);
		request.setAttribute("likeList", likeList);
		request.setAttribute("cartProductList", cartProductList);
		request.setAttribute("cartLikeList", cartLikeList);

		viewpage = "MyCloset.jsp";
		forward.setPath(viewpage);
		return forward;
	}
}
