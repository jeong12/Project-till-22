package com.bitcamp.project.khj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DAO {

	public Connection getConnection() {

		String ClassName = "com.mysql.jdbc.Driver";
		Connection conn=null;
		String url="jdbc:mysql://my5509.gabiadb.com:3306/database";
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


	public List<String> Cal(){

		ArrayList<String> arr=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		Date today=new Date();
		c2.add(Calendar.MONTH, 1);
		Date month=c2.getTime();
		c1.setTime(today);
		c2.setTime(month);

		int index=0;
		while(c1.compareTo(c2)!=1) {
			arr.add(index,sdf.format(c1.getTime()));
			c1.add(Calendar.DATE,1);
			index++;
		}
		return arr;
	}


	public List<String> year(List<String> arr){
		ArrayList<String> year=new ArrayList<>();

		String s=arr.get(0).toString().substring(0, 3);
		int c=1;
		while(s!=arr.get(c).toString().substring(0, 3)) {
			year.add(arr.get(c).toString().substring(0, 3));
			c++;
		}
		
		return year;
	}

	
	public List<String> date (List<String> arr){
		ArrayList<String> date =new ArrayList<>();

		String s=arr.get(0).toString().substring(4, 5);
		int c=1;
		while(s!=arr.get(c).toString().substring(4, 5)) {
			date.add(arr.get(c).toString().substring(4, 5));
			c++;
		}
		
		return date;
	}
	
	public List<String> day (List<String> arr){
		ArrayList<String> day =new ArrayList<>();

		String s=arr.get(0).toString().substring(6, 7);
		int c=1;
		while(s!=arr.get(c).toString().substring(6, 7)) {
			day.add(arr.get(c).toString().substring(6, 7));
			c++;
		}
		
		return day;
	}
	

	/*	public List<ResultSet> show(){
		PreparedStatement pst=null;
		Connection conn= getConnection();
		ArrayList<ResultSet> arr=new ArrayList<>();
		ResultSet rs=null;
		StringBuilder sb=new StringBuilder();

		return List<ResultSet>
	}*/






}
