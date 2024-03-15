package com.ab.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CopyRecordsFromOneToAnotherDataBase {
			private static final String FETCH_RECORD =" SELECT ROLL_NO,NAME,ADDRESS,FEE FROM STUDENT ORDER BY ROLL_NO";
	public static void main(String[] args) {
		
//			variable declaration

		Connection mySqlCon = null;
		Connection orclCon = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			System.out.println("connection Started here!");
			orclCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","LEARN_JDBC","JDBC");
//			mySqlCon = DriverManager.getConnection("","","");
			if (orclCon !=null) 
				st = orclCon.createStatement();
			System.out.println("Connection Started Successfully with Both DataBase...");
			
			if(st!=null)
			rs=st.executeQuery(FETCH_RECORD);
			if (rs!=null) {
				while (rs.next()) {
					System.out.println(" "+rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
