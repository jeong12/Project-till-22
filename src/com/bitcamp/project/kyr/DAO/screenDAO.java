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
import java.util.Vector;

import javax.swing.JOptionPane;

import com.bitcamp.project.kyr.screenDTO;

public class screenDAO {

	public Connection getCon() {

		String className = "com.mysql.cj.jdbc.Driver";
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
	public Vector getList(Connection conn)
	{
		PreparedStatement pstmt=null;
		Vector arr=new Vector();
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(  " select bname , publish , redate , bnum from pro3_book " );
		sql.append("order by bnum");
		conn=getCon();
		try {
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();				
			while(rs.next()) {
				Vector vec=new Vector();
				vec.add(rs.getString("bname"));
				vec.add(rs.getString("publish"));
				vec.add(rs.getString("redate"));
				vec.add(rs.getString("bnum"));
				arr.add(vec);
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
	public int insert(screenDTO dto,Connection conn) throws SQLException
	{
		//Connection conn=null;
		PreparedStatement pstmt=null;
		StringBuilder sbl=new StringBuilder();
		conn= getCon();
		int r=0;
		sbl.append(" insert into pro3_book values (?,?,?,?) ");
		try {
			
			pstmt=conn.prepareStatement(sbl.toString());
			pstmt.setString(1 , dto.getBname());
			pstmt.setString(2 , dto.getPublish());
			pstmt.setString(3 , dto.getRedate());
			pstmt.setDouble(4 , dto.getBnum());
			
			r=pstmt.executeUpdate();
		}catch(SQLException e)
		{
			throw e;
	
		}finally {
		close(conn,pstmt);
		}
		return r;
	}
			public int rent(screenDTO dto,Connection conn) throws SQLException
			{
				StringBuilder sbl=new StringBuilder();
				StringBuilder sb2=new StringBuilder();
				PreparedStatement pstmt=null;
				PreparedStatement pstmt2=null;
				int r=0;
				int r1=0;
				conn=getCon();
				try {
					TimeZone jst =TimeZone.getTimeZone("Asia/Seoul");
					Calendar Cal = Calendar.getInstance(jst);
					
					sb2.append(" delete from pro3_book where round(bnum,2) = round(?,2)");
					pstmt2=conn.prepareStatement(sb2.toString());
					pstmt2.setFloat(1, dto.getBnum());
					r1=pstmt2.executeUpdate();
					
					if(r1>0)
					{
					sbl.append(" insert into pro3_rent values (?,?,now()) ");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setFloat(1, dto.getBnum());
					pstmt.setInt(2, dto.getNumber());
					r=pstmt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "�뿩�� �Ϸ� �Ǿ����ϴ�.�ݳ� ���� : "
							+Cal.get(Calendar.YEAR)+"��"+(Cal.get(Calendar.MONTH)+1)+"��"
							+(Cal.get(Calendar.DATE)+7)+"�ϱ��� �Դϴ�");
					}
					else {
						JOptionPane.showMessageDialog(null, "�뿩 �� å�� ����ƾ� �� �� ");
					}
					
				}catch(SQLException e) {
					throw e;
				}finally { 
						close(conn,pstmt2);
				}
				return r+r1;
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
					TimeZone jst =TimeZone.getTimeZone("Asia/Seoul");
					Calendar Cal = Calendar.getInstance(jst); 
					
					sbl.append(" insert into pro3_retu values (?,?,sysdate()) ");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setDouble(1, dto.getBnum());
					pstmt.setInt(2, dto.getNumber());
					
					sbl.append(" delete from pro3_rent where bnum = ?");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setDouble(1, dto.getBnum());
					
					if(result>0) {
						JOptionPane.showMessageDialog(null, "�ݳ��� �Ϸ� �Ǿ����ϴ�.�ݳ� �Ϸ� ��¥: "
								+Cal.get(Calendar.YEAR)+"��"+(Cal.get(Calendar.MONTH)+1)+"��"
								+Cal.get(Calendar.DATE)+"�� �Դϴ�");
					}
					else {
						JOptionPane.showMessageDialog(null, "�ݳ� �� å�� �����Ŵ� ? ");
				}
					
				}catch(SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "�Է��� �߸��ϼ̰ų� �ݳ� �� å�� �����ϴ�.");
				}finally {
					close(conn,pstmt);
				}
				return result;
			}
		}