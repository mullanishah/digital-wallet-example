package com.core.utils;

import java.text.SimpleDateFormat;

public class CommonUtils {
	
	private static SimpleDateFormat sdf;
	
	static {
		sdf = new SimpleDateFormat("dd-mm-yyyy");
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

}
