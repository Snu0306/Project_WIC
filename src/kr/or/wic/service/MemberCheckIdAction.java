package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;

public class MemberCheckIdAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); 
		
		String id = request.getParameter("id");
		
		MemberDAO memberDao = new MemberDAO();
		String result = memberDao.isEmail(id);
		
		request.setAttribute("result", result);
		
		String viewpage = "WEB-INF/views/MemberCheckId.jsp";
		
		ActionForward forward = new ActionForward();
		forward.setPath(viewpage);
		
		return forward;
	}
}