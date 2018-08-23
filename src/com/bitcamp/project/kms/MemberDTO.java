package com.bitcamp.project.kms;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String cellphone;
	private String jumin;
	private String joindate;
	private int number;
	private String age;
	private String gender;
	private String height;
	private String weight;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getJumin() {
		return jumin;
	} 
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", cellphone=" + cellphone + ", jumin=" + jumin
				+ ", joindate=" + joindate + ", number=" + number + ", age=" + age + ", gender=" + gender + ", height="
				+ height + ", weight=" + weight + "]";
	 }
	
	
	
	
}
	