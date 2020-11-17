package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ChatroomDAO;

public class AskAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = (String) request.getSession().getAttribute("id");	//SessionID
		int prd_num = Integer.parseInt(request.getParameter("prd_num")); // prd_num
		String ch_title = request.getParameter("title");
		String ch_content = request.getParameter("content");
		System.out.println(id);
		System.out.println(prd_num);
		System.out.println(ch_title);
		System.out.println(ch_content);
		String msg;
		String url;
		
		ChatroomDAO dao = new ChatroomDAO();
		dao.makeChat(ch_title, ch_content, id, prd_num);

		msg = "문의하기 성공"; 
		url = "/ProductDetailPage.Pd?prd_num="+prd_num;
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		ActionForward forward = new ActionForward();
		forward.setPath("Redirect.jsp");
		System.out.println("AskAction 실행 완료");
		return forward;
	}
}
