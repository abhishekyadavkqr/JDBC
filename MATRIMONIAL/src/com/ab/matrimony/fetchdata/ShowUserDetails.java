package com.ab.matrimony.fetchdata;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;

import com.ab.matrimony.database.ConnectDatabase;

public class ShowUserDetails {
	private static final String FETCH_SEARCH_RESULT = "SELECT UR.NAME,UR.EMAIL,UR.MOBILENO,UR.LANGUAGE,UR.SEX,UR.DATE_OF_BIRTH,UR.OCCUPTION,UR.INCOME,UR.DISTRICT,UR.STATE,UI.PHOTO1,UI.PHOTO2,UI.PHOTO3,UI.PHOTO4,UI.BIODATA FROM USER_RECORD UR, USER_IMG UI";
//	private static final String INSERT_NEW_USER_DETAILS = "INSERT INTO LANGUAGE(MOBILENO,LANG1,LANG2,LANG3) VALUES(?,?,?,?)";
//	private static final String FETCH_SEARCH_RESULT_PHOTO = "SELECT PHOTO1,PHOTO2,PHOTO3,PHOTO4,BIODATA FROM USER_IMG WHERE MOBILENO";
	private static Connection con =null;
	 
	static{
		try{
			Connection conn = ConnectDatabase.getInstance().getConnection();
		
			con = conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws SQLException, Exception, Throwable {
		System.out.println(fetchExistingUser(15, 20));
		System.out.println(FETCH_SEARCH_RESULT);
	}// main
	
	
	public static int fetchExistingUser(int startAge,int lastAge)   {
		System.out.println("hii");
		try{		
			PreparedStatement ps = con.prepareStatement(FETCH_SEARCH_RESULT);
			
//			ps.setInt(1, startAge);
//			ps.setInt(2, lastAge);
			try(ResultSet rs = ps.executeQuery();){
				boolean flag = false;
//				UR.NAME,			1
//				UR.EMAIL,			2
//				UR.MOBILENO,		3
//				UR.LANGUAGE,		4
//				UR.SEX,				5
//				UR.DATE_OF_BIRTH,	6
//				UR.OCCUPTION,		7
//				UR.INCOME,			8
//				UR.DISTRICT,		9
//				UR.STATE,			10
//				UI.PHOTO1,			11
//				UI.PHOTO2,			12
//				UI.PHOTO3,			13
//				UI.PHOTO4,			14
//				UI.BIODATA			15
				while(rs.next()) {
					flag = true;
					String name = rs.getString(1);
					System.out.println("Name "+name);
					String email = rs.getString(2);
					System.out.println("Email: " +email);
					String mobno = rs.getString(3);
					System.out.println("Mobile no.:"+mobno);
					String lang=rs.getString(4);
					System.out.println("Lang :"+lang);
					String sex =rs.getString(5);
					System.out.println("sex :"+sex);
					String dob=rs.getString(6);
					String occuption =rs.getString(7);
					String income =rs.getString(8);
					String dist = rs.getString(9);
				   	String  state =rs.getString(10);
				    InputStream p1  =rs.getBinaryStream(11);
				    InputStream p2=rs.getBinaryStream(12);
				    InputStream p3 =rs.getBinaryStream(13);
				  	InputStream p4 =rs.getBinaryStream(14);
				  	InputStream p5 =rs.getBinaryStream(15);
				  	OutputStream f1 = new FileOutputStream("E:\\Output\\p1.png");
				  	OutputStream f2 = new FileOutputStream("E:\\Output\\p2.jpg");
				  	OutputStream f3 = new FileOutputStream("E:\\Output\\p3.jpg");
				  	OutputStream f4 = new FileOutputStream("E:\\Output\\p4.jpg");
				  	OutputStream f5 = new FileOutputStream("E:\\Output\\p5.jpg");
				    	IOUtils.copy(p1, f1);
				    	IOUtils.copy(p2, f2);
				    	IOUtils.copy(p3, f3);
				    	IOUtils.copy(p4, f4);
				    	IOUtils.copy(p5, f5);
				    	
				}
				if(flag == false)
					System.out.println("Record not found...");
			}// rs try
			
		}//ps try
		catch (SQLException e) {
			System.out.println("There are some technical error...");
			System.out.println(e.getMessage());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}catch (Throwable e) {
			System.out.println(e.getMessage());
			
		}
		return 0;
	}//fetchExistingUserRecord()
	
	
}// class
