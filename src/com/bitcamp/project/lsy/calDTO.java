package com.bitcamp.project.lsy;

public class calDTO {
	//필드
	String acode ;
	String aname;
	String bcode;
	String bname;
	String icode;
	String iname;
	int kcal;
	
	
	//get, set
	public String getAcode() {
		return acode;
	}
	public void setAcode(String acode) {
		this.acode = acode;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getIcode() {
		return icode;
	}
	public void setIcode(String icode) {
		this.icode = icode;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	// 생성자
	
	public calDTO(String acode, String aname, String bcode, String bname, String icode, String iname, int kcal) {
		super();
		this.acode = acode;
		this.aname = aname;
		this.bcode = bcode;
		this.bname = bname;
		this.icode = icode;
		this.iname = iname;
		this.kcal = kcal;
	}
	
	public calDTO() {
		
	}


}// end calDTO
