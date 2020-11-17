package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dto.MemberDTO;

public class MypageMemberEditPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); 
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		String id = (String)request.getSession().getAttribute("id");
		
		MemberDAO memberdao = new MemberDAO();
		MemberDTO member = memberdao.getMemberById(id);
		
		request.setAttribute("member", member);
		
		viewpage = "WEB-INF/views/myInfoEditPage.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}
}
