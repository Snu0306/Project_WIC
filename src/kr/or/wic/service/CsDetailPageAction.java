package kr.or.wic.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;
import kr.or.wic.dto.CustomerServiceDTO;

public class CsDetailPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String sessionId = "";
		if (request.getSession().getAttribute("id") != null) {
			sessionId = (String) request.getSession().getAttribute("id");
		}
		int cs_num = Integer.parseInt(request.getParameter("cs_num")); // 글 번호
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));

		CustomerServiceDAO dao = new CustomerServiceDAO();
		CustomerServiceDTO dto = dao.csDetailPage(cs_num);

		if (dto.getCs_secret() == 1) {
			System.out.println("여기?");
			if (! (sessionId.equals("admin@admin.com") || sessionId.equals(dto.getId()))) {
				request.setAttribute("msg", "비밀글입니다.");
				request.setAttribute("url", "/csPage.cs?currentPage=" + currentPage + "&pageSize=" + pageSize);
				forward.setPath("WEB-INF/views/Redirect.jsp");
			} else {
				dao.csDetailCounting(cs_num);
				request.setAttribute("dto", dto);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("pageSize", pageSize);
				request.setAttribute("sessionId", sessionId);
				forward.setPath("WEB-INF/views/CsDetailPage.jsp");
			}
		}else {
			dao.csDetailCounting(cs_num);
			request.setAttribute("dto", dto);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("sessionId", sessionId);
			forward.setPath("WEB-INF/views/CsDetailPage.jsp");

		}
		return forward;
	}
}
