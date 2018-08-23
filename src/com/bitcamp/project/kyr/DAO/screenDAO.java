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

import com.bitcamp.project.kms.MemberDTO;
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
		sql.append(" order by bnum ");
		conn=getCon();
		try {
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();				
			while(rs.next()) {
				Vector vec=new Vector();
				vec.add(rs.getString("bname"));
				vec.add(rs.getString("publish"));
				vec.add(rs.getString("redate"));
				vec.add(rs.getFloat("bnum"));
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
			pstmt.setFloat(4 , dto.getBnum());
			
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
				StringBuilder sb3=new StringBuilder();
				PreparedStatement pstmt=null;
				PreparedStatement pstmt2=null;
				PreparedStatement pstmt3=null;
				int r1=0;
				int r2=0;
				int r3=0;
				conn=getCon();
				
				MemberDTO mto=new MemberDTO();
				
				try {
					TimeZone jst =TimeZone.getTimeZone("Asia/Seoul");
					Calendar Cal = Calendar.getInstance(jst);
					
					sbl.append(" insert into pro3_rent(bnum,number,rtdate) values (round(?,2),?,now()) ");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setFloat(1, dto.getBnum());
					pstmt.setInt(2, dto.getNumber());
					//pstmt.setInt(2, mto.getNumber());
					r1=pstmt.executeUpdate();
					
					if(r1>0)
					{
					sb3.append(" insert into rttest(number,bname,publish,redate,bnum)  ");
					sb3.append(" select r.number,bname,publish,redate,b.bnum ");
					sb3.append(" from pro3_book b ,pro3_rent r ");
					sb3.append(" where b.bnum=r.bnum and round(b.bnum,2) = round(?,2) ");
					pstmt3=conn.prepareStatement(sb3.toString());
					pstmt3.setFloat(1, dto.getBnum());
					r3=pstmt3.executeUpdate();
					
					if(r3>0)
					{
						sb2.append(" delete from pro3_book where round(bnum,2) = round(?,2)");
						pstmt2=conn.prepareStatement(sb2.toString());
						pstmt2.setFloat(1, dto.getBnum());
						r2=pstmt2.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "대여가 완료 되었습니다.반납 기한 : "
							+Cal.get(Calendar.YEAR)+"년"+(Cal.get(Calendar.MONTH)+1)+"월"
							+(Cal.get(Calendar.DATE)+7)+"일까지 입니다");
					}
					else {
						JOptionPane.showMessageDialog(null, "대여 할 책이 없드아아 ㅜ ㅜ ");
						}
					}
				}catch(SQLException e) {
					throw e;
				}finally { 
						close(conn,pstmt2);
				}
				return r3+r1+r2;
			}
			
			
			public int retu(screenDTO dto,Connection conn) throws SQLException
			{
				StringBuilder sbl=new StringBuilder();
				StringBuilder sb2=new StringBuilder();
				StringBuilder sb3=new StringBuilder();
				StringBuilder sb4=new StringBuilder();
				PreparedStatement pstmt=null;
				PreparedStatement pstmt2=null;
				PreparedStatement pstmt3=null;
				PreparedStatement pstmt4=null;
				int r=0;
				int r2=0;
				int r3=0;
				int r4=0;
				conn=getCon();

				Calendar cal=Calendar.getInstance();			

				try {
					TimeZone jst =TimeZone.getTimeZone("Asia/Seoul");
					Calendar Cal = Calendar.getInstance(jst); 

					sbl.append(" insert into pro3_retu values (?,?,now()) ");
					pstmt=conn.prepareStatement(sbl.toString());
					pstmt.setFloat(1, dto.getBnum());
					pstmt.setInt(2, dto.getNumber());
					r=pstmt.executeUpdate();

					if(r>0) {
						sb2.append(" delete from pro3_rent where round(bnum,2) = round(?,2) ");
						pstmt2=conn.prepareStatement(sb2.toString());
						pstmt2.setFloat(1, dto.getBnum());
						r2=pstmt2.executeUpdate();
					
						if(r2>0)
						{
							sb3.append(" insert into pro3_book(bname,publish,redate,bnum) ");
							sb3.append(" select bname,publish,redate,bnum ");
							sb3.append(" from rttest where round(bnum,2)=round( ? ,2) and number = ? ");
							pstmt3=conn.prepareStatement(sb3.toString());
							pstmt3.setFloat(1, dto.getBnum());
							pstmt3.setInt(2, dto.getNumber());
							r3=pstmt3.executeUpdate();							

							if(r3>0)
							{
								sb4.append(" delete from rttest where round(bnum,2) = round( ? ,2) and number = ? ");
								pstmt4=conn.prepareStatement(sb4.toString());
								pstmt4.setFloat(1, dto.getBnum());
								pstmt4.setInt(2, dto.getNumber());
								r4=pstmt4.executeUpdate();		

								JOptionPane.showMessageDialog(null, "반납이 완료 되었습니다.반납 완료 날짜: "
										+Cal.get(Calendar.YEAR)+"년"+(Cal.get(Calendar.MONTH)+1)+"월"
										+Cal.get(Calendar.DATE)+"일 입니다");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "반납 할 책이 없으신대 ? ");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "반납 할 책이 없으신대 ? ");
				}
					
				}catch(SQLException e) {
					throw e;
				}finally {
					close(conn,pstmt);
				}
				return r+r2;
			}
		}