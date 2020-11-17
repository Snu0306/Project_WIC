package kr.or.wic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public MessageDTO getMessageDTO(int ch_num) {
		MessageDTO result = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from message where ch_num=?\r\n" + 
					"order by msg_num asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ch_num); 
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result.setMsg_num(rs.getInt("msg_num"));
				result.setMsg_content(rs.getString("msg_content"));
				result.setId(rs.getNString("id"));
				result.setMsg_date(rs.getDate("msg_date"));
				System.out.println(result);
			}
		} catch (SQLException e) {
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
}
