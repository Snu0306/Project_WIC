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
import kr.or.wic.service.MypageEditAction;

/*
 * 회원 관련 컨트롤러
 */

@WebServlet("*.my")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	String viewpage="";
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(url_Command.equals("mainPage.my")) { //메인페이지 
    		
    	} else if (url_Command.equals("signUpPage.my")) { //회원가입 페이지  
    		
    	} else if (url_Command.equals("signUp.my")) { //회원 가입 
    		
    	} else if (url_Command.equals("signInPage.my")) { //로그인 페이지
    		
    	} else if (url_Command.equals("signIn.my")) { //로그인 
    		
    	} else if (url_Command.equals("signOut.my")) { //로그아웃
    		
    	} else if (url_Command.equals("myPage.my")) { //마이페이지 
    		
    	} else if (url_Command.equals("/myInfoEditPage.my")) { //내 정보 수정 페이지 & 정보 수정 취소 페이지
    		//
    		action=new MypageEditAction();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("myInfoEdit.my")) { //정보 수정하기 
    		
    	} else if (url_Command.equals("myCart.my")) { //찜하기
    		
    	} else if (url_Command.equals("Like.my")) { //좋아요 (사람)
    		
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
