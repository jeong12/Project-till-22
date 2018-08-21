package com.bitcamp.project.lsy;

public class bodydata {

	public String getData() {
		bodyDAO dao = new bodyDAO();
		bodyDTO dto = dao.getBodyList("bit002");
		
		double basic;// 기초대사량
		double fat; // 체지방
		String big;

		int wei = dto.getWeight();
		int hei = dto.getHeight();
		int age = dto.getAge();

		if((wei/(hei*hei))<18.5) {
			big = "저체중";

		}else if((wei/(hei*hei))>=18.5&&((wei/(hei*hei))<23)) {
			big = "정상";
		}else if((wei/(hei*hei))>=23&&((wei/(hei*hei))<25)) {
			big = "과체중";
		}else if((wei/(hei*hei))>=25&&((wei/(hei*hei))<30)) {
			big = "비만";
		}else if((wei/(hei*hei))>=30&&((wei/(hei*hei))<35)) {
			big = "고도비만";
		}else
			big = "초고도비만";

		if(dto.getGender().equals("남")){
			// 기초대사량

			basic = 66.47 + (13.75*wei)+(5*hei)-(6.76*age);

			// 체지방

			fat = (wei*1.10)-(128*(wei*wei)/(hei*hei));



		}else {// 여성
			// 기초대사량

			basic = 655.1 + (9.56*wei)+(1.85*hei)-(4.68*age);

			// 체지방

			fat = (wei*1.07)-(128*(wei*wei)/(hei*hei));
			


		}//end else



		String result = " 신장: "+hei+"\n 체중: "+wei+"\n 기초대사량: "+Math.round(basic)+
				"\n 체지방: "+fat+"\n 비만율: "+big;
		return result;

	}
}

