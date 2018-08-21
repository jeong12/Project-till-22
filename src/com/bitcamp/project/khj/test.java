package com.bitcamp.project.khj;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> arr=new ArrayList<>();
		for(int i=0;i<21;i++) {
			arr.add(i);
		}
			
		int size=arr.size()/7;
		int[] first =new int[(size)];
		int[] second=new int [(size)];
		int[] third=new int [(size)];
		int[] forth=new int [(size)];
		int[] fifth=new int [(size)];
		int[] sixth=new int [(size)];
		int[] seventh=new int [(size)];
		
		int k=0;
		int r=0;
		
		while(k<size) {
		first[k]=arr.get(r);
		second[k]=arr.get(r+1);
		third[k]=arr.get(r+2);
		forth[k]=arr.get(r+3);
		fifth[k]=arr.get(r+4);
		sixth[k]=arr.get(r+5);
		seventh[k]=arr.get(r+6);
		k++;
		r+=7;
		}

		for(int a=0;a<first.length;a++) {
			System.out.println(first[a]);
		}
		
		
		
	}

}
