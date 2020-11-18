package kr.or.wic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MessageDAO;
import kr.or.wic.dto.MessageDTO;
import net.sf.json.JSONArray;

public class MsgListAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
      
      int ch_num  = Integer.parseInt(request.getParameter("ch_num"));

      MessageDAO messageDao = new MessageDAO();
      List<MessageDTO> messageDtoList = messageDao.getMessageDTO(ch_num);
      System.out.println(messageDtoList);
      
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