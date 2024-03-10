package com.lnct.AY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=null;
		Connection con = null;
		Statement st = null;
		
		try {
			//read inputs
			sc = new Scanner(System.in);
			if (sc!=null) {
			String city = null;
			city = sc.next().toUpperCase();
			city = "'"+city+"'";
			
			
			
			
			//Establising the Connection Between the Database and application
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","Abhi");
			//create Statement objeccts
			if(con!=null) {
				st = con.createStatement();
				System.out.println("Connection Establised Successfully");
				//Prepairing Query
				// delete from students where city = 'BHOPAL'; 
				String query = "DELETE FROM STUDENTS WHERE CITY ="+city;
			int temp =0;
				if (st!=null) {
					temp = st.executeUpdate(query);
					if(temp ==0)
					System.out.println("Record not found");
					else 
						System.out.println("No. record are affected "+temp);
				}
			}else
				System.out.println("Connection not Establised");
			}

		} catch (SQLException e) {
			if(e.getErrorCode()>=900 && e.getErrorCode()<=999)
				System.out.println("Invalid Column names or Table names or SQL Query");
	}catch(Exception e) {
		e.printStackTrace();;
	}		finally {
		try {
			if(sc != null)
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		} // sc closed
	
		try {
			if(st != null)
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} // st closed
		try {
			if(con != null)
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} // con closed
	} // finally closed

}// main closedd
	} // class closed

