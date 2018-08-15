package com.bitcamp.project.lsy;

import java.util.List;

public class test2 {
	public static void main(String[] args) {
		
	
	calDTO dt = new calDTO();
	calDAO da = new calDAO();
	List<calDTO> arr = da.getList();
	String[]aname=new String[arr.size()]; 
	for(int i=0;i<arr.size();i++) {
		aname[i]=arr.get(i).acode;
	}
	
	for(String r:aname) {
		System.out.println(r);
	}

}
}