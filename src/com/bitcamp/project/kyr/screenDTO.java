package com.bitcamp.project.kyr;

public class screenDTO {

	private String bname; //책이름
	private String publish; //출판사
	private int bnum;  //책번호
	private String redate;  //출시일
	// 출시일과 반납예정,반납 시일 은 지금 string으로 할지 무슨타입으로 할지 고민중입니다.
	private int member;  //회원번호
	private String rtdate;   //반납예정일  
	private String rdate; //반납시일
	public screenDTO(String bname,String publish,int bnum,String redate,int member,String rtdate
			,String rdate)
	{
		this.bname=bname;
		this.publish=publish;
		this.bnum=bnum;
		this.redate=redate;
		this.member=member;
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

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getRedate() {
		return redate;
	}

	public void setRedate(String redate) {
		this.redate = redate;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
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
