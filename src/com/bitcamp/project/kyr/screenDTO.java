package com.bitcamp.project.kyr;

import com.bitcamp.project.kms.MemberDTO;

public class screenDTO {

	MemberDTO mto=new MemberDTO();
	
	private String bname; //책이름
	private String publish; //출판사
	private float bnum;  //책번호
	private String redate;  //출시일
	// 출시일과 반납예정,반납 시일 은 지금 string으로 할지 무슨타입으로 할지 고민중입니다.
	private int number;  //회원번호
	private String rtdate;   //반납예정일  
	private String rdate; //반납시일  sysdate로 할 예정
	public screenDTO(String bname,String publish,float bnum,String redate,int number,String rtdate
			,String rdate)
	{
		this.bname=bname;
		this.publish=publish;
		this.bnum=bnum;
		this.redate=redate;
		this.number=number;
		this.rtdate=rtdate;
		this.rdate=rdate;
	}
	public screenDTO()
	{
		
	}
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public float getBnum() {
		return bnum;
	}

	public void setBnum(float bnum) {
		this.bnum = bnum;
	}

	public String getRedate() {
		return redate;
	}

	public void setRedate(String redate) {
		this.redate = redate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRtdate() {
		return rtdate;
	}

	public void setRtdate(String rtdate) {
		this.rtdate = rtdate;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
}