package com.bitcamp.project.kyr.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.bitcamp.project.kyr.screenDTO;


public class screenDAO {


	private Connection getCon() {

		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.73:3306/mydb";
		String user = "bit504";
		String password = "bitcamp504*";
		Connection conn = null;

		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}
	private void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public List<screenDTO> getList()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ArrayList<screenDTO> arr=new ArrayList<>();
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(  " select bname , publish , redate from pro3_book " );
			
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();				
			while(rs.next()) {
				screenDTO dto = new screenDTO();
				dto.setBname(rs.getString("bname"));
				dto.setPublish(rs.getString("publish"));
				dto.setRedate(rs.getString("redate"));
				arr.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
					this.close(conn, pstmt);	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}				
		}
		return arr;
	}
	
	public int insert(screenDTO dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		StringBuilder sbl=new StringBuilder();
		conn= getCon();
		int result=0;
		try {
			sbl.append(" INSERT INTO PRO3_BOOK VALUES (?,?,?,?) ");
			pstmt=conn.prepareStatement(sbl.toString());
			pstmt.setString(1 , dto.getBname());
			pstmt.setString(2 , dto.getPublish());
			pstmt.setString(3 , dto.getRedate());
			pstmt.setInt(4 , dto.getBnum());
			result=pstmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
		close(conn,pstmt);
		}
		return result ;
	}
		
			public int rent(screenDTO dto)
			{
				Connection conn=null;
				StringBuilder sbl=new StringBuilder();
				PreparedStatement pstmt=null;
				int result=0;
				conn=getCon();
				
				Calendar Cal = Calendar.getInstance(); 
				
				
				try {
				sbl.append(" INSERT INTO PRO3_RENT VALUES (?,?,Cal.add(Calendar.DATE, 7))");
				pstmt=conn.prepareStatement(sbl.toString());
				pstmt.setInt(1, dto.getBnum());
				pstmt.setInt(2, dto.getNumber());
				
				sbl.append(" DELETE PRO3_BOOK WHERE BNUM = ?");
				pstmt=conn.prepareStatement(sbl.toString());
				pstmt.setInt(1, dto.getBnum());
				
				}catch(SQLException e) {
					e.printStackTrace();
					System.out.println("입력을 잘못하셨거나 대여할 수 있는 책이 없습니다.");
				}
				return result;
			}
			
			
			public int retu(screenDTO dto)
			{
				Connection conn=null;
				StringBuilder sbl=new StringBuilder();
				PreparedStatement pstmt=null;
				int result=0;
				conn=getCon();
				
				Calendar cal=Calendar.getInstance();
				
				try {
					sbl.append(" INSERT INTO PRO3_RETU VALUES (?,?,sysdate)");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setInt(1, dto.getBnum());
					pstmt.setInt(2, dto.getNumber());
					
					sbl.append(" DELETE PRO3_RENT WHERE BNUM = ?");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setInt(1, dto.getBnum());
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return result;
			}
		
		}
