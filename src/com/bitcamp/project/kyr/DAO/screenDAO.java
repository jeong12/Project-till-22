package com.bitcamp.project.kyr.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.swing.JOptionPane;

import com.bitcamp.project.kyr.screenDTO;

public class screenDAO {

	public Connection getCon() {

		String className = "com.mysql.jdbc.Driver";
		String url =  "jdbc:mysql://my5509.gabiadb.com:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC";
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
	public void close(Connection conn, PreparedStatement pstmt) {
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
		sql.append(  " select bname , publish , redate , bnum from pro3_book " );
		conn=getCon();
		try {
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();				
			while(rs.next()) {
				screenDTO dto = 
						
						new screenDTO();
				dto.setBname(rs.getString("bname"));
				dto.setPublish(rs.getString("publish"));
				dto.setRedate(rs.getString("redate"));
				dto.setBnum(rs.getString("bnum"));
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
	public void insert(screenDTO dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		StringBuilder sbl=new StringBuilder();
		conn= getCon();
		try {
			sbl.append(" insert into pro3_book values (?,?,?,?) ");
			pstmt=conn.prepareStatement(sbl.toString());
			pstmt.setString(1 , dto.getBname());
			pstmt.setString(2 , dto.getPublish());
			pstmt.setString(3 , dto.getRedate());
			pstmt.setString(4 , dto.getBnum());
			pstmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "입력 형식에 맞지 않습니다.");
		}finally {
		close(conn,pstmt);
		}
	}
			public int rent(screenDTO dto)
			{
				Connection conn=null;
				StringBuilder sbl=new StringBuilder();
				PreparedStatement pstmt=null;
				int result=0;
				conn=getCon();
				
				try {
					TimeZone jst =TimeZone.getTimeZone("Asia/Seoul");
					Calendar Cal = Calendar.getInstance(jst); 
					
				sbl.append(" insert into pro3_rent values (?,?,Cal.add(Calendar.DATE, 7))");
				pstmt=conn.prepareStatement(sbl.toString());
				pstmt.setString(1, dto.getBnum());
				pstmt.setInt(2, dto.getNumber());
				
				sbl.append(" delete pro3_rent where bnum = ?");
				pstmt=conn.prepareStatement(sbl.toString());
				pstmt.setString(1, dto.getBnum());
				JOptionPane.showMessageDialog(null, "대여가 완료 되었습니다.반납 기한 : "
						+Cal.get(Calendar.YEAR)+"년"+(Cal.get(Calendar.MONTH)+1)+"월"
						+(Cal.get(Calendar.DATE)+7)+"일까지 입니다");
				
				}catch(SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "입력을 잘못하셨거나 대여할 수 있는 책이 없습니다.");
				}finally {
					close(conn,pstmt);
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
					sbl.append(" insert into pro3_retu values (?,?,sysdate()) ");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setString(1, dto.getBnum());
					pstmt.setInt(2, dto.getNumber());
					
					sbl.append(" delete pro3_rent where bnum = ?");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setString(1, dto.getBnum());
					
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(conn,pstmt);
				}
				return result;
			}
		}