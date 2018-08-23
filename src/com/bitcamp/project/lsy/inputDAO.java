package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class inputDAO {
	// 입력창
	private Connection getConnetction() {
		
		String className = /*"com.mysql.jdbc.Driver"*/"com.mysql.cj.jdbc.Driver";
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
			rs = pst.executeQuery();// 보여주는 것 이기 때문에 resultSet이 리턴값
			while(rs.next()) {
				inputDTO dto = new inputDTO();
				
				dto.setInid(rs.getString("id"));
				dto.setIndate(rs.getDate("indate"));
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
	
	// insert
	public void InsertData(inputDTO dto) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnetction();
			StringBuilder br = new StringBuilder();
			br.append(    "     insert into pro3_input     "    );
			br.append(    "     value (?,now(),?,(select icode             "    );
			br.append(    "    from pro3_item             "    );
			br.append(    "    where iname = ?))             "    );

			
			pst = conn.prepareStatement(br.toString());
			
			pst.setString(1, dto.getInid());
			pst.setString(2, dto.getInmeal());
			pst.setString(3, dto.getInmeal());
			
			pst.executeUpdate();// int 값을 받음
			
			
			
		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			close(conn,pst);
			
		}
	
		
	}// end insertdata

}// end class
