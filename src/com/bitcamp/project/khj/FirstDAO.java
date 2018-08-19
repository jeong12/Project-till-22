package com.bitcamp.project.khj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FirstDAO {

		FirstDTO fdto;
	
		public FirstDAO(FirstDTO fdto) {
			this.fdto=fdto;
		}

		public Connection getConnection() {

		String ClassName = "com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		String url="jdbc:mysql://my5509.gabiadb.com:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user="bit504";
		String password="bitcamp504*";
		PreparedStatement pst=null;

		try {
			Class.forName(ClassName);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println(e);			
		} catch (SQLException e) {
			System.out.println(e);
		} 
		return conn;
	}

	public void close(Connection conn, PreparedStatement pst) {
		if(pst!=null) try {pst.close();} catch(SQLException e) {System.out.println(e);}
		if(conn!=null) try {conn.close();} catch(Exception e) {System.out.println(e);}

	}
	
	
	public HashMap<String,String> getInfor(){
		
		PreparedStatement pst=null;
		Connection conn=getConnection();
		ResultSet rs=null;
		StringBuilder sb=new StringBuilder();
		HashMap<String, String> hm=new HashMap<>();
		
		
		try {
			
			sb.append(   "    select a.tnumber,c.tname,e.sname,a.time,f.sname, b.time,d.fair  "    ); 
			sb.append(   "     from pro3_schedule as a, pro3_schedule as b , pro3_train as c, pro3_sectionfair as d, pro3_station as e, pro3_station as f    "  ); 
			sb.append(   "      where e.snumber=a.snumber and e.sname=  ?          "    );    
			sb.append(   "         and f.snumber=b.snumber and f.sname=  ?       "    ); 
			sb.append( 	"            and a.tnumber = b.tnumber and a.time<b.time      "   );
			sb.append( 	"            and a.time>   ?                                     "    );
			sb.append( 	"            and a.tnumber=c.tnumber                          "    ); 
			sb.append( 	"            and  (d.section = round(abs((b.snumber-a.snumber))/100,0))      "    ); 
			sb.append( 	"            and c.tid = d.tcode        "      ); 
			sb.append( 	"            order by a.time;       "     );

			pst=conn.prepareStatement(sb.toString());
			pst.setString(1, fdto.getDs());
			pst.setString(2, fdto.getAs());
			pst.setString(3, fdto.getdTime());
			
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
			String key=String.valueOf(rs.getInt("a.tnumber"));
			String tname=rs.getString("c.tname");
			String dsname=rs.getString("e.sname");
			String dtime=rs.getString("a.time");
			String asname=rs.getString("f.sname");
			String atime=rs.getString("b.time");
			String fair=String.valueOf(rs.getInt("d.fair"));
			hm.put(key, tname+","+dsname+","+dtime+","+asname+","+atime+","+fair);
			}
			
		
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,pst);
		}
		return hm;
	}


}





