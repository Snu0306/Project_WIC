package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dto.CustomerServiceDTO;
import kr.or.wic.dto.MemberDTO;

public class CsReWritePageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id="";
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int cs_num =  Integer.parseInt(request.getParameter("cs_num"));
		if(request.getSession().getAttribute("id") != null) {
			id = (String)request.getSession().getAttribute("id");			
		}
		
		CustomerServiceDAO csDao = new CustomerServiceDAO();
		CustomerServiceDTO csDto = csDao.csDetailPage(cs_num);
		
		MemberDAO memberDao = new MemberDAO();
		MemberDTO memberDto = memberDao.getMemberInfoForCs(id);
		
		request.setAttribute("csDto", csDto);
		request.setAttribute("memberDto", memberDto);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		
		ActionForward forward = new ActionForward();
		forward.setPath("WEB-INF/views/CsReWritePage.jsp");
		
		return forward;
	}
}
