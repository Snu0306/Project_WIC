package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ChatroomDAO;

public class AskWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String ch_title ="";
		String ch_content ="";
		if(request.getParameter("title") != null) {
			ch_title = request.getParameter("title");
		}
		if(request.getParameter("content") != null) {
			ch_content = request.getParameter("content");
		}
		String id = (String) request.getSession().getAttribute("id");	//SessionID
		int prd_num = Integer.parseInt(request.getParameter("prd_num")); // prd_num

		String msg;
		String url;
		
		ChatroomDAO dao = new ChatroomDAO();
		dao.makeChat(ch_title, ch_content, id, prd_num);

		msg = "문의하기 성공"; 
		url = "/ProductDetailPage.Pd?prd_num="+prd_num;
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		ActionForward forward = new ActionForward();
		forward.setPath("WEB-INF/views/Redirect.jsp");
		return forward;
	}
}
