package com.bitcamp.project.lsy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// 입력
		inputDAO da = new inputDAO();
		inputDTO dt = new inputDTO();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디");
		String dnum = sc.next();
		System.out.println("날짜");
		int data = sc.nextInt();
		System.out.println("음식명");
		String food = sc.next();
		System.out.println("코드");
		String code = sc.next();
		
		dt.setInid(dnum);
		dt.setIndate(data);
		dt.setInmeal(food);
		dt.setIcode(code);
		
		da.InsertData(dt);
		
		// 확인
		List<inputDTO> arr = da.getList();
		Iterator<inputDTO> itr = arr.iterator();
		for(int i=0; i<arr.size(); i++) {
			System.out.println(itr.next().getInid());
		}
		
//		int size = arr.size();
//		for(int i=0; i<size; i++) {
//			arr.get(i);
//			System.out.println(arr.get(i));
//		}

	}

}
