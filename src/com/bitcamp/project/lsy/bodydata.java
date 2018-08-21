package com.bitcamp.project.lsy;

public class bodydata {

	public String getData() {
		bodyDAO dao = new bodyDAO();
		bodyDTO dto = dao.getBodyList("bit002");
		
		double basic;// ���ʴ�緮
		double fat; // ü����
		String big;

		int wei = dto.getWeight();
		int hei = dto.getHeight();
		int age = dto.getAge();

		if((wei/(hei*hei))<18.5) {
			big = "��ü��";

		}else if((wei/(hei*hei))>=18.5&&((wei/(hei*hei))<23)) {
			big = "����";
		}else if((wei/(hei*hei))>=23&&((wei/(hei*hei))<25)) {
			big = "��ü��";
		}else if((wei/(hei*hei))>=25&&((wei/(hei*hei))<30)) {
			big = "��";
		}else if((wei/(hei*hei))>=30&&((wei/(hei*hei))<35)) {
			big = "����";
		}else
			big = "�ʰ���";

		if(dto.getGender().equals("��")){
			// ���ʴ�緮

			basic = 66.47 + (13.75*wei)+(5*hei)-(6.76*age);

			// ü����

			fat = (wei*1.10)-(128*(wei*wei)/(hei*hei));



		}else {// ����
			// ���ʴ�緮

			basic = 655.1 + (9.56*wei)+(1.85*hei)-(4.68*age);

			// ü����

			fat = (wei*1.07)-(128*(wei*wei)/(hei*hei));
			


		}//end else



		String result = " ����: "+hei+"\n ü��: "+wei+"\n ���ʴ�緮: "+Math.round(basic)+
				"\n ü����: "+fat+"\n ����: "+big;
		return result;

	}
}

