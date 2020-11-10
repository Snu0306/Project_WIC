package kr.or.wic.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ClosetDAO;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dto.FilesDTO;
import kr.or.wic.dto.MemberDTO;
import kr.or.wic.dto.ProductDTO;

public class MypageEditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			MemberDAO member=new MemberDAO();
			
			
			MemberDTO printMember=member.selectMyPageMember();
			

			request.setAttribute("username", name);
			request.setAttribute("address", addr);
			request.setAttribute("userintro", intro);
			
			ActionForward forward = new ActionForward();
			forward.setPath("MyCloset.jsp");
		
			
			return forward;
		}
	
	}
