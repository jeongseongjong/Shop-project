package com.biz.movie.util;

import java.util.Map;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PbeEncryptor {

	private static StandardPBEStringEncryptor pbEnc;
	
	static {
		pbEnc = new StandardPBEStringEncryptor();
		Map<String, String> envList = System.getenv();
		String strSalt = envList.get("BIZ.COM");
		pbEnc.setAlgorithm("PBEWIthMD5AndDES");
		pbEnc.setAlgorithm(strSalt);
	}

	public static String getEncrypt(String plainText) {
		return pbEnc.encrypt(plainText);
	}

	public static String getDecrypt(String encText) {
		return pbEnc.decrypt(encText);
	}
	
	
	
}
