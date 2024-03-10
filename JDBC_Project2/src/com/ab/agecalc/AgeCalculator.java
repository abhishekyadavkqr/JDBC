package com.ab.agecalc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgeCalculator {
private static final String GET_DATE_OF_BIRTH="";

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin","","");

	}

}
