package kr.or.wic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ChatroomDAO;
import kr.or.wic.dao.MessageDAO;
import kr.or.wic.dto.ChatroomDTO;
import kr.or.wic.dto.MemberDTO;
import kr.or.wic.dto.MessageDTO;

public class ChatRoomAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String SessionId = (String) request.getSession().getAttribute("id");	//SessionID
		String ch_id = request.getParameter("ch_id");	//구매 문의 작성자
		String prd_id = request.getParameter("prd_id");
//		int prd_num = Integer.parseInt(request.getParameter("prd_num"));
		int ch_num = Integer.parseInt(request.getParameter("ch_num"));
		MemberDTO mDto;
		ChatroomDTO cDto;
		MessageDAO messageDao = new MessageDAO();
		MessageDTO messageDto = messageDao.getMessageDTO(ch_num);
		
		if(!(SessionId == ch_id || SessionId == prd_id)) {
			String msg = "접근 권한이 없습니다.";
			String url = "#";		
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			forward.setPath("WEB-INF/views/Redirect.jsp");
			
		}else {
			ChatroomDAO dao = new ChatroomDAO();
			List<Object> dto = dao.getChatroomInfo(ch_num);
			cDto = (ChatroomDTO)dto.get(0);
			mDto = (MemberDTO)dto.get(1);
			request.setAttribute("cDto", cDto);
			request.setAttribute("mDto", mDto);
			request.setAttribute("messageDto", messageDto);
			forward.setPath("WEB-INF/views/CsPage.jsp");
		}
		return forward;
	}
}
