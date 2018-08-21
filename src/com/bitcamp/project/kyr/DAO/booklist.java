package com.bitcamp.project.kyr.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class booklist {
	
	public Vector bok()
	{
		
		Vector result=null;
		Connection conn=null;
		
		try {
			screenDAO dao=new screenDAO();
			conn=dao.getCon();
			result=dao.getList(conn);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return  result;
	}

}
