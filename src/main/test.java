package main;

import java.security.NoSuchAlgorithmException;

import org.apache.james.security.DigestUtil;

public class test {
	public static void main(String[] args){
		String pwdHash=null;
		try {
			pwdHash = DigestUtil.digestString("ningrun123", "SHA");
			System.out.println(pwdHash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
