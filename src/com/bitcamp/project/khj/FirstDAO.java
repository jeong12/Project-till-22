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
	
	
	public List<String> getInfor(){
		
		PreparedStatement pst=null;
		Connection conn=getConnection();
		ResultSet rs=null;
		StringBuilder sb=new StringBuilder();
		ArrayList<String> info=new ArrayList<>();		
		
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
			pst.setString(3, fdto.getDtime());
			
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
			String key=String.valueOf(rs.getInt("a.tnumber"));
			String tname=rs.getString("c.tname");
			String dsname=rs.getString("e.sname");
			String dtime=rs.getString("a.time");
			String asname=rs.getString("f.sname");
			String atime=rs.getString("b.time");
			String fair=rs.getString("d.fair");
			info.add(key+","+tname+","+dsname+","+dtime+","+asname+","+atime+","+fair);
			}
			
		
		
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,pst);
		}
		return info;
	}

	public ArrayList<String> getSeat(List<String> info) {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		List<String> test=getInfor();
		int size=test.size();
		String[]tnumber=new String[size];
		int empty=0;
		ArrayList<String> em=new ArrayList<>();
		
		for(int i=0;i<size;i++) {
			String str=test.get(i);
			String[] r=str.split(",");
			tnumber[i]=r[0];
		}

		try {
		conn=getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append(   "   select count(seat) from pro3_seat     "   );
		sb.append(   "   where tnumber=? and checked=0;        "   );
		
		pst=conn.prepareStatement(sb.toString());
		for(int i=0;i<size;i++) {
		pst.setString(1, tnumber[i]);
		rs=pst.executeQuery();
		rs.next();
		empty=rs.getInt("count(seat)");
		em.add(String.valueOf(empty));
		}
		
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,pst);
		}
		return em;
	}
	
	public int goReserve(FirstDTO fdto) {
	Connection conn=null;
	PreparedStatement pst=null;
	int r=0;
	try {
	conn=getConnection();
	StringBuilder sb=new StringBuilder();
	sb.append(   "   insert   into   pro3_ticketing     "   );
	sb.append(   "   values( ?, ?, ?, ?, ?, ?,?, ?, ?, ?)      "   );
	
	pst=conn.prepareStatement(sb.toString());
	
	pst.setInt(1, 123456);
	pst.setString(2, fdto.getDs());
	pst.setString(3, fdto.getAs());
	pst.setInt(4,Integer.parseInt(fdto.getTnumber()));
	pst.setString(5, fdto.getTname());
	pst.setString(6, fdto.getDtime());
	pst.setString(7, fdto.getAtime());
	pst.setString(8, fdto.getFair());
	pst.setString(9, "1Έν");
	pst.setString(10, "1A");
	
	
	
	r=pst.executeUpdate();
	
	}catch(SQLException e) {
		System.out.println(e);
		e.printStackTrace();		
	}finally {
		
		close(conn,pst);
	}
	System.out.println("================r");
	System.out.println(r);
	return r;
	}

	
	public String Seat() {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		ArrayList<String> s=new ArrayList<>();
		String seat=null;
		try {
		conn=getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append(   "   select seat from pro3_seat     "   );
		sb.append(   "   where tnumber=? and checked=0;        "   );
		
		pst=conn.prepareStatement(sb.toString());
		pst.setString(1, fdto.getTnumber());
		rs=pst.executeQuery();
		rs.next();
		s.add(rs.getString("seat"));
		
		seat=s.get(0);
		
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,pst);
		}
		return seat;
				
		
	}	

	public List<String> Final(FirstDTO fdto){
	
	PreparedStatement pst=null;
	Connection conn=getConnection();
	ResultSet rs=null;
	StringBuilder sb=new StringBuilder();
	ArrayList<String> result=new ArrayList<>();
	
	
	try {		
		sb.append(   "    select f.sname,c.tname,d.fair, b.time, a.time  "    ); 
		sb.append(   "     from pro3_schedule as a, pro3_schedule as b , pro3_train as c, pro3_sectionfair as d, pro3_station as e, pro3_station as f    "  ); 
		sb.append(   "     where e.snumber=a.snumber and e.sname=?      "    );    
		sb.append(   "     and f.snumber=b.snumber and f.sname=?        "    ); 
		sb.append( 	"      and a.tnumber = b.tnumber and a.time<b.time     "   );
		sb.append( 	"      and a.tnumber=c.tnumber                              "    );
		sb.append( 	"      and  (d.section = round(abs((b.snumber-a.snumber))/100,0))                     "    ); 
		sb.append( 	"      and c.tid = d.tcode     "    ); 
		sb.append( 	"      and c.tnumber=?       "      ); 
		sb.append( 	"      order by a.time, b.time         "     );

		pst=conn.prepareStatement(sb.toString());

		pst.setString(1, fdto.getDs());
		pst.setString(2, fdto.getAs());
		pst.setString(3, fdto.getTnumber());
		
		rs=pst.executeQuery();
		while(rs.next()) {
			
			String as=rs.getString("f.sname");
			String at=rs.getString("b.time");
			String tname=rs.getString("c.tname");
			String fair=rs.getString("d.fair");
			String dt=rs.getString("a.time");

			result.add(as);
			result.add(at);
			result.add(tname);
			result.add(fair);
			result.add(dt);
			
			fdto.setAs(as);
			fdto.setAtime(at);
			fdto.setTname(tname);
			fdto.setFair(fair);
			fdto.setDtime(dt);
	
			
		}
		
		
	}catch(SQLException e) {
		System.out.println(e);
	}finally {
		if(rs!=null) try {rs.close();} catch(Exception e) {};
		close(conn,pst);
	}
	return result;
}



}


