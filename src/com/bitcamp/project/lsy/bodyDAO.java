package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bodyDAO {

	private Connection getConnection() {

		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://my5509.gabiadb.com:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "bit504";
		String password = "bitcamp504*";
		Connection conn = null;

		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);

		}catch(ClassNotFoundException e){
			System.out.println(e);

		}catch(SQLException e){
			System.out.println(e);

		}
		return conn;

	}//end getConnection


	// select
	public bodyDTO getBodyList(String id){

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		bodyDTO dto = new bodyDTO();

		try {
			conn = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(    "  select *  "    );
			sql.append(    "  from pro3_userinfo   "    );
			sql.append(    "  where id = ?   "    );

			pst = conn.prepareStatement(sql.toString());
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {

				dto.setId(rs.getString("id"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getInt("height"));
				dto.setWeight(rs.getInt("weight"));
			}

		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			close(conn,pst);
		}

		return dto;

	}


	
	// select today 
	public int gettodayList(String id){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int today = 0;
		

		try {
			conn = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(    "    select sum(kcal) as today  "    );
			sql.append(    "    from pro3_input p, pro3_item i  "    );
			sql.append(    "    where p.icode = i.icode    "   );
			sql.append(    "    and date(indate)=date(now())    "    );
			sql.append(    "    and id = ?    "    );
			

			pst = conn.prepareStatement(sql.toString());
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {

				today = rs.getInt("today");
				
			}

		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			close(conn,pst);
		}
		
		return today;

	}

	
	// select today 
		public List<calDTO> getdayitemList(String id){
			ArrayList<calDTO> arr = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
		
			
			

			try {
				conn = getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append(    "    select iname, kcal  "    );
				sql.append(    "    from pro3_input p, pro3_item i  "    );
				sql.append(    "    where p.icode = i.icode    "   );
				sql.append(    "    and date(indate)=date(now())    "    );
				sql.append(    "    and id = ?    "    );
				
								

				pst = conn.prepareStatement(sql.toString());
				
				pst.setString(1, id);
				rs = pst.executeQuery();
				while(rs.next()) {
					calDTO dto = new calDTO(); //밖에다 선언 하면 같은 것을 가르킴
					dto.setIname(rs.getString("iname"));
					dto.setKcal(rs.getInt("kcal"));
					arr.add(dto);
					
				}

				
			}catch(SQLException e) {
				System.out.println(e);
			}finally {
				if(rs!=null) try {rs.close();} catch(SQLException e) {}
				close(conn,pst);
			}
			
			return arr;

		}
		private void close(Connection conn, PreparedStatement pst) {
			if(pst!=null) try {pst.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}



}
