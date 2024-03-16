package com.ab.pradeepTask;

import java.sql.DriverManager;
import java.util.Scanner;

public class Task {

			public static void main(String []args) {
//				CREATE TABLE EMPLOYEE_INFO(EMPID VARCHAR2(10),EMPNAME VARCHAR2(25),EMPSALARY NUMBER(10,2),EMPADDRESS VARCHAR2(35),
//						  EMPMAILID VARCHAR2(20),EMPPHNO NUMBER(10));
				
					
					try(Scanner sc=new Scanner(System.in);){
//						 Loading Oracle Driver... But in JDBC Type 3(thin) Class Loading and Register Driver are optional , 
						Class.forName("oracle.jdbc.driver.OracleDriver");
//						
						DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
						while(true) {
							
						System.out.println("* Employee Info **");
						System.out.println("\t1.Insert data into Employee Table."+
											"\n\t2.Retrieve all Employee data."+
											"\n\t3.Retrieve employee whose name stats with 'S'."+
											"\n\t4.Retrieve employees whose salary between 10000 to 20000."+
											"\n\t5.Update employee salary with the help of eid."+
											"\n\t6.delete employee who is getting maximum salary."+
											"\n\t7.delete employee whose name ends with 'a';"+
											"\n\t8.Exit.");
						
						
						System.out.print("Enter your choice: ");
						int choice=sc.nextInt();
						switch(choice) {
						case 1:
						   break;
						case 2:
							break;
						case 3:
		 					break;
						case 4:
							break;
						case 5:
							break;
						case 6:
							break;
						case 7:
							break;
						case 8:System.out.println("Exit successfully...");
						System.exit(0);
							break;
						default:
							System.out.println("invalid input");
						
						
						}
						
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
			}
}
