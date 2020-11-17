package kr.or.wic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;
import kr.or.wic.dto.CustomerServiceDTO;

public class CsPageAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String id="";
		if (request.getSession().getAttribute("id") != null) {
			id = (String) request.getSession().getAttribute("id");			
		}
		
		CustomerServiceDAO dao = new CustomerServiceDAO();

		int currentPage = 1; // 현재페이지
		int pageSize = 10; // 페이지 사이즈
		int maxPageCount = 0; // 총 페이지 수
		int csListCount = dao.getCsListCount(); // 총 게시글 수

		// 현재 페이지 재설정
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println();
		}

		// 페이지 사이즈 재설정
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}

		// 총 페이지 수(with 총 게시물 수와 페이지 사이즈)
		if (csListCount % pageSize == 0) {
			maxPageCount = csListCount / pageSize;
		} else {
			maxPageCount = (csListCount / pageSize) + 1;
		}

		int startPage = ((currentPage - 1) / 5) * 5 + 1; // 하단 페이징 시작 번호
		int endPage = startPage + 5 - 1; // 하단 페이징 끝 번호
		if (endPage > maxPageCount) {
			endPage = maxPageCount;
		}

		List<CustomerServiceDTO> csList = dao.getCsList(currentPage, pageSize);

		request.setAttribute("csList", csList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("maxPageCount", maxPageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("id", id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("WEB-INF/views/CsPage.jsp");

		return forward;
	}
}
