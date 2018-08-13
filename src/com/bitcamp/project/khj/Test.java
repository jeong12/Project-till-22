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

public class Test {
	public static void main(String[] args) {

	DAO dao=new DAO();
	List<String> arr=dao.Cal();
/*	String[] year=dao.year(arr);
	String[] date=dao.date(arr);
	String[] day=dao.day(arr);
	*/
/*	for(String re:arr) {
		System.out.println(re);
	}*/
	
	ArrayList<String> y=new ArrayList<>();
	String s=arr.get(0).toString().substring(4, 6);
	/*System.out.println(s);*/
	
	int c=0;
	int id=1;
	y.add(0, s);
	while(c<31) {
	if(arr.get(c).toString().substring(4, 6).equals(arr.get(c+1).toString().substring(4, 6))) {
		c++;
	}
	else{
		y.add(id,arr.get(c+1).toString().substring(4, 6));
		c++;
		id++;
	}
	}
	for(String r:y) {
		System.out.println(r);
	}
	
	String[]year1=new String[y.size()];
	int idx=0;
	for(String result:y) {
		year1[idx++]=result;
	}
	
/*	for(String r:year1) {
		System.out.println(r);*/
	}
}

