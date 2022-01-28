package com.core.utils;

import static com.core.utils.CommonUtils.getSdf;
import java.util.HashMap;
import java.util.Map;
import com.core.pojo.Wallet;

public class DataFeedingUtils {
	
	private static Map<Long, Wallet> walletMap = null;
	private static Long walletId = null;
	
	static {
		walletId = Long.valueOf(100000000);
		walletMap = getPopulatedWallets(walletMap);
	}
	
	public static Long getNextWalletId() {
		return ++walletId;	
	}

	public static Map<Long, Wallet> getWalletMap() {
		return walletMap;
	}

	public static void setWalletMap(Map<Long, Wallet> walletMap) {
		DataFeedingUtils.walletMap = walletMap;
	}

	public static Wallet[] getWallets() throws Exception {
		
		return new Wallet[] {
			new Wallet(978675641, "Steve Rogers", WalletType.BASICS, getSdf().parse("28-07-2012"), 30000),
			new Wallet(820074328, "Bucky Barns", WalletType.FREE, getSdf().parse("14-01-2013"), 25000),
			new Wallet(995420102, "Tony Stark", WalletType.PREMIUM, getSdf().parse("27-11-2014"), 68000),
			new Wallet(746750012, "Thor, Odinson", WalletType.BASICS, getSdf().parse("28-05-2016"), 45000),
			new Wallet(667823918, "Agent Romanoff", WalletType.BASICS, getSdf().parse("22-03-2012"), 31000),
			new Wallet(789046222, "Client Barton", WalletType.PREMIUM, getSdf().parse("19-02-2014"), 23000),
			new Wallet(799021671, "Bruce Barns", WalletType.PREMIUM, getSdf().parse("14-01-2013"), 29000),
			new Wallet(854325505, "Nick Fury", WalletType.BASICS, getSdf().parse("24-07-2015"), 26000),			
			new Wallet(811079023, "Maria Hill", WalletType.FREE, getSdf().parse("04-10-2016"), 35000),
			new Wallet(7777, "Test", WalletType.FREE, getSdf().parse("04-10-2016"), 5000)
		};
	}
	
	public static Map<Long, Wallet> getPopulatedWallets(Map<Long, Wallet> walletMap) {
		
		try {
			if(walletMap == null)
				walletMap = new HashMap<Long, Wallet>(10);
			
			for(Wallet wallet : getWallets()) {
				walletMap.put(wallet.getWalletId(), wallet);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return walletMap;
	}
}
