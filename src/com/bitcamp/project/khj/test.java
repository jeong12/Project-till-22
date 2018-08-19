package com.bitcamp.project.khj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test {

	
	public static void main(String[] args) {
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
			//System.out.println(sdf.format(c1.getTime()));
			c1.add(Calendar.DATE,1);
			index++;}
		
		ArrayList<String> y=new ArrayList<>();
		String s=arr.get(0).toString().substring(0,4);
		System.out.println(s);
		int c=0;
		int id=1;
		y.add(0, s);
		while(c<31) {
			if(arr.get(c).toString().substring(0,4).equals(arr.get(c+1).toString().substring(0,4))) {
				c++;
			}
			else{
				y.add(id,arr.get(c+1).toString().substring(0, 4));
				c++;
				id++;
			}
		}
	
			
	}
		
		
		
	
}