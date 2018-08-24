package com.bitcamp.project.lsy;

import java.util.ArrayList;
import java.util.List;

public class bodydata {
	
	String id = "";


	public bodydata(String id) {
		this.id = id;
	}




	public String getData(String id) {
		
//		System.out.println("getData ID :::"+id);
		
		bodyDAO dao = new bodyDAO();
		bodyDTO dto = dao.getBodyList(id);

		
		
		
		
		double basic;// 기초대사량
		double fat; // 체지방
		String big;


		int wei = dto.getWeight();
		int hei = dto.getHeight();
		int age = dto.getAge();
		System.out.println(wei);
		System.out.println(hei);
		int today = dao.gettodayList(id);
		
		double cm = hei/100.0;//키를 m로 변환 
		System.out.println(cm);
		fat = wei/(cm*cm);
		
		if(fat<18.5) {
			big = "저체중";

		System.out.println(fat);	
		}else if (fat>=18.5 && fat<23) {
			big = "정상";
		}else if (fat>=23 && fat<25) {
			big = "과체중";
		}else if(fat>=25 && fat<30) {
			big = "비만";
		}else if(fat>=30 && fat<35) {
			big = "고도비만";
		}else
			big = "초고도비만";
		

		if(dto.getGender().equals("남")){
			
			// 기초대사량

			basic = 66.47 + (13.75*wei)+(5*hei)-(6.76*age);

			

		}else {// 여성
			
			// 기초대사량

			basic = 655.1 + (9.56*wei)+(1.85*hei)-(4.68*age);

			
		}//end else
	


		
		
		String result = " 신장: "+hei+"\n 체중: "+wei+"\n 기초대사량: "+Math.round(basic)+
				"\n 체질량 지수: "+Math.round(fat)+"\n 비만율: "+big+"\n 오늘 입력한 총 칼로리: "+today;
		

		return result;
		


	}
}

