/*
 * Write a JDBC App that gives employee details (empno, ename, job, sal) 
 * from the "EMP" database table  based on the  initial class of given employees
 *  
 * */

package com.lnct.AY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class index {

	public static void main(String[] args) {
		// Declare the variable
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String initchar = null;
		String query = null;
		;

		try {
			sc = new Scanner(System.in);
			System.out.println("Enter the First character of the Employee Name");
			if (sc != null)
				initchar = sc.next().toUpperCase(); // Taking input and converting it in uppercase
			// Establising the Connection Between the Database and application
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Abhi");
			// create Statement objeccts
			if (con != null) {
				st = con.createStatement();
				System.out.println("Connection Establised Successfully");
			} else
				System.out.println("Connection not Establised");

			// Prepairing SQL Query
			initchar = "'" + initchar + "%'";
			// there are many way to find the details
			// query1 (case 1) ::- SELECT EMPNO, ENAME , JOB, SAL FROM EMP WHERE ENAME LIKE '%A'
			// ------------> it represent last letter of a name is A
			// query2 (case2) ::- SELECT EMPNO, ENAME , JOB, SAL FROM EMP WHERE ENAME LIKE 'A%'
			// ------------> it represent first letter of a name is A
			// query3 (case3) ::- SELECT EMPNO, ENAME , JOB, SAL FROM EMP WHERE ENAME LIKE  '%A%'
			// ------------> it represent those name which is contain A letter
			// query4 (case4) ::- SELECT EMPNO, ENAME , JOB, SAL FROM EMP WHERE ENAME LIKE  '____'
			// ------------> it represent those name which is contain only four(4)  letter
			// query4 (case4) ::- SELECT EMPNO, ENAME , JOB, SAL FROM EMP WHERE   length(ENAME)=4
			// ------------> it represent those name which length is having four(4)  letter
			
			query = "SELECT EMPNO,ENAME,JOB,SAL 	FROM EMP WHERE ENAME LIKE " + initchar;
			// Creating ResultSet object
			rs = st.executeQuery(query);
			// fetching the Result (output) from the Database
			boolean flag = false;
			while (rs.next()) {
				flag = true;
				System.out.println(
						rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getFloat(4));
			}
			if (flag == false)
				System.out.println("No records found");

		} catch (SQLException e) {
			if (e.getErrorCode() >= 900 && e.getErrorCode() <= 999)
				System.out.println("Invalid Column names or Table names or SQL Query");
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			System.out.println("Thank you!");
		}

	}

}
