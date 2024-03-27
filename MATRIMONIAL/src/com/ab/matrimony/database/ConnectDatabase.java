package com.ab.matrimony.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
			private  Connection con = null;
			private static ConnectDatabase obj=null;
			private ConnectDatabase() {}
			
			public static ConnectDatabase getInstance() {
				if (obj==(null)) {
					obj = new ConnectDatabase();
				}
				return obj;
			}
			
			public Connection getConnection() throws SQLException,Exception,Throwable {
				
				if(con==(null)) {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","matrimonial","shadi");
					
				}
				System.out.println("Connection established...");
				return con;
			}
}
