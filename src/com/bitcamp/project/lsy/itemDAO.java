package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class itemDAO {
	private Connection getConection() {

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
	public void InsertData(inputDTO dto) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConection();
			StringBuilder br = new StringBuilder();
			br.append(    "     insert into pro3_input     "    );
			br.append(    "     value (?,?,?,?)             "    );

			pst = conn.prepareStatement(br.toString());

			pst.setString(1, dto.getInid());
			pst.setDate(2, dto.getIndate());
			pst.setString(3, dto.getInmeal());
			pst.setString(4, dto.getIcode());

			pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);

		}finally {
			close(conn,pst);
		}
		
	}
	private void close(Connection conn, PreparedStatement pst) {
		if(pst!=null) try {pst.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();}catch(SQLException e) {}
	}
}
