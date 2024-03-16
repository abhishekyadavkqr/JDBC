package com.ab.binaryFile;

import java.io.FileInputStream;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Path ::");
		String img =sc.next();
		
		 FileInputStream is = new FileInputStream(img);
		
		 System.out.println("success"+is);
	}
}
