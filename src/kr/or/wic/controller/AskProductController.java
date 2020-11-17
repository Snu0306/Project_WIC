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
import kr.or.wic.service.AskWriteAction;



@WebServlet("*.askProduct")
public class AskProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AskProductController() {
        super();
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
   	
    	if(url_Command.equals("/write.askProduct")) {
    		action = new AskWriteAction();
    		forward = action.execute(request, response);		
    	}
    	
    	
    	
    	if(forward != null) {
	    	RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
	    	dis.forward(request, response);
    	}
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}