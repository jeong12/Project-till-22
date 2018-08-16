package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class basicDAO {
	
		// ÀÔ·ÂÃ¢
		private Connection getConnetction() {
			
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
		public List<basicDTO> getList(){
			ArrayList<basicDTO> arr = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			try {
				conn = getConnetction();
				StringBuilder sql = new StringBuilder();
				sql.append(    "    select *     "   );
				sql.append(    "    from pro3_adjusted     "   );
				
				pst = conn.prepareStatement(sql.toString());
				rs = pst.executeQuery();
				while(rs.next()) {
					basicDTO dto = new basicDTO();
					
					dto.setGender(rs.getIn("gender"));


					dto.setIcode(rs.getString("icode"));
					arr.add();
					
				}
				
			}catch(SQLException e) {
				System.out.println(e);
				
			}finally {
				if(rs!=null) try {rs.close();}catch(SQLException e) {}
				close(conn,pst);
				
			}
			return arr;
		}
			private void close(Connection conn, PreparedStatement pst) {
				if(pst!=null) try {pst.close();} catch(SQLException e) {}
				if(conn!=null) try {conn.close();}catch(SQLException e) {}
			
			
		}// end getList

}
