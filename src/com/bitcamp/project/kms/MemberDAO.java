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
	
	public MemberDAO() { 
	
	 }
	
		
		
		public Connection getcon() {
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
		return con;
	    
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
		

  public memberDTO getmemberDTO(String id, String pw)
    {
    	memberDTO dto = new memberDTO();
    	
    	try {
            
            con = getcon();
            String sql = "select * from mydb.pro3_userinfo where id=? , pw=?";
     
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pw);
            
            rs = ps.executeQuery();
           
            /*if(rs.next()) // ���⼭ ��� ������ ���µ� �̺κ��� ��� �ؾ����� ����Դϴ�
            {
             dto.setId(rs.getString(id));
             dto.setPw(rs.getString(pw));
             dto.setName(rs.getString(name));
             dto.setCellphone(rs.getString(cellphone));
             dto.setJumin(rs.getString(jumin));
             dto.setAge(rs.getString(age));
             dto.setGender(rs.getString(gender));
             dto.setHeight(rs.getString(height));
             dto.setWeight(rs.getString(weight));
             
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;    
    }
    	
   
	
		
		
		
	
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

	}
 
