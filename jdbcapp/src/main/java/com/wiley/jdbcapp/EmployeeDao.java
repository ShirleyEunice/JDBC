package com.wiley.jdbcapp;

public interface EmployeeDao {

	//Create employee
public void createEmployee(Employee emp);
	//Show all employees
public void getAllEmployees();
	//Show employee based on id
public void getEmpById(int id);
	//Update employee
public void UpdateEmpNameById(int id,String name);
	//Delete employee
public void DeleteEmpById(int id);
}
