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

		
		
		
		
		double basic;// ���ʴ�緮
		double fat; // ü����
		String big;


		int wei = dto.getWeight();
		int hei = dto.getHeight();
		int age = dto.getAge();
		System.out.println(wei);
		System.out.println(hei);
		int today = dao.gettodayList(id);
		
		double cm = hei/100.0;//Ű�� m�� ��ȯ 
		System.out.println(cm);
		fat = wei/(cm*cm);
		
		if(fat<18.5) {
			big = "��ü��";

		System.out.println(fat);	
		}else if (fat>=18.5 && fat<23) {
			big = "����";
		}else if (fat>=23 && fat<25) {
			big = "��ü��";
		}else if(fat>=25 && fat<30) {
			big = "��";
		}else if(fat>=30 && fat<35) {
			big = "����";
		}else
			big = "�ʰ���";
		

		if(dto.getGender().equals("��")){
			
			// ���ʴ�緮

			basic = 66.47 + (13.75*wei)+(5*hei)-(6.76*age);

			

		}else {// ����
			
			// ���ʴ�緮

			basic = 655.1 + (9.56*wei)+(1.85*hei)-(4.68*age);

			
		}//end else
	


		
		
		String result = " ����: "+hei+"\n ü��: "+wei+"\n ���ʴ�緮: "+Math.round(basic)+
				"\n ü���� ����: "+Math.round(fat)+"\n ����: "+big+"\n ���� �Է��� �� Į�θ�: "+today;
		

		return result;
		


	}
}

