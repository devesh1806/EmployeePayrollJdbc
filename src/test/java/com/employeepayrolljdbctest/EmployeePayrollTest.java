package com.employeepayrolljdbctest;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import com.employeepayrolljdbc.EmployeePayrollJdbc;
import com.employeepayrolljdbc.EmployeePayrollService;

public class EmployeePayrollTest {
	EmployeePayrollJdbc employeePayrollJdbc;
	EmployeePayrollService employeePayrollService;
	
	
	@Test
	public void ifConnection_IsSuccessful_ShouldReturnTrue() {
		employeePayrollJdbc = new EmployeePayrollJdbc();
		Assert.assertTrue(employeePayrollJdbc.dbConnect()!=null);
	}
	
	@Test
	public void ifData_FromDataBase_ShouldReturnSize() throws SQLException{
		employeePayrollService = new EmployeePayrollService();
		String query = "select * from employee;";
		Integer res = employeePayrollService.getQuery(query);
		Assert.assertEquals((Integer)4,res);
	}
}
