package kr.or.wic.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dto.MemberDTO;

public class IntoMainPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = new MemberDTO();
		List<MemberDTO> memberList = new ArrayList<>();
		
		memberList = mdao.goodMemberInfo();
		System.out.println(memberList);
		
		request.setAttribute("Top5",memberList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("Main.jsp");
		
		return forward;
	}

}
