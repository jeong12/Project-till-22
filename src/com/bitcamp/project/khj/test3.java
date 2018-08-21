package com.bitcamp.project.khj;

import java.util.ArrayList;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> arr=new ArrayList<>();
		arr.add("0,1,2,3,4,5,6");
		arr.add("7,8,9,10,11,12");
		arr.add("13,14,15,16,17,18");
		
		String[] tnumber=new String[arr.size()];
		for(int i=0;i<arr.size();i++) {
			String str=arr.get(i);
			String[] r=str.split(",");
			tnumber[i]=r[0];
		}

		
		for(int k=0;k<tnumber.length;k++) {
			System.out.println(tnumber[k]);
		}
		
		
	}

}
