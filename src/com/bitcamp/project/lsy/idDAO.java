package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class idDAO {

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
		public bodyDTO getBodyList(String id){

			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			bodyDTO dto = new bodyDTO();
			
			try {
				conn = getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append(    "  select *  "    );
				sql.append(    "  from pro3_input   "    );
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
		private void close(Connection conn, PreparedStatement pst) {
			if(pst!=null) try {pst.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
}


