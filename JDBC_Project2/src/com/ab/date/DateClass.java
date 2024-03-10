package com.ab.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateClass {

	public static void main(String[] args) throws ParseException {
		
			String date = "15-11-2002";
//			System.out.println(date);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
//			java.util.Date utlDate = sdf.parse(date);
//			System.out.println(utlDate);
				
			java.util.Date d1 = new Date();
				
			System.out.println(d1.getTime()); 
			java.sql.Date d2= new java.sql.Date(d1.getTime());
			String s = sdf.format(d2);
			System.out.println(d2);
			System.out.println(s);
	}

}
