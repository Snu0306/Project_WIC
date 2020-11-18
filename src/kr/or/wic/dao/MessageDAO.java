package kr.or.wic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.wic.dto.MessageDTO;

public class MessageDAO{
   
   static DataSource ds;
   public Connection conn = null;
   public PreparedStatement pstmt = null;
   public ResultSet rs = null;
   
   static {
      InitialContext ctx;
      try {
         ctx = new InitialContext();
         Context envctx = (Context)ctx.lookup("java:comp/env");
         ds = (DataSource)envctx.lookup("/jdbc/oracle");
      } catch (Exception e) {
         System.out.println("look up Fail: " + e.getMessage());
      }
   }
   
   public Date transformDate(String date) {
      SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
      SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
      java.util.Date tempDate = null;
      try {
         tempDate = beforeFormat.parse(date);
      } catch (ParseException e) {
         e.printStackTrace();
      }
      String transDate = afterFormat.format(tempDate);
      Date result = Date.valueOf(transDate);
      return result;
   }
   
   
   
   public List<MessageDTO> getMessageDTO(int ch_num) {
      System.out.println("getmessagedto()에서의 ch_num" + ch_num);
      List<MessageDTO> result = new ArrayList<>();
      System.out.println("dto 진입");

         try {
            conn = ds.getConnection();
            String sql = "select msg_num, msg_content, ch_num,msg_date, id from message where ch_num=? order by msg_num asc";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ch_num);
            rs = pstmt.executeQuery();
            
            String msg = "";
            msg = (rs.next()) ? "rs 있음" : "rs 없음";
            System.out.println(msg);
                  
            
            while(rs.next()) {
               MessageDTO dto = new MessageDTO();
               dto.setMsg_num(rs.getInt("msg_num"));
               //System.out.println(dto.getMsg_num());
               dto.setMsg_content(rs.getString("msg_content"));
               dto.setMsg_date(rs.getString("msg_date")+"");
               dto.setId(rs.getString("id"));
               dto.setCh_num(rs.getInt("ch_num"));
               //System.out.println(dto);
               result.add(dto);
               System.out.println("성공");
            }
         } catch (SQLException e) {
            System.out.println("sql 오류");
            e.printStackTrace();
            System.out.println(e.getMessage());
         } finally {
            try {
               rs.close();
               pstmt.close();
               conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      return result;
   }
   
   public int writeMsg(String content, int ch_num, String id) {
	      int result = 0;
	      try {
	         conn = ds.getConnection();
	         String sql = "insert into message values(message_msg_num.nextval, ?, sysdate, ?, ?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, content);
	         pstmt.setInt(2, ch_num);
	         pstmt.setString(3, id);         
	         result = pstmt.executeUpdate();
	         if(result>0) {
	            System.out.println("msg insert success");
	         }
	      } catch (SQLException e) {
	         System.out.println(e.getMessage());
	         System.out.println("실행 실패");
	         e.printStackTrace();
	      } finally {
	         try {
	            pstmt.close();
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return result;
	   }
   public List<MessageDTO> getMessageDTO1(int ch_num) {
	      System.out.println("getmessagedto()에서의 ch_num" + ch_num);
	      List<MessageDTO> result = new ArrayList<>();
	      System.out.println("dto 진입");

	         try {
	            conn = ds.getConnection();
	            String sql = "SELECT ROWnum AS rnum, a.*  FROM (select msg_num, msg_content, ch_num,msg_date, id from message where ch_num=? ORDER BY msg_num DESC) a WHERE rownum =1";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, ch_num);
	            rs = pstmt.executeQuery();
	            
	            
	            while(rs.next()) {
	               MessageDTO dto = new MessageDTO();
	               dto.setMsg_num(rs.getInt("msg_num"));
	               //System.out.println(dto.getMsg_num());
	               dto.setMsg_content(rs.getString("msg_content"));
	               dto.setMsg_date(rs.getString("msg_date")+"");
	               dto.setId(rs.getString("id"));
	               dto.setCh_num(rs.getInt("ch_num"));
	               //System.out.println(dto);
	               result.add(dto);
	               System.out.println("성공");
	            }
	         } catch (SQLException e) {
	            System.out.println("sql 오류");
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	         } finally {
	            try {
	               rs.close();
	               pstmt.close();
	               conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      return result;
	   }

}