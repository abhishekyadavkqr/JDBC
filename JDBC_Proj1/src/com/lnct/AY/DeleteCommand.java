package com.lnct.AY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//read inputs
			sc = new Scanner(System.in);
			if (sc!=null) {
			String city = null;
			city = sc.next();
			city = "'"+city+"'";
			}
			
			
			
			//Establising the Connection Between the Database and application
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","Abhi");
			//create Statement objeccts
			if(con!=null) {
				st = con.createStatement();
				System.out.println("Connection Establised Successfully");
			}else
				System.out.println("Connection not Establised");


		}



	}

}
