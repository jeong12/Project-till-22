package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class indexb {
	
	private Connection getConnection() {
		
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://my5509.gabiadb.com:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "bit504";
		String password = "bitcamp504*";
		Connection conn = null;
		
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(ClassNotFoundException e){
			System.out.println(e);
			
		} catch(SQLException e){
			System.out.println(e);
			
		}
		return conn;
	}// end getConnection
	
	// 소분류 연결하기
	public String[] getListobb(String str) {
		
		ArrayList<String> arr = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String [] arr1 = null;
		
		try {
			conn = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(    "  select  bname   "      );
			sql.append(    "  from  pro3_objecta a, pro3_objectb b   "      );
		    sql.append(    "  where  a.acode = b.acode   "      );
		    sql.append(    "  and aname = ?   "      );
		    pst = conn.prepareStatement(sql.toString());
		    pst.setString(1,str);
		    rs = pst.executeQuery();
		    
		    while(rs.next()) {
		    	arr.add(rs.getString("bname"));
		    }
		    int size = arr.size();
		    arr1 = new String[size];
		    
		    for(int i=0; i<size; i++) {
		    	arr1[i] = arr.get(i);
		    }
		    System.out.println(arr1);
		
		}catch(SQLException e){
			System.out.println(e);
			
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			close(conn,pst);
			
		}
		return arr1;
		
	}
	private void close(Connection conn, PreparedStatement pst) {
		if(pst!=null) try {pst.close();} catch(SQLException e) {}
		if(conn!=null) try {conn.close();} catch(SQLException e) {}
	}

}
