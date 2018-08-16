package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class calDAO {

	private Connection getConnection() {
		
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://my5509.gabiadb.com:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "bit504";
		String password = "bitcamp504*";
		Connection conn = null;
		
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(ClassNotFoundException e) {
			System.out.println(e);
			
		} catch(SQLException e) {
			System.out.println(e);
			
		}
		return conn;
		
	}//end getConnection
	

	public List<calDTO> getList(){
		ArrayList<calDTO> arr = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(    "  select a.acode, aname, b.bcode, bname, i.icode, iname, kcal  "    );
			sql.append(    "  from pro3_objecta a, pro3_objectb b, pro3_item i   "    );
			sql.append(    "  where a.acode = b.acode   "    );
			sql.append(    "  and	b.bcode = i.bcode;  "    );
			
			pst = conn.prepareStatement(sql.toString());
			rs = pst.executeQuery();
			while(rs.next()) {
				calDTO dto = new calDTO();
				dto.setAcode(rs.getString("acode"));
				dto.setAname(rs.getString("aname"));
				dto.setBcode(rs.getString("bcode"));
				dto.setBname(rs.getString("bname"));
				dto.setIcode(rs.getString("icode"));
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

}// end class

