package kr.or.wic.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ProductDAO;
import kr.or.wic.dto.ProductDTO;

public class ProductSearchPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
		String s =request.getParameter("search");
		ProductDAO pdao = new ProductDAO();
		ArrayList<ProductDTO> alist =pdao.search(s);
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		request.setAttribute("productList", alist);
		
		//이동경로(viewpage)
		viewpage = "WEB-INF/views/ProductListPage.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}
}
