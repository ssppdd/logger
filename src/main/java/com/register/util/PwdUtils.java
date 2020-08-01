package com.register.util;

public class PwdUtils {
	
	private static final String ALPHA_NUMRIC_STRING ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321";
	
	public static String genrateTempPwd(int count) {
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMRIC_STRING.length());
			builder.append(ALPHA_NUMRIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
