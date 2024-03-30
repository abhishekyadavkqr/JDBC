package com.ab.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CsProcedureTest {
	private static final String CALL_PROCEDURE = "{CALL FIRST_PRO(?,?,?)}";
	public static void main(String[] args) {
			int x =0,y=0;
			 
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","LEARN_JDBC","JDBC");
					CallableStatement cls = con.prepareCall(CALL_PROCEDURE);
				Scanner  sc = new Scanner(System.in);){
			
			if(cls!=null) {
				cls.registerOutParameter(3, Types.INTEGER);
			System.out.println("Enter the first number");
			x= sc.nextInt();
			cls.setInt(1, x);
			System.out.println("Enter the second number");
			y= sc.nextInt();
			cls.setInt(2, y);
			cls.execute();
			int res=0;
			if(cls!=null) {
				res = cls.getInt(3);
			System.out.println("Sum = "+res);
			}
			else
				System.out.println("Some Technical Error!...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
