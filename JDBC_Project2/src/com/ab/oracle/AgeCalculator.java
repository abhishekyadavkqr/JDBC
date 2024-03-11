package com.ab.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {
private static final String GET_AGE="SELECT ROUND((SYSDATE-DOB)/365.25,2) FROM TEST WHERE SNO =?";

	public static void main(String[] args) throws Exception {
		
		Connection con = null;
		PreparedStatement  ps= null;
		ResultSet rs = null;
		Scanner sc = null; 
		int  sNo = 0;
				try {
						sc = new Scanner(System.in);
						// getting input in form of date for calculating the age
						System.out.println("Enter the Student number :: ");
						if(sc != null)
						sNo = sc.nextInt();
						con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","learn_jdbc","JDBC");
						if(con!=null)
							ps = con.prepareStatement(GET_AGE);
						if (ps!=null) {
							ps.setInt(1, sNo);
						 rs= ps.executeQuery();
						 rs.next();
						 float age = rs.getFloat(1);
						System.out.println("Student age is :: "+age);
						}
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
	}

}
