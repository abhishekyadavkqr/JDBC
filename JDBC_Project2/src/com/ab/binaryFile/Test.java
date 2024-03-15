package com.ab.binaryFile;

import java.io.FileInputStream;




import java.io.FileInputStream;


public class Test {
	public static void main(String[] args) throws Exception {
		String img ="E:\\ppp.jpg";
		
		 FileInputStream is = new FileInputStream(img);
		
		 System.out.println("success"+is);
	}
}
