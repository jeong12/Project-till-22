package com.bitcamp.project.kyr;

import com.bitcamp.project.kms.MemberDTO;

public class screenDTO {

	MemberDTO mto=new MemberDTO();
	
	private String bname; //å�̸�
	private String publish; //���ǻ�
	private float bnum;  //å��ȣ
	private String redate;  //�����
	// ����ϰ� �ݳ�����,�ݳ� ���� �� ���� string���� ���� ����Ÿ������ ���� ������Դϴ�.
	private int number;  //ȸ����ȣ
	private String rtdate;   //�ݳ�������  
	private String rdate; //�ݳ�����  sysdate�� �� ����
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