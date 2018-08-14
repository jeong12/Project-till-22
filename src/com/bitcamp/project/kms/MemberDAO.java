package com.bitcamp.project.kms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class MemberDAO {

	String ClassName = "com.mysql.jdbc.Driver";
	Connection con = null;
	String url = "jdbc:mysql://my5509.gabiadb.com:3306/database";
	String id = "bit504";
	String pw = "bitcamp504*";
    ResultSet rs = null;
    PreparedStatement ps=null;
	
	public MemberDAO() // 서버 연결 
	{
		try {
			Class.forName(ClassName);
			con = DriverManager.getConnection(url, id, pw);
			
			
		}catch(ClassNotFoundException e)
		{
			System.out.println(e+">>로드실패");
		}catch(SQLException e)
		{
			System.out.println(e+">>연결실패");
		}
	    
	  
	}
	
		public void closeMethod() //닫기
		    {
			if(rs!=null)
			try{
				rs.close();
			}catch(SQLException e)
			{
				System.out.println(e+">>닫기실패");
			}
			if(ps!=null)
			try{
				ps.close();
			}
			catch(SQLException e)
			{
				System.out.println(e+">>닫기실패");
			}
  
	    
		}//close
		


	
	public void JoinUser(memberDTO dto)//가입
	{
	
		
		try {
			String sql = "insert into mydb.pro3_userinfo("+
		                 "id,pw,name,cellphone,jumin,"+
					     ",age geder,height,weight)"+
		                 "values(?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getCellphone());
			ps.setString(5, dto.getJumin());
			ps.setString(8, dto.getAge());
			ps.setString(9, dto.getGender());
			ps.setString(10, dto.getHeight());
			ps.setString(11, dto.getWeight());
			
			int r = ps.executeUpdate();
			
			if(r>0)
			{
				System.out.println("가입성공");
			   
			}
			else
			{
				System.out.println("가입실패");
			}
			
		}catch(Exception e)
		{
			System.out.println(e+">>Insert Fail");
		}finally
		{
			closeMethod();
		}
		
	}//joinuser


 public void DeleteUser(memberDTO dto)//삭제
 {
	
	 try { 
		  String sql = "delete from mydb.pro3_userinfo where id=? pw=?";
		  
		  ps = con.prepareStatement(sql);
		  ps.setString(1, id);
		  ps.setString(2, pw);
		  
		  int r = ps.executeUpdate();
		   
		  if(r>0)
		  {
			  System.out.println("삭제되었습니다.");
		  }
		  else
		  {
			  System.out.println("다시 입력해주세요");
		  }
		 
	 }catch(Exception e)
	 {
		 System.out.println(e+">>오류발생");
	 }finally
	 {
		 closeMethod();
	 }
	 
  }


public void UpdateUser(memberDTO dto)//수정
{
	try {
		String sql = "update mydb.pro3_userinfo set id=?,pw=?,name=?"+
	                 ",cellphone=?,jumin=?,age=?,gender=?,height=?,weight=?";

	   ps= con.prepareStatement(sql);
	   ps.setString(1, dto.getId());
	   ps.setString(2, dto.getPw());
	   ps.setString(3, dto.getName());
		ps.setString(4, dto.getCellphone());
		ps.setString(5, dto.getJumin());
		ps.setString(8, dto.getAge());
		ps.setString(9, dto.getGender());
		ps.setString(10, dto.getHeight());
		ps.setString(11, dto.getWeight());
	
	   int r = ps.executeUpdate();
	   
	    if(r>0)
	    {
	    	System.out.println("수정 성공");
	    }
	    else
	    {
	    	System.out.println("수정 실패");
	    }
	      
	  }catch(Exception e)
	{
		 System.out.println(e+">>오류발생");
	}finally
	{
		closeMethod();
	}
	
	
 }
 
 
}