package kr.or.wic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.service.CsDeleteAction;
import kr.or.wic.service.CsDetailPageAction;
import kr.or.wic.service.CsEditAction;
import kr.or.wic.service.CsEditPageAction;
import kr.or.wic.service.CsPageAction;
import kr.or.wic.service.CsReWriteAction;
import kr.or.wic.service.CsReWritePageAction;
import kr.or.wic.service.CsWriteAction;
import kr.or.wic.service.CsWritePageAction;

/*
 * 고객센터 관련 컨트롤
 */

@WebServlet("*.cs")
public class CsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CsController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(url_Command.equals("/csPage.cs")) { //고객센터 페이지
    		action = new CsPageAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csWritePage.cs")) { //고객센터 글쓰기 페이지
    		action = new CsWritePageAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csWrite.cs")) { //고객센터 글쓰기
    		action = new CsWriteAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csDetailPage.cs")) { //고객센터 글 상세보기 페이지
    		action = new CsDetailPageAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csEditPage.cs")) { //글 수정하기 페이지
    		action = new CsEditPageAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csEdit.cs")) { //글 수정하기
    		action = new CsEditAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csReWritePage.cs")) { //글 수정하기
    		action = new CsReWritePageAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csReWrite.cs")) { //글 수정하기
    		action = new CsReWriteAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csDelete.cs")) { //글 수정하기
    		action = new CsDeleteAction();
    		forward = action.execute(request, response);
    	} 
    	
    	
    	
    	
    	

    	
    	RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    	dis.forward(request, response);
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
