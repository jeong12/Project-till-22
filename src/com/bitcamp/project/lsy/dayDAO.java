package com.bitcamp.project.lsy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
	}

	
	// select 
		public dayDTO getdayList(){
			String id ="";
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			dayDTO dto = new dayDTO();
			
			try {
				conn = getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append(    "    select  "    );
				sql.append(    "    sum(case when weekday(indate)=0 then kcal end) as sumMon  "    );
				sql.append(    "    , sum(case when weekday(indate)=1 then kcal end) as sumTue    "   );
				sql.append(    "    , sum(case when weekday(indate)=2 then kcal end) as sumWed    "    );
				sql.append(    "    , sum(case when weekday(indate)=3 then kcal end) as sumThu    "    );
				sql.append(    "    , sum(case when weekday(indate)=4 then kcal end) as sumFri    "    );
				sql.append(    "    , sum(case when weekday(indate)=5 then kcal end) as sumSat    "    );
				sql.append(    "    , sum(case when weekday(indate)=6 then kcal end) as sumSun    "    );
				sql.append(    "    from pro3_input p, pro3_item i  "    );
				sql.append(    "    where p.icode = i.icode  "    );
				sql.append(    "    and yearweek(indate) = yearweek(current_date - interval 7 Day)  "    );
				sql.append(    "    and id = ?;  "    );
				
				pst = conn.prepareStatement(sql.toString());
				pst.setString(1, id);
				rs = pst.executeQuery();
				while(rs.next()) {
					dto.setMon(rs.getInt("sumMon"));
					dto.setTue(rs.getInt("sumTue"));
					dto.setWed(rs.getInt("sumWed"));
					dto.setThu(rs.getInt("sumThu"));
					dto.setFri(rs.getInt("sumFri"));
					dto.setSat(rs.getInt("sumSat"));
					dto.setSun(rs.getInt("sumSun"));
					
					
				}
				
			}catch(SQLException e) {
				System.out.println(e);
			}finally {
				if(rs!=null) try {rs.close();} catch(SQLException e) {}
				close(conn,pst);
			}
//			System.out.println(dto.getTue());
			return dto;
			
		}
		private void close(Connection conn, PreparedStatement pst) {
			if(pst!=null) try {pst.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
}
