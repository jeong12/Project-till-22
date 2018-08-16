package com.bitcamp.project.lsy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test2 {
	public static void main(String[] args) {
		
	
//	calDTO dt = new calDTO();
//	calDAO da = new calDAO();
//	List<calDTO> arr = da.getList();
//	String[]aname=new String[arr.size()]; 
//	for(int i=0;i<arr.size();i++) {
//		aname[i]=arr.get(i).acode;
//	}
//	
//	
//	for(String r:aname) {
//		System.out.println(r);
//	}
		indexa a = new indexa();
		List<String> li =a.getListoba();
		
		
		int size= li.size();
		String [] arr = new String[size];
		
		for(int i=0; i<size; i++) {
			arr[i]=li.get(i);
		}
		
		for(String oba:li) {
			System.out.println(oba);
		}
		

}
}