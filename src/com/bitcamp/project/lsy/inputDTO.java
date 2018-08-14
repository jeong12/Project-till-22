package com.bitcamp.project.lsy;

import java.sql.Date;

public class inputDTO {
	
	// 필드
	String id;
	int indate;
	String inmeal;
	String icode;
	
	
	// get, set
	public String getInid() {
		return id;
	}
	public void setInid(String id) {
		this.id = id;
	}
	public int getIndate() {
		return indate;
	}
	public void setIndate(int indate) {
		this.indate = indate;
	}
	public String getInmeal() {
		return inmeal;
	}
	public void setInmeal(String inmeal) {
		this.inmeal = inmeal;
	}
	public String getIcode() {
		return icode;
	}
	public void setIcode(String icode) {
		this.icode = icode;
			
	}
	
	// 생성자
	public inputDTO(){
		
	}
	
	public inputDTO(String id, int indate, String inmeal, String icode) {
		this.id = id;
		this.indate = indate;
		this.inmeal = inmeal;
		this.icode = icode;
	}

}//end class
