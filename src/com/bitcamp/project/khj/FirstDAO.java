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
			
			sb.append(  "  select aa.tnumber, aa.tname, aa.esname, aa.atime, aa.fsname, aa.btime, bb.fair from  "                     ); 
			sb.append(  " (select a.tnumber,c.tname,e.sname as esname,a.time as atime,f.sname as fsname, b.time as btime, c.tid  "    );
			sb.append(	"  from pro3_schedule as a, pro3_schedule as b , pro3_train as c, pro3_station as e, pro3_station as f  "    ); 
			sb.append(  "  where e.snumber=a.snumber and e.sname=?      "   );    
			sb.append( 	"  and f.snumber=b.snumber and f.sname=?  "   );
			sb.append( 	"  and a.tnumber = b.tnumber and a.time<b.time             "     );
			sb.append( 	"  and a.time>? and a.tnumber=c.tnumber  "     ); 
			sb.append( 	"  order by atime) as aa, (select fair, tcode from pro3_sectionfair    "     );
			sb.append(  "   where section =(select abs(aas.snumber-ds.snumber)/100     "       ); 
			sb.append(  "   from pro3_station as ds, pro3_station as aas where ds.sname=? and aas.sname=?)) as bb "  );
			sb.append(  "  where aa.tid=bb.tcode   "      );
			pst=conn.prepareStatement(sb.toString());
			pst.setString(1, fdto.getDs());
			pst.setString(2, fdto.getAs());
			pst.setString(3, fdto.getDtime());	
			pst.setString(4, fdto.getDs());
			pst.setString(5, fdto.getAs());
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
			String key=String.valueOf(rs.getInt("aa.tnumber"));
			String tname=rs.getString("aa.tname");
			String dsname=rs.getString("aa.esname");
			String dtime=rs.getString("aa.atime");
			String asname=rs.getString("aa.fsname");
			String atime=rs.getString("aa.btime");
			String fair=rs.getString("bb.fair");
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
		sb.append(   "   select count(seat) from pro3_ticketing     "   );
		sb.append(   "   where tnumber=?  and date=?                "   );
		String date=fdto.getYear()+"-"+fdto.getMonth()+"-"+fdto.getDate();
		pst=conn.prepareStatement(sb.toString());
		for(int i=0;i<size;i++) {
		pst.setString(1, tnumber[i]);
		pst.setString(2, date);
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
	
	public int goReserve(FirstDTO fdto, ArrayList<String> count) {
	Connection conn=null;
	PreparedStatement pst=null;
	PreparedStatement pst2=null;
	ArrayList<String> seat=count;
	ResultSet rs=null;
	int size=seat.size();
	int rev;
	int r=0;
	try {
	conn=getConnection();
	StringBuilder sb2=new StringBuilder();
	sb2.append(   "   select count(seat)     "   );
	sb2.append(   "   from pro3_ticketing   "   );
	pst2=conn.prepareStatement(sb2.toString());
	rs=pst2.executeQuery();
	rs.next();
	rev=rs.getInt("count(seat)");
	System.out.println(":::::::");
	System.out.println(rev);
	rev++;
	StringBuilder sb=new StringBuilder();
	sb.append(   "   insert   into   pro3_ticketing     "   );
	sb.append(   "   values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?  )      "   );
	String date=fdto.getYear()+"-"+fdto.getMonth()+"-"+fdto.getDate();
	for(int q=0;q<size;q++) {
	pst=conn.prepareStatement(sb.toString());
	pst.setInt(1, fdto.getMid());
	pst.setString(2, fdto.getDs());
	pst.setString(3, fdto.getAs());
	pst.setInt(4,Integer.parseInt(fdto.getTnumber()));
	pst.setString(5, fdto.getTname());
	pst.setString(6, fdto.getDtime());
	pst.setString(7, fdto.getAtime());
	pst.setInt(8, Integer.parseInt(fdto.getFair()));
	pst.setString(9, seat.get(q));
	pst.setInt(10, rev);
	pst.setString(11, date);
	
	r=pst.executeUpdate();
	rev++;
	}
	}catch(SQLException e) {
		System.out.println(e);
		e.printStackTrace();		
	}finally {
		if(rs!=null) try {rs.close();} catch(Exception e) {};
		close(conn,pst);
	}
	return r;
	}
	
	public ArrayList<String> Seat() {
		Connection conn=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		String seat=null;
		ArrayList<String> count=new ArrayList<>();
		int sc;
		try {
		conn=getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append(   "   select count(seat) from pro3_ticketing     "   );
		sb.append(   "   where tnumber=? and date=?       "   );
		
		String date=fdto.getYear()+"-"+fdto.getMonth()+"-"+fdto.getDate();
		pst=conn.prepareStatement(sb.toString());
		pst.setString(1, fdto.getTnumber());
		pst.setString(2, date);
		rs=pst.executeQuery();
		rs.next();
		sc=rs.getInt("count(seat)");
		System.out.println(sc); //0±îÁö ³ª¿È
		
		int k=sc;
		int e=0;
		int p=sc+Integer.parseInt(fdto.getPerson().substring(0,1));
		StringBuilder sb2=new StringBuilder();
		sb2.append(   "   select seat from pro3_seat     "   );
		sb2.append(   "   where emty=?      "   );
		pst2=conn.prepareStatement(sb2.toString());
		for(;k<p;k++) {
		pst2.setInt(1, k);
		rs2=pst2.executeQuery();
		rs2.next();
		count.add(e, rs2.getString("seat"));
		e++;
		}
		for(String r:count) {
			System.out.println(r);
		}
		
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,pst);
		}
		return count;
				
		
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

	public List<String> getRev(){
		
		
		PreparedStatement pst=null;
		Connection conn=getConnection();
		ResultSet rs=null;
		StringBuilder sb=new StringBuilder();
		ArrayList<String> rev=new ArrayList<>();		
		
		try {
			
			sb.append(  "  select reservation,tnumber,tname,dsname,dtime,asname,atime,fair,seat,date  "                     ); 
			sb.append(  "  from pro3_ticketing "    );
			sb.append(	"  where mid= ? and date>=sysdate()"    ); 

			pst=conn.prepareStatement(sb.toString());
			pst.setInt(1, fdto.getMid());

			rs=pst.executeQuery();
			
			while(rs.next()) {
				String rsv=rs.getString("reservation");
				String tnum=(String.valueOf(rs.getInt("tnumber")));
				String tname=rs.getString("tname");
				String dsname=rs.getString("dsname");
				String dtime=rs.getString("dtime");
				String asname=rs.getString("asname");
				String atime=rs.getString("atime");
				String fair=String.valueOf(rs.getInt("fair"));
				String seat=rs.getString("seat");
				String date=rs.getString("date");
				rev.add(rsv+","+tnum+","+tname+","+dsname+","+dtime+","+asname+","+atime+","+fair+","+seat+","+date);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			close(conn,pst);
		}
		return rev;
		
	}
	
	public int del() {
		Connection conn=null;
		PreparedStatement pst=null;
		int r=0;
		try {
		conn=getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append(   "   delete from pro3_ticketing    "   );
		sb.append(   "   where reservation = ?    "   );
		pst=conn.prepareStatement(sb.toString());
		pst.setString(1, "1");
		r=pst.executeUpdate();

		}catch(SQLException e) {
			System.out.println(e);
			
		}finally {
			close(conn,pst);
		}
		return r;
		}
}




