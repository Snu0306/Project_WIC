package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;

public class CsDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int cs_num = Integer.parseInt(request.getParameter("cs_num"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
				
		CustomerServiceDAO dao = new CustomerServiceDAO();
		int result = dao.deleteCs(cs_num);
		System.out.println(result);
		
		String msg;
		String url;
		
		
		if(result>0) {
			msg = "글 작성 성공!";
			url = "/csPage.cs?&currentPage="+currentPage+"&pageSize="+pageSize;				
		}else {
			msg = "글 작성 실패!";
			url = "/csPage.cs?&currentPage="+currentPage+"&pageSize="+pageSize;			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		ActionForward forward = new ActionForward();
		forward.setPath("WEB-INF/views/Redirect.jsp");
		
		return forward;
	}
}
