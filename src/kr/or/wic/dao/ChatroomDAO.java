package kr.or.wic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.wic.dto.ChatroomDTO;
import kr.or.wic.dto.MemberDTO;

public class ChatroomDAO {
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
   
   public List<Object> getChatroomInfo(int ch_num) {
      
      ChatroomDTO cDto = null;
      MemberDTO mDto = null; 
      List<Object> result = new ArrayList<Object>();
      try {
         conn = ds.getConnection();
         String sql = "select * from chatroom c, member m where c.id=m.id and c.ch_num=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, ch_num);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            cDto.setCh_num(rs.getInt("CH_NUM"));
            cDto.setCh_title(rs.getString("CH_TITLE"));
            cDto.setCh_content(rs.getString("CH_CONTENT"));
            cDto.setCh_date(rs.getDate("CH_DATE"));
            cDto.setPrd_num(rs.getInt("PRD_NUM"));
            mDto.setId(rs.getString("ID"));
            mDto.setName(rs.getString("NAME"));
            mDto.setAddr(rs.getString("ADDR"));
            System.out.println(cDto);
            System.out.println(mDto);
            result.add(cDto);
            result.add(mDto);
         }
      } catch (SQLException e) {
         System.out.println("오류발생!!!!!!");
         System.out.println(e.getMessage());
         e.printStackTrace();
      }finally {
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
   
   public void makeChat(String cs_title, String cs_content, String id, int prd_num) {
      try {
         conn = ds.getConnection();
         String sql = "insert into chatroom values(CHATROOM_CH_NUM.nextval,?,?,sysdate,?,?)";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, cs_title);
         pstmt.setString(2, cs_content);
         pstmt.setInt(3, prd_num);
         pstmt.setString(4, id);
         rs = pstmt.executeQuery();
         System.out.println("makeChat() 성공");
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         System.out.println("makeChat() 실패");
         e.printStackTrace();
      }finally {
         try {
            rs.close();
            pstmt.close();
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   
   public int chatRoomCount(int prd_num) {
      int result = 0;
      try {
         conn = ds.getConnection();
         String sql = "select count(*) from CHATROOM where prd_num =?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, prd_num);
         rs = pstmt.executeQuery();

         if (rs.next()) {
            result = rs.getInt(1);
            System.out.println(result);
            System.out.println("chatRoomCoun 실행완료");
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         System.out.println(" chatRoomCoun 오류");
      } finally {
         try {
            rs.close();
            pstmt.close();
            conn.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return result;
   }

   public List<ChatroomDTO> chatRoomList(int prd_num, int currentPage, int pageSize) {
      System.out.println("dao 진입 완료");
      int startRow = (currentPage - 1) * pageSize + 1;
      int endRow = startRow + pageSize - 1;
      List<ChatroomDTO> result = new ArrayList<ChatroomDTO>();
      try {
         conn = ds.getConnection();
         String sql = "select * from\n" + "(select ROWNUM as rnum, cm.* from\n"
               + "(select c.ch_num , c.ch_title , m.name from \n"
               + "chatroom c, member m WHERE c.id = m.id and prd_num=?\n" + "order by c.ch_num desc)cm)\n"
               + "where ? <= rnum and rnum  <= ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, prd_num);
         pstmt.setInt(2, startRow);
         pstmt.setInt(3, endRow);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            ChatroomDTO dto = new ChatroomDTO();
            dto.setCh_num(rs.getInt("ch_num"));
            System.out.println(dto.getCh_num());
            dto.setCh_title(rs.getString("ch_title"));
            System.out.println(dto.getCh_title());
            dto.setName(rs.getString("name"));
            System.out.println(dto.getName());
            result.add(dto);
            System.out.println(dto);
         }

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println(e.getMessage());
         e.printStackTrace();
         System.out.println(" chatRoomList 오류");
      } finally {
         try {
            rs.close();
            pstmt.close();
            conn.close();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      }
      return result;
   }

   
   
}