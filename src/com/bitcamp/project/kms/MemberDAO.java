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
	
	public MemberDAO() // ���� ���� 
	{
		try {
			Class.forName(ClassName);
			con = DriverManager.getConnection(url, id, pw);
			
			
		}catch(ClassNotFoundException e)
		{
			System.out.println(e+">>�ε����");
		}catch(SQLException e)
		{
			System.out.println(e+">>�������");
		}
	    
	  
	}
	
		public void closeMethod() //�ݱ�
		    {
			if(rs!=null)
			try{
				rs.close();
			}catch(SQLException e)
			{
				System.out.println(e+">>�ݱ����");
			}
			if(ps!=null)
			try{
				ps.close();
			}
			catch(SQLException e)
			{
				System.out.println(e+">>�ݱ����");
			}
  
	    
		}//close
		


	
	public void JoinUser(memberDTO dto)//����
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
				System.out.println("���Լ���");
			   
			}
			else
			{
				System.out.println("���Խ���");
			}
			
		}catch(Exception e)
		{
			System.out.println(e+">>Insert Fail");
		}finally
		{
			closeMethod();
		}
		
	}//joinuser


 public void DeleteUser(memberDTO dto)//����
 {
	
	 try { 
		  String sql = "delete from mydb.pro3_userinfo where id=? pw=?";
		  
		  ps = con.prepareStatement(sql);
		  ps.setString(1, id);
		  ps.setString(2, pw);
		  
		  int r = ps.executeUpdate();
		   
		  if(r>0)
		  {
			  System.out.println("�����Ǿ����ϴ�.");
		  }
		  else
		  {
			  System.out.println("�ٽ� �Է����ּ���");
		  }
		 
	 }catch(Exception e)
	 {
		 System.out.println(e+">>�����߻�");
	 }finally
	 {
		 closeMethod();
	 }
	 
  }


public void UpdateUser(memberDTO dto)//����
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
	    	System.out.println("���� ����");
	    }
	    else
	    {
	    	System.out.println("���� ����");
	    }
	      
	  }catch(Exception e)
	{
		 System.out.println(e+">>�����߻�");
	}finally
	{
		closeMethod();
	}
	
	
 }
 
 
}