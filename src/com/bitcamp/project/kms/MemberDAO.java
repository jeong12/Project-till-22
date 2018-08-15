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
			System.out.println(e+">>로드실패");
		}catch(SQLException e)
		{
			System.out.println(e+">>연결실패");
		}
		return con;
	    
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
           
            /*if(rs.next()) // 여기서 계속 에러가 나는데 이부분을 어떻게 해야할지 고민입니다
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

	}
 
