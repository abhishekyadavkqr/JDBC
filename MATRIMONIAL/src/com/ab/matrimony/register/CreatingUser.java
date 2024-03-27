package com.ab.matrimony.register;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.ab.matrimony.database.ConnectDatabase;

public class CreatingUser {
	private static final String INSERT_NEW_USER = "INSERT INTO USER_RECORD(NAME,ADDRS,DISTRICT,STATE,EMAIL,MOBILENO,LANGUAGE,SEX,DATE_OF_BIRTH,OCCUPTION,INCOME) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//	private static final String INSERT_NEW_USER_DETAILS = "INSERT INTO LANGUAGE(MOBILENO,LANG1,LANG2,LANG3) VALUES(?,?,?,?)";
	private static final String INSERT_NEW_USER_PHOTO = "INSERT INTO USER_IMG (MOBILENO,PHOTO1,PHOTO2,PHOTO3,PHOTO4,BIODATA) VALUES (?,?,?,?,?,?)";
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
		System.out.println("Hello! this is CreatingUser.main() method \nThere are no use of this method in present.\n"
				+ "so, may be  this method will use in the project enhancment.");
		insertNewUserRecord();
	}// main
	public static void insertNewUserRecord()   {
		System.out.println("insert new user record (or) create new record...");
		try(PreparedStatement ps = con.prepareStatement(INSERT_NEW_USER);){
			try(Scanner sc = new Scanner(System.in);){
				if(sc!=null) {
					System.out.println("Enter Your Name.");
					String userName = sc.nextLine();
//					System.exit(1);
					System.out.println("Enter Your Address.");
					String userAddress = sc.nextLine();
					System.out.println("Enter your District.");
					String district = sc.nextLine();
					System.out.println("Enter your State.");
					String state = sc.nextLine();
					System.out.println("Enter your Mother tounge Language.");
					String userLang = sc.next(); sc.nextLine();
					System.out.println("Enter Your Email.");
					String userEmail = sc.nextLine();
					System.out.println("Enter Your Mobile Number.");
					String mobNum = sc.next();
					System.out.println("Enter Your Sex (Male/Female).");
					String userSex = sc.next();
					System.out.println("Enter Your Date of Birth(dd/MM/yyyy).");
					String dob = sc.next();sc.nextLine();
					System.out.println("Enter Your Occuption (if job or own business then please explain).");
					String userOccuption = sc.nextLine();
					System.out.println("Enter Your income (On the basis of per year).");
					long income = sc.nextLong();
					
					SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date udate = sp.parse(dob);
					System.out.println(udate.getTime()); 
					java.sql.Date sDob = new java.sql.Date(udate.getTime());
					
					System.out.println(userName +"\t"+userAddress+"\t"+userEmail+"\t"+mobNum+"\n"+userSex+"\t"+sDob+"\n"+userOccuption+"\t"+income);
//					Setting the user data to PreparedStatement object 
//					NAME,ADDRS,EMAIL,MOBILENO,SEX,DATE_OF_BIRTH,OCCUPTION,INCOME
					ps.setString(1, userName);
					ps.setString(2, userAddress);
					ps.setString(3, district);
					ps.setString(4, state);
					ps.setString(5, userEmail);
					ps.setString(6, mobNum);
					ps.setString(7, userLang);
					ps.setString(8, userSex);
					ps.setDate(9, sDob);
					ps.setString(10, userOccuption);
					ps.setLong(11, income);
					int res=ps.executeUpdate();
					if(res ==1) {
						System.out.println("Records saved successfully...");
						System.out.println("Step 2 ...");
						System.out.println("Please! add images to your profile...");
						insertBinaryFile(mobNum);
						
					}
					else
						System.out.println("Records are not saved...");
				}//if
			}//try
		}//try
		catch (SQLException e) {
			System.out.println("There are some technical error...");
			System.out.println(e.getMessage());
			
		}catch (Exception e) {
		e.printStackTrace();	
		}catch (Throwable e) {
			e.printStackTrace();
			
		}
	}//insertNewUserRecord()
	
	private static void insertBinaryFile(String mobileNum) throws Throwable {
		try(Scanner sc = new Scanner(System.in);){
				System.out.println("Mobile Number :: "+mobileNum);
				//con = ConnectDatabase.getInstance().getConnection();
				try(PreparedStatement ps = con.prepareStatement(INSERT_NEW_USER_PHOTO);){
				System.out.println("Enter your profile photo location");
//				System.exit(1);
				String pImg = sc.next();	
				pImg =pImg.replace("?", "");
//				System.out.println(pImg);
				pImg =pImg.replace("\\", "/");
//				System.out.println(pImg);
				InputStream isPImg  = new FileInputStream(pImg);
				System.out.println(isPImg);
				
				System.out.println("Enter Another 2-3 more photo location.");
				System.out.println("Enter 1st location.");
				String img = sc.next();
				img = img.replace("?"," ");
				img = img.replace("\\", "/");
				InputStream isImg1  = new FileInputStream(img);
				System.out.println(isImg1);
				System.out.println("Enter 2nd location.");
				String img1 = sc.next();
				img1 = img1.replace("?"," ");
				img1 = img1.replace("\\", "/");
				InputStream isImg2  = new FileInputStream(img1);
				System.out.println(isImg2);
				System.out.println("Enter 3rd location.");
				String img2 = sc.next();
				img2 = img2.replace("?"," ");
				img2 = img2.replace("\\", "/");
				InputStream isImg3  = new FileInputStream(img2);
				System.out.println(isImg3);
				System.out.println("Enter your BioData location (in pdf format).");
				String bioData = sc.next();
				bioData = bioData.replace("?"," ");
				bioData= bioData.replace("\\", "/");
				InputStream isBioData  = new FileInputStream(bioData);
				System.out.println(isBioData);
				ps.setString(1,mobileNum);
				ps.setBlob(2, isPImg);
				ps.setBinaryStream(3, isImg1);
				ps.setBinaryStream(4, isImg2);
				ps.setBinaryStream(5, isImg3);
				ps.setBinaryStream(6, isBioData);
				int flag =ps.executeUpdate();
				if(flag >0)
					System.out.println("Records are updated...");
				else
					System.out.println("Records are not updated...");
			} //try
		}//try
		catch (SQLException e) {
			System.out.println("Some technical error...");
			System.out.println("Please! try after some time...");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("Please enter correct data...");
			System.out.println(e.getMessage());
		}
		
	}// insertBinaryFile(_)
	
}// class
