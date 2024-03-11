package com.ab.date;

import java.text.SimpleDateFormat;

public class DateClass {

	public static void main(String[] args) throws Exception {
		
			String date = "12-12-1990";
//			System.out.println(date);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date utlDate = sdf.parse(date);
			System.out.println(utlDate);
			utlDate.getTime();
				
			
//			System.out.println(d1.getTime()); 
			java.sql.Date d2= new java.sql.Date(utlDate.getTime());
			String s = sdf.format(d2);
			System.out.println("SQL Type date "+d2);
			System.out.println("String Type Date "+s);
			java.util.Date d3 =(java.util.Date)(d2);			
			System.out.println("java.util.Date type date "+d3);
			
			
	}

}
