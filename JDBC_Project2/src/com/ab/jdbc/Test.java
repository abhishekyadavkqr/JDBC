package com.ab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Test {
	private static final String STUDENT_INSERT_QUERY ="INSERT INTO STUDENT VALUES(?,?,?,?)";
	public static void main(String[] args) {
//		variable declaring 
		Connection con =null;
		PreparedStatement ps = null;
		Scanner sc= null;
		
		try {
			sc = new Scanner(System.in);
//			register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			establising connection  to the database
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","LEARN_JDBC","JDBC");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.43.91:1521:orcl","LEARN_JDBC","JDBC");
			if(con!=null) {
				System.out.println("Connection Established Successfully...");
				ps = con.prepareStatement(STUDENT_INSERT_QUERY);
			}
			else {
				System.out.println("Connection Established UnSuccessfully...");
					return;
			}
				
			if(ps!=null && sc!=null) {
//				read the value from user and save these details in database using pre-compiled SQL query for multiple time.
			System.out.println("How many data wants to store in Database");
			int n = sc.nextInt();
					for(int i =1;i<=n;i++) {
						
						System.out.println("Enter the "+i+" number student details");
						System.out.println("Enter the roll number of student");
						int rollNo = sc.nextInt(); sc.nextLine();
						System.out.println("Enter the name of student");
						String name = sc.nextLine();
						System.out.println("Enter the Address of student");
						String addrs = sc.nextLine();
						System.out.println("Enter the fee of student");
						int fee = sc.nextInt();
						
					
					ps.setInt(1,rollNo); ps.setString(2, name);ps.setString(3, addrs);ps.setInt(4, fee);
					int rs = ps.executeUpdate();
					if(rs == 0) {
					System.out.println("Entered data of student is not saved in the database");
					i--;
					} // if close
					else
						System.out.println("Entered data is successfully saved in the database ");
						
//					
					}//for close
				}//if close
				
				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}// catch close
		finally {
			try {
				if(ps!=null)
					ps.close();
			}//try close
			catch(SQLException se) {
				se.printStackTrace();
			}// catch close
			try {
				if(con!=null)
					con.close();
			}//try close
			catch(SQLException se) {
				se.printStackTrace();
			}// catch close
			try {
				if(sc!=null)
					sc.close();
			}//try close
			catch(Exception se) {
				se.printStackTrace();
			}// 
			
		}//finally close
			
	}
}

