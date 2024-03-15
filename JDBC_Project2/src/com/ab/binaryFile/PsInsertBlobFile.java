package com.ab.binaryFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertBlobFile {
	private static final String INSERT_QUERY = "INSERT INTO ACTOR_INFO VALUE(?,?,?,?)";
	
	public static void main(String[] args) throws FileNotFoundException {
		

		
		try(Scanner sc=new Scanner(System.in);){
			try( Connection  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","LEARN_JDBC","JDBC");){
				if(con != null) {
					try(PreparedStatement ps = con.prepareStatement(INSERT_QUERY)){
						if(ps!=null) {
//							field declaration
//							ID                                                 NUMBER
//							 NAME                                               VARCHAR2(20)
//							 ADDRESS                                            VARCHAR2(30)
//							 PHOTO
							 System.out.println("Enter the Actor id ::");
							 int id  = sc.nextInt();sc.nextLine();
							 System.out.println("Enter the Actor Name :: ");
							 String name = sc.nextLine();
							 System.out.println("Enter the Actor address :: ");
							 String adrs = sc.nextLine();
//							 System.out.println("Enter the Actor image path");
							String x = "E:\\ppp.jpg";
							String y ="E:\\ppp.jpg";
							 
							 String imgPath ="‪E:\\ppp.jpg";
							 String imgPath1 ="‪E:\\ppp.jpg";
							 String img     ="E:\\ppp.jpg";

								System.out.println(x.equals(imgPath));
							 System.exit(1);
							 System.out.println("it's working");
//							 System.out.println(id+"\t"+name+"\t"+adrs+"\t"+img+"\t"+ is);
							
//							 System.out.println(id+"\t"+name+"\t"+adrs+"\t"+img+"\t"+ io);
							 System.out.println(imgPath+"\t");
							 
							 try(FileInputStream ipo = new FileInputStream(img);){
								 System.out.println(id+"\t"+name+"\t"+adrs+"\t"+imgPath+"\t"+ ipo);
								 System.exit(1);
								 ps.setInt(1, id);
								 ps.setString(2, name);
								 ps.setString(3, adrs);
								 ps.setBlob(id, ipo);
								 
								 int flag = ps.executeUpdate();
								 if(flag ==0)
									 System.out.println("Record not inserted...");
								 else
									 System.out.println("Record inserted...");
								 
							 }// io try
						}// if
					}// ps try
				} //if
			}// con try
		} // Scanner try
		catch(SQLException se) {

			System.out.println(se.getMessage());
			System.out.println("Connection not established...");
		}
		catch (FileNotFoundException fe) {
			System.out.println(fe.getMessage());
		}
		catch (Exception e) {
			System.out.println("Internal error...");
		System.out.println(e.getMessage());	
		}
				
	}

}
