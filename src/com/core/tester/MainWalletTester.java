package com.core.tester;

import java.util.Map;

import com.core.pojo.Wallet;
import com.core.utils.DataFeedingUtils;

public class MainWalletTester {

	public static void main(String[] args) {
		
		Map<Long, Wallet> walletMap = DataFeedingUtils.getWalletMap();
		System.out.println(walletMap);
	}

}
