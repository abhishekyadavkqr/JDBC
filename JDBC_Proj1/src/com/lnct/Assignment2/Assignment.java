/*
 * write a JDBC App to get Student details based on given three city names. 
 * */

package com.lnct.Assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {
		// variable declaration
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		String city1 = null, city2 = null, city3 = null;
		ResultSet rs = null;

		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				// read inputs
				System.out.print("Enter the first city name :: ");
				city1 = sc.next();
				System.out.print("Enter the second city name :: ");
				city2 = sc.next();
				System.out.print("Enter the third city name :: ");
				city3 = sc.next();
				// prepairing city names as required for SQL Query
				city1 = "'" + city1.toUpperCase() + "'";
				city2 = "'" + city2.toUpperCase() + "'";
				city3 = "'" + city3.toUpperCase() + "'";
			} // if close
				// establising the Connection between Database software to Application
				// Class.forName("oracle.jdbc.driver.OracleDriver");
				// oracle.jdbc.driver.OracleDriver driver = new
				// oracle.jdbc.driver.OracleDriver();
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "learn_jdbc", "JDBC");
			// create Statement object
			if (con != null)
				st = con.createStatement();

			// Prepairing SQL Query
			// SQL> select id, name, city from students where city in
			// ('NAGPUR','BHOPAL','HYDERABAD');
			String query = "SELECT ID, NAME, CITY FROM STUDENTS WHERE CITY IN (" + city1 + "," + city2 + "," + city3
					+ ")";
			System.out.println(query);
			// Creating ResultSet Object for Sending and Executing the SQL Query
			if (st != null)
				rs = st.executeQuery(query);
			// Displaying the Record on the Console
			boolean flag = false;
			while (rs.next()) {
				flag = true;
				System.out.println(rs.getInt(1) + "		" + rs.getString(2) + "			" + rs.getString(3));
			} // while close
			if (flag == false)
				System.out.println("Record Not Found!");

		} // try close
		catch (SQLException se) {
			if (se.getErrorCode() >= 900 && se.getErrorCode() <= 999)
				System.out.println("Invalid Column names or Table names or SQL Query");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} // catch close
		finally {
			try {
				if (sc != null)
					sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			} // sc closed
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // rs closed
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // st closed
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // con closed
		} // finally close

	}// main close

} // class close
