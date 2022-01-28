package com.core.utils;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CommonUtils {
	
	private static SimpleDateFormat sdf;
	private static Scanner scanner = null;
	
	static {
		scanner = new Scanner(System.in);
		sdf = new SimpleDateFormat("dd-mm-yyyy");
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static Scanner getScanner() {
		return scanner;
	}

}
