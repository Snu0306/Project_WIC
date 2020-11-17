package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ChatroomDAO;

public class AskPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");	//SessionID	
		int prd_num = Integer.parseInt(request.getParameter("prd_num")); // prd_num
		System.out.println(id);
		System.out.println(prd_num);
		request.setAttribute("prd_num", prd_num);
		request.setAttribute("id", id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("WEB-INF/views/askProduct.jsp");
		System.out.println("askPageAction 실행 완료");
		return forward;
	}
}
