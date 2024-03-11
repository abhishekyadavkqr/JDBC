package com.ab.agecalc;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {
private static final String GET_DATE_OF_BIRTH="";

	public static void main(String[] args) throws Exception {
		
		Connection con = null;
		Scanner sc = null; 
				try {
						// getting input in form of date for calculating the age
						sc = new Scanner(System.in);
						System.out.println("enter the date of birth...");
						String sDate = sc.next();
//					    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","test","Test1");
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						Date dt = sdf.parse(sDate);
						System.out.println("Date of Birth "+dt);  
						Date sysdate = new Date();
						float res = sysdate.getTime()-dt.getTime();
							res = res/(1000f*60f*60f*24f*365.25f );
						
						System.out.println("Your Age is "+res);
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
	}

}
