package kr.or.wic.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;
/* 
@Project : WIC
@File name : MemberEditAction.java
@Date : 2020.11.13
@Author : 문지연
*/
public class MemberEditAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		String adminId = (String)request.getSession().getAttribute("id");

		if(adminId == null || !adminId.equals("admin@admin.com")) {
			viewpage = "Main.jsp";
			forward.setPath(viewpage);
			return forward;
		}
		String uploadpath = request.getSession().getServletContext().getRealPath("upload");
		System.out.println(uploadpath);
		int size = 1024*1024*10;
		MultipartRequest multi=null;
		
		try {
			 multi = new MultipartRequest(
					request, //기존에 있는  request 객체의 주소값 
					uploadpath, //실 저장 경로 (배포경로)
					size, //10M
					"UTF-8",
					new DefaultFileRenamePolicy() //파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경) )
					
					);
			 
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("여긴가?");
		} //파일 업로드 완료
		
		//DAO, DTO 처리
		String name = multi.getParameter("name");
		String addr = multi.getParameter("addr");
		
		Enumeration filenames = multi.getFileNames();	
		String file = (String)filenames.nextElement();
		String profile_pic = multi.getFilesystemName(file);
		
		String id = multi.getParameter("id");
		
		System.out.println(name);
		System.out.println(addr);
		System.out.println(profile_pic);
		System.out.println(id);
		
		MemberDAO memberDao = new MemberDAO();
		memberDao.updateMember(name, addr, profile_pic, id);
		//이동경로(viewpage)
		viewpage = "/managePage.Mg";
		forward.setPath(viewpage);
		
		return forward;
	}
	
}
