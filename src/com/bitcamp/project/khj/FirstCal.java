package com.bitcamp.project.khj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FirstCal {

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

	public String[] year(List<String> arr){
		ArrayList<String> y=new ArrayList<>();

		String s=arr.get(0).toString().substring(0, 4);
		int c=0;
		int id=1;
		y.add(0, s);
		while(c<31) {
			if(arr.get(c).toString().substring(0, 4).equals(arr.get(c+1).toString().substring(0, 4))) {
				c++;
			}
			else{
				y.add(id,arr.get(c+1).toString().substring(0, 4));
				c++;
				id++;
			}
		}
		String[]year=new String[y.size()];
		int idx=0;
		for(String result:y) {
			year[idx++]=result;
		}
		return year;
	}

	public String[] month (List<String> arr){

		ArrayList<String> m =new ArrayList<>();
		String s=arr.get(0).toString().substring(4, 6);
		int c=0;
		int id=1;
		m.add(0, s);
		while(c<31) {
			if(arr.get(c).toString().substring(4, 6).equals(arr.get(c+1).toString().substring(4, 6))) {
				c++;
			}
			else{
				m.add(id,arr.get(c+1).toString().substring(4, 6));
				c++;
				id++;
			}
		}

		String[]month=new String[m.size()];
		int idx=0;
		for(String result:m) {
			month[idx++]=result;
		}
		return month;
	}

	public String[] day (List<String> arr){
		ArrayList<String> days =new ArrayList<>();
		String s=arr.get(0).toString().substring(6, 8);
		int c=0;
		int id=1;
		days.add(0, s);
		while(c<31) {
			if(arr.get(c).toString().substring(4, 6).equals(arr.get(c+1).toString().substring(6, 8))) {
				c++;
			}
			else{
				days.add(id,arr.get(c+1).toString().substring(6, 8));
				c++;
				id++;
			}
		}

		String[]day=new String[days.size()];
		int idx=0;
		for(String result:days) {
			day[idx++]=result;
		}

		return day;
	}

	public String[]time(){

		String[]time=new String[24];

		for(int i=0;i<12;i++) {
			time[i]=i+" (오전"+i+" 시)";
		}
		for(int j=12;j<24;j++) {
			time[j]=j+" (오후"+(j-12)+" 시)";
		}
		return time;

	}

	public String[]Person(){
		String[]person=new String[9];

		for(int i=0;i<9;i++) {
			person[i]=(i+1)+"명";
		}

		return person;
	}

	
	
}
