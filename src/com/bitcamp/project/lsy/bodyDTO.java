package com.bitcamp.project.lsy;

public class bodyDTO {
	
	//필드
	private String id;
	private String gender;
	private int age;
	private int weight;
	private int height;
	
	// 생성자
	public bodyDTO(){
		
	}
	
	
	public bodyDTO(String id, String gender, int age, int weight, int height) {
		
	this.id = id;
	this.gender = gender;
	this.age = age;
	this.weight = weight;
	this.height = height;
	}


	//get, set
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
