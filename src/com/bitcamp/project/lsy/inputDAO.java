package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class inputDAO {
	private Connection getConnetction() {
		
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://my5509.gabiadb.com:3306/mydb";
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

	public List<inputDTO> getList(){
		ArrayList<inputDTO> arr = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = getConnetction();
			StringBuilder sql = new StringBuilder();
			sql.append(    "    select *     "   );
			sql.append(    "    from pro3_input     "   );
			
			pst = conn.prepareStatement(sql.toString());
			rs = pst.executeQuery();
			while(rs.next()) {
				inputDTO dto = new inputDTO();
				
				dto.setInid(rs.getString("inid"));
				dto.setIndate(rs.getInt("indate"));
				dto.setInmeal(rs.getString("inmeal"));
				dto.setIcode(rs.getString("icode"));
				arr.add(dto);
				
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
		
	public int InsertData(inputDTO dto) {
		Connection conn = null;
		PreparedStatement pst = null;
		int a = 0;
		try {
			conn = getConnetction();
			StringBuilder br = new StringBuilder();
			br.append(    "     insert in to pro3_input     "    );
			br.append(    "     value (?,?,?,?)     "    );
			
			pst = conn.prepareStatement(br.toString());
			
			pst.setString(1, dto.getInid());
			pst.setInt(2, dto.getIndate());
			pst.setString(3, dto.getInmeal());
			pst.setString(4, dto.getIcode());
			
			a = pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			close(conn,pst);
		}
		return a;
		
	}// end insertdata

}// end class
