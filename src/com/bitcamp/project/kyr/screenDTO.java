package com.bitcamp.project.kyr;

public class screenDTO {

	private String bname; //å�̸�
	private String publish; //���ǻ�
	private int bnum;  //å��ȣ
	private String redate;  //�����
	// ����ϰ� �ݳ�����,�ݳ� ���� �� ���� string���� ���� ����Ÿ������ ���� ������Դϴ�.
	private int member;  //ȸ����ȣ
	private String rtdate;   //�ݳ�������  
	private String rdate; //�ݳ�����  sysdate�� �� ����
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
