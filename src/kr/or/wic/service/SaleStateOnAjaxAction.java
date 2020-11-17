package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ProductDAO;

public class SaleStateOnAjaxAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int prd_num  = Integer.parseInt(request.getParameter("prd_num"));
		
		ProductDAO pdao = new ProductDAO();
		pdao.updatePrdState(prd_num, 0);
		
		return null;
	}

}
