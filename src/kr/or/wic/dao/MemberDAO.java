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

import kr.or.wic.dto.MemberDTO;
import kr.or.wic.dto.ProductDTO;

public class MemberDAO {
static DataSource ds;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
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
	
	
	//Mypage - select
	public MemberDTO selectMyPageMember(String id){
		MemberDTO member = new MemberDTO();
		
		try {
			conn = ds.getConnection();
			
			String sql = "select id, name, addr, intro, closet_num from Member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				
				
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				//member.setProcile_pic(rs.getString("procile_pic"));
				member.setIntro(rs.getString("intro"));
				member.setCloset_num(rs.getInt("closet_num"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}
	
	//Mypage - update
	
	
	
}
