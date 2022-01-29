package com.core.tester;

import static com.core.utils.CommonUtils.getScanner;
import static com.core.utils.DataFeedingUtils.getNextWalletId;
import static com.core.utils.DataFeedingUtils.getWalletMap;
import java.text.ParseException;
import java.util.Date;
import com.core.exceptions.WalletHandlingException;
import com.core.pojo.Wallet;
import com.core.utils.WalletType;

public class WalletOperationsTester {
	
	public static Wallet addNewWallet() throws ParseException, Exception {
		
		System.out.println("Enter wallet details(Holder Name, Balance): ");
		Wallet newWallet = new Wallet();
		newWallet.setWalletId(getNextWalletId());
		newWallet.setWalletHolderName(getScanner().next());
		newWallet.setWalletBalance(getScanner().nextDouble());
		newWallet.setWalletRegistrationDate(new Date(System.currentTimeMillis()));
		
		System.out.println("Select wallet type(Premium/Basics/Free): ");
		switch(getScanner().next()) {
		case "p": newWallet.setWalletType(WalletType.PREMIUM);
			break;
		case "b": newWallet.setWalletType(WalletType.BASICS);
			break;
		case "f": newWallet.setWalletType(WalletType.FREE);
			break;
		default: throw new Exception("Invalid wallet type!!");
		}
		getWalletMap().put(newWallet.getWalletId(), newWallet);
		
		return getWalletMap().get(newWallet.getWalletId());
	}
	
	public static Wallet removeWallet() throws WalletHandlingException {
		
		System.out.println("Enter wallet number to remove: ");
		long walletNum = getScanner().nextLong();
		if(getWalletMap().containsKey(walletNum)) {
			Wallet wallet = getWalletMap().remove(walletNum);
			return wallet;
		} else {
			throw new WalletHandlingException("Wallet number provided does not exist in the database!");
		}
	}
	
	public static Wallet searchWallet() throws WalletHandlingException {
		
		System.out.println("Enter wallet number to search: ");
		long walletNum = getScanner().nextLong();
		if(getWalletMap().containsKey(walletNum)) {
			Wallet wallet = getWalletMap().get(walletNum);
			return wallet;
		} else {
			throw new WalletHandlingException("Wallet number provided does not exist in the database!");
		}
	}
	
}


//getSdf().format(new Date(System.currentTimeMillis()));