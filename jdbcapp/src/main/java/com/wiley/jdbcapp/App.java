package com.wiley.jdbcapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
	public static void main( String[] args ) throws SQLException
    {
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement psSkills=null;
		ResultSet rs=null;
		
    	try {
    		DBConnection dbcon=new DBConnection();
    	    conn=DBConnection.createDBConnection();
    		//create statement object
/*    		Statement stmt=conn.createStatement();
    		
    		//MySQL Query
    		String sql="SELECT first_name, last_name,email FROM candidates";
    		
    		ResultSet rs=stmt.executeQuery(sql);
    		
    		while(rs.next())
    		{
    			System.out.println(rs.getString("first_name")+
    					"\t"+rs.getString("last_name")+
    					"\t"+rs.getString("email"));
    		}*/
    		conn.setAutoCommit(false);
    		conn.commit();
    		
    		//insert the candidate
    		String sqlInsert="INSERT INTO candidates(first_name,last_name,dob,phone,emailVALUES(?,?,?,?,?)";
    		ps=conn.prepareStatement(sqlInsert);
    		/*try 
    		{
    			rs.close();
    			stmt.close();
    		}catch(SQLException e)
    		{
    			System.out.println(e.getMessage());
    		}*/
        }catch(SQLException e) 
    	{
        	//In case of exception,roll back the transaction
        	conn.rollback();
        	e.printStackTrace();
        	
        }	
    }
}
    

      
