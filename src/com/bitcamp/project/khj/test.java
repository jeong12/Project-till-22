package com.bitcamp.project.khj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class test {
public static void main(String[] args) {

	FirstDAO fdao=new FirstDAO();
	FirstDTO dto=new FirstDTO();
	
/*	for(String r:info) {
		System.out.println(r);
	}*/
	
	System.out.println(dto.getAs());
	System.out.println(dto.getDs());
	
	

}}