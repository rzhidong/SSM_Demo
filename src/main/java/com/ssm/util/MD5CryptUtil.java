package com.ssm.util;

import org.apache.commons.codec.digest.Md5Crypt;

public class MD5CryptUtil {
	
	public static void main(String[] args) {
		String password = "123456";
		//String tt1 = Md5Crypt.md5Crypt(password.getBytes());
		//System.out.println(tt1);
		// $1$noNf7rbr$Xwe/2PJ2gFcU.Ewxu5w5d/
		
		String tt1 = "$1$noNf7rbr$Xwe/2PJ2gFcU.Ewxu5w5d/";
		
		String mysalt = getSalts(tt1);
		System.out.println(mysalt);// $1$lYz58EdG$
		System.out.println(Md5Crypt.md5Crypt(password.getBytes()));
		System.out.println(Md5Crypt.md5Crypt(password.getBytes(), mysalt));
		System.out.println(Md5Crypt.md5Crypt("admin".getBytes(), mysalt));
		
		System.out.println(pwdValidate("admin", tt1));
		System.out.println(pwdValidate(password, tt1));
	}

	private static String getSalts(String password) {
		String[] salts = password.split("\\$");
		if (salts.length < 1) {
			return "";
		}
		String mysalt = "";
		for (int i = 1; i < 3; i++) {
			mysalt += "$" + salts[i];
		}
		mysalt += "$";
		return mysalt;
	}
	
	/**
	 * 
	 * @param password 接受密码
	 * @param sqlString 数据库加密字符串
	 * @return
	 */
	public static boolean pwdValidate(String password,String sqlString) {
		String mySalt = getSalts(sqlString);
		
		return Md5Crypt.md5Crypt(password.getBytes(),mySalt).equals(sqlString);
	}

}
