package com.biz.movie.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MySQLEnc {

	public static void main(String[] args) {
		
		/*
		 * 로컬 컴퓨터에 설정된 환경변수목록 중 BIZ.COM으로 등록된 값을 보여라
		 */
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		Map<String, String> envList = System.getenv();
		System.out.println(envList.get("BIZ.COM"));
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("MySQL Username >> ");
		String username = scan.nextLine();
		
		System.out.println("MySQL Password >> ");
		String password = scan.nextLine();
		
		/*
		 * 암호화설정을 위한 알고리즘과 SaltPassword 설정
		 */
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(envList.get("BIZ.COM"));
		
		String encUsername = pbEnc.encrypt(username);
		String encPassword = pbEnc.encrypt(password);
		
		System.out.printf("username : %s \n, encUsername");
		System.out.printf("password : %s \n, encPassword");
		
		String saveFile = "./src/main/webapp/WEB-INF/"
				+ "spring/properties/db.connection.properties";
		
		String saveUsername = String.format("mysql.username=ENC(%s)", encUsername);
		String savePassword= String.format("mysql.password=ENC(%s)", encPassword);
		
		PrintWriter out;
		try {
			out = new PrintWriter(saveFile);
			out.println(saveUsername);
			out.println(savePassword);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
		System.out.println("MySQL id / password 저장 완료");
		
	}
}
