package kr.or.wic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MessageDAO;
import kr.or.wic.dto.MessageDTO;
import net.sf.json.JSONArray;

public class WriteMsgAction implements Action {

	@Override
	   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	      
	      String id="";
	      if (request.getSession().getAttribute("id") != null) {
	         id = (String) request.getSession().getAttribute("id");         
	      }
	      int ch_num = Integer.parseInt(request.getParameter("ch_num"));
	      String content = request.getParameter("content");
	      MessageDAO dao = new MessageDAO();
	      int result = dao.writeMsg(content, ch_num, id);
	      List<MessageDTO> messageDtoList = null;	      
	      if(result > 0) {
	         messageDtoList = dao.getMessageDTO1(ch_num);
	         System.out.println(messageDtoList);
	      }else {
	         System.out.println("오류 발생!!!!!!!!");
	      }
	      JSONArray msgListJson = JSONArray.fromObject(messageDtoList);
	      response.setContentType("application/x-json; charset=UTF-8");
	      
	      try {
	         response.getWriter().print(msgListJson);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return null;
	   }

}