package com.bitcamp.project.kms;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	
	
	public class MemberDAO {

		
		Connection con = null;
		PreparedStatement pstmt = null;
		String ClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://my5509.gabiadb.com:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC";
		String id = "bit504";
		String pw = "bitcamp504*";
		ResultSet rs = null;
		
		
		 public MemberDAO()
		{
			
		}
		
		
		public Connection getCon()
		{
			try {
				Class.forName(ClassName);
				con = DriverManager.getConnection(url, id, pw);
				
				
			}catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		
			return con;
		}

		
		public MemberDTO getMember(String id, String pw) 
		{
  
			
          MemberDTO dto = new MemberDTO();
			
          try {
			con = getCon();
			
			String sql = "select * from pro3_userinfo where id=? && pw=? ";
			
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			
			
			
			rs = pstmt.executeQuery();
			
			  while(rs.next())
			  {
				dto.setId(rs.getString("id"));  
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setCellphone(rs.getString("cellphone"));
				dto.setJumin(rs.getString("jumin"));
		        dto.setNumber(rs.getInt("number"));
		        dto.setJoindate(rs.getString("joindate"));
		        dto.setAge(rs.getString("age"));
		        dto.setGender(rs.getString("gender"));
		        dto.setHeight(rs.getString("height"));
		        dto.setWeight(rs.getString("weight"));
			  }

			 }catch(SQLException e)
             {
				 if(rs!=null)
				try{
					 rs.close();
				 }catch(Exception e1)
				 {
					 e1.printStackTrace();
				 }
		         
				 if(pstmt!=null)
				 try{
					 pstmt.close(); 
				  }catch(Exception e1)
				 {
					  e1.printStackTrace();
				 }
            }
			
			return dto;
			
			
			
		}
	
		
		public MemberDTO get(String id)
		{
			 MemberDTO dto = new MemberDTO();
					
					
			try {
				con = getCon();
				
				String sql = "select * from pro3_userinfo where id = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					dto.setId(rs.getString("id"));  
					dto.setPw(rs.getString("pw"));
					dto.setName(rs.getString("name"));
					dto.setCellphone(rs.getString("cellphone"));
					dto.setJumin(rs.getString("jumin"));
			        dto.setNumber(rs.getInt("number"));
			        dto.setJoindate(rs.getString("joindate"));
			        dto.setAge(rs.getString("age"));
			        dto.setGender(rs.getString("gender"));
			        dto.setHeight(rs.getString("height"));
			        dto.setWeight(rs.getString("weight"));

				}

			}catch(SQLException e)
			{
				if(rs!=null)
					try {
						rs.close();
					}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				if(pstmt!=null)
					try {
						pstmt.close();
					}catch(Exception e2)
				{
						e2.printStackTrace();
				}
			}
			
			return dto;
		}
		
		
		public MemberDTO Number(int number)
		{
			MemberDTO dto = new MemberDTO();
					
					
			try {
				con = getCon();
				
				String sql = "select * from pro3_userinfo where number = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, number);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					dto.setId(rs.getString("id"));  
					dto.setPw(rs.getString("pw"));
					dto.setName(rs.getString("name"));
					dto.setCellphone(rs.getString("cellphone"));
					dto.setJumin(rs.getString("jumin"));
			        dto.setNumber(rs.getInt("number"));
			        dto.setJoindate(rs.getString("joindate"));
			        dto.setAge(rs.getString("age"));
			        dto.setGender(rs.getString("gender"));
			        dto.setHeight(rs.getString("height"));
			        dto.setWeight(rs.getString("weight"));

				}

			}catch(SQLException e)
			{
				if(rs!=null)
					try {
						rs.close();
					}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				if(pstmt!=null)
					try {
						pstmt.close();
					}catch(Exception e2)
				{
						e2.printStackTrace();
				}
			}
			
			return dto;
		}
			
		
		
		
		public void Insert(MemberDTO dto)
		{

			try{
			con = getCon();
			
			String sql = "insert into pro3_userinfo values ( ?,?,?,?,?,?, now(),?,?,?,? ) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getCellphone());
			pstmt.setString(5, dto.getJumin());
            pstmt.setInt(6, dto.getNumber());
            pstmt.setString(7, dto.getAge());
			pstmt.setString(8, dto.getGender());
            pstmt.setString(9, dto.getHeight());
			pstmt.setString(10, dto.getWeight());
			pstmt.executeUpdate();
			
			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally
			{ 
				if(pstmt!=null)
				try{
				    pstmt.close();
 				}catch(Exception e1)
				{
 				 e1.printStackTrace();
				
				}
				
				if(con!=null)
				try{
				   con.close();
				}catch(Exception e2)
				{
					e2.printStackTrace();
				}
					
			}
			
		}
		
		public void Update(MemberDTO dto)
		{
			
			try {
				con = getCon();
				String sql = "Update pro3_userinfo set id=?, pw=?, name=?, cellphone=?,jumin=?,age=?,"
						    + "gender=?,height=?, weight=?"
				            + "where id=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPw());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getCellphone());
				pstmt.setString(5, dto.getJumin());
	            pstmt.setString(6, dto.getAge());
				pstmt.setString(7, dto.getGender());
	            pstmt.setString(8, dto.getHeight());
				pstmt.setString(9, dto.getWeight());
				pstmt.setString(10, dto.getId());
				
				pstmt.executeUpdate();
				
			   }catch(SQLException e)
			{
				   e.printStackTrace();
			}finally
			{
				if(pstmt!=null)
				try{
					pstmt.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				if(con!=null)
				try{
					con.close();
				   }catch(Exception e2)
				{
					e2.printStackTrace();
				}
				
			 }
			
		}
		
		
		
		public void Delete(MemberDTO dto)
		{
			try {
				con = getCon();
				
				String sql = "Delete from practice where id=? && pw=?";
				

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPw());
				
				pstmt.executeUpdate();

			}catch(SQLException e)
			{
				e.printStackTrace();
			}finally {
				if(pstmt!=null)
					try {
						pstmt.close();
					}catch(Exception e1)
				     {
						e1.printStackTrace();
				    }
				     if(con!=null)
				    	 try {
					    		  con.close();
				    	 }catch(Exception e2)
				     {
				    		 e2.printStackTrace();
				     }
			}
			
				
				
		}
	

	}