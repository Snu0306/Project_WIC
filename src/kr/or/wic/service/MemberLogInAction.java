package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dto.MemberDTO;

/* 
@Project : WIC
@File name : LoginAction.java
@Date : 2020.11.11
@Author : 문지연
*/
public class MemberLogInAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		
		String id=request.getParameter("id");
		String pwd=(String) request.getAttribute("pwd");
		MemberDAO memberDao = new MemberDAO();
		MemberDTO memberDto = memberDao.signedIn(id, pwd);
		
		String viewpage="";
		if(memberDto.getId() == null && memberDto.getPwd() == null) {
			viewpage = "WEB-INF/views/loginRegister.jsp";
		} else if(memberDto.getPwd() ==null) {
			viewpage = "WEB-INF/views/loginRegister.jsp";
		} else {
			viewpage = "Main.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("id", memberDto.getId());
			memberDao.loginCount(memberDto.getId());
		}
			
		ActionForward forward = new ActionForward();
		forward.setPath(viewpage);
		
		return forward;
	}
}
