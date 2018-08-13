package com.bitcamp.project.lsy;

import java.sql.Date;

public class inputDTO {
	
	// 필드
	String inid;
	Date indate;
	String inmeal;
	String initem;
	
	
	// get, set
	public String getInid() {
		return inid;
	}
	public void setInid(String inid) {
		this.inid = inid;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getInmeal() {
		return inmeal;
	}
	public void setInmeal(String inmeal) {
		this.inmeal = inmeal;
	}
	public String getInitem() {
		return initem;
	}
	public void setInitem(String initem) {
		this.initem = initem;
			
	}
	
	// 생성자
	public inputDTO(){
		
	}
	
	public inputDTO(String inid, Date indate, String inmeal, String initem) {
		this.inid = inid;
		this.indate = indate;
		this.inmeal = inmeal;
		this.initem = initem;
	}

}//end class
