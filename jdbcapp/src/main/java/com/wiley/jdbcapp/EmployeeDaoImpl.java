package com.wiley.jdbcapp;

import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection conn;

	@Override
	public void createEmployee(Employee emp) {
		conn=DBConnection.createDBConnection();
		String query="INSERT INTO employee values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,emp.getId());
			ps.setString(2,emp.getName());
			ps.setDouble(3,emp.getSalary());
			ps.setInt(4,emp.getAge());
			int count=ps.executeUpdate();
			if(count!=0) {
				System.err.println("Employee inserted successfully...!!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getAllEmployees() {
		conn=DBConnection.createDBConnection();
		String query="SELECT * FROM employee";
		
		System.out.println("------------------------------");
		System.out.format("%s\t%s\\t%s\\t","ID","NAME","SALARY","AGE");
		System.out.println("------------------------------");
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.format("%d\t%s\t%f\t%d\\t",rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getInt(4));
				System.out.println("------------------------------");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getEmpById(int id) {
		conn=DBConnection.createDBConnection();
		String query="SELECT * FROM employee WHERE id="+id;
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.format("%d\t%s\t%f\t%d\\t",rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getInt(4));
				System.out.println("------------------------------");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateEmpNameById(int id, String name) {
		conn=DBConnection.createDBConnection();
		String query="UPDATE employee set name=? WHERE id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2,id );
			
			int count=ps.executeUpdate();
			while(count!=0) {
				System.out.println("Employee details updated successfully...!!!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void DeleteEmpById(int id) 
	{
		conn=DBConnection.createDBConnection();
		String query="DELETE employee set name=? WHERE id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,id);
			
			int count=ps.executeUpdate();
			while(count!=0) 
			{
				System.out.println("Employee details deleted successfully...!!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
		

