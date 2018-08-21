package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dayDAO {

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

	
	// select gender
		public bodyDTO getBodyList(int day){
			ArrayList<dayDTO> arr = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			dayDTO dto = new dayDTO();
			
			try {
				conn = getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append(    "  select sum(kcal) as sumcal "    );
				sql.append(    "  from pro3_input p, pro3_item i  "    );
				sql.append(    "  where p.icode = i.icode   "    );
				sql.append(    "  and weekday(indate) = ?;  "    );
				
				pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, day);
				rs = pst.executeQuery();
				while(rs.next()) {
					
					dto.se
					
				}
				
			}catch(SQLException e) {
				System.out.println(e);
			}finally {
				if(rs!=null) try {rs.close();} catch(SQLException e) {}
				close(conn,pst);
			}
			
			return dto;
			
		}
		private void close(Connection conn, PreparedStatement pst) {
			if(pst!=null) try {pst.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
}
