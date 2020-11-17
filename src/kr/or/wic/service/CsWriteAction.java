package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;

public class CsWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int notice = 0;
		int cs_secret = 0;
		if(request.getParameter("notice") != null) {
			notice = Integer.parseInt(request.getParameter("notice"));
		}
		if(request.getParameter("cs_secret") != null) {
			cs_secret = Integer.parseInt(request.getParameter("cs_secret"));
		}
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
				
		CustomerServiceDAO dao = new CustomerServiceDAO();
		dao.writeCs(id, title, content, notice, cs_secret);
		
		String msg = "글 작성 성공!";
		String url = "/csPage.cs?&currentPage=1&pageSize=10";		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		ActionForward forward = new ActionForward();
		forward.setPath("WEB-INF/views/Redirect.jsp");
		
		return forward;
	}
}
