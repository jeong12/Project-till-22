package com.bitcamp.project.lsy;

public class basicDTO {
	
	//필드
	private int gender;
	private int height;
	private int weight;
	
	//get, set
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	//생성자
	public basicDTO() {
		
	}
	
	public basicDTO(int gender, int height, int weight) {
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}
	
	

}
