package com.backend.util;

public class StringsUtil {

	static private String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZÇ";

	
	public static boolean isAlpha(String letra) {
		
		
		return letra!=null && ALFABETO.contains(letra.toUpperCase());
	}
}
