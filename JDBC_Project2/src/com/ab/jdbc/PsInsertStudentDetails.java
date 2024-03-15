package com.ab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PsInsertStudentDetails {
		private static final String INSERT_RECORD= "INSERT INTO STUDENT VALUES(?,?,?,?)"; 
	public static void main(String[] args) {
			
//			variable declaration
		Connection con = null;
		PreparedStatement ps = null;
		Scanner sc = null;
		
		
		try {
			
//				getting input from the end user
			sc = new Scanner(System.in);
			System.out.println("Enter the No. Student..");
			int stu = sc.nextInt();
			while(stu >0) {
			System.out.println("Enter Student Roll Number ::");
			int rollNum = sc.nextInt();
			System.out.println("Enter Student Name ::");
			sc.nextLine();
			String stName = sc.nextLine();
			System.out.println("Enter Student Address ::");
			String stAdd = sc.nextLine();
			System.out.println("Enter Student Fee ::");
			int stFee = sc.nextInt();
			System.out.println(rollNum+"   "+stName+"    "+stAdd+"    "+stFee);
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","learn_jdbc","JDBC");
//			System.exit(1);
			if(con!=null)
				ps=con.prepareStatement(INSERT_RECORD);
			if(ps!=null) {
				ps.setInt(1,rollNum );
				ps.setString(2, stName);
				ps.setString(3, stAdd);
				ps.setInt(4, stFee);
			int flag = 	ps.executeUpdate();
			if(flag==1)
				System.out.println("Record inserted into Database...");
			else 
				System.out.println("Record insertion failed!...");
			}
			stu--;
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
