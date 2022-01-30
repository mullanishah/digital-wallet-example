package com.core.tester;

import static com.core.utils.CommonUtils.getScanner;
import static com.core.utils.DataFeedingUtils.getWalletMap;
import com.core.exceptions.WalletHandlingException;
import com.core.pojo.Wallet;
import com.core.service.WalletTransaction;

public class WalletTransactionTester {
	
	public static void makeTransaction() throws Exception {
		
		System.out.println("Enter your wallet number: ");
		long walletNo = getScanner().nextLong();
		WalletTransaction srcWallet = searchWallet(walletNo);
		if(srcWallet == null) {
			throw new WalletHandlingException("Invalid or incorrect wallet number!");
		} else {
			System.out.println("==========================================");	
			System.out.println("1.Add coins to the wallet\n"
					+ "2.Remove coins from the wallet\n"
					+ "3.Transfer coins to another wallet");
			System.out.println("Enter your transaction choice: ");
			switch(getScanner().nextInt()) {
			case 1:
				double updatedBalance = addCoinsToWallet(srcWallet);
				System.out.println("Wallet successfully updated!!, Updated balance: " + updatedBalance);
				break;
			case 2:
				updatedBalance = removeCoinsFromWallet(srcWallet);
				System.out.println("Wallet successfully updated!!, Updated balance: " + updatedBalance);
				break;
			case 3:
				boolean status = transferCoinsToAnotherWallet(srcWallet);
				System.out.println((status == true)? "Successful coin transaction!" : "Coin transaction failed!");
				break;
			default:
				System.out.println("Invalid transaction choice!!");
			}
		}
	}
	
	public static double addCoinsToWallet(WalletTransaction srcWallet) throws WalletHandlingException  {
		
		System.out.println("Enter coin amount to be added: ");
		double amount = getScanner().nextDouble();
		double updatedBalance = srcWallet.addCoinsToWallet(amount);
		return updatedBalance;
	}
	
	public static double removeCoinsFromWallet(WalletTransaction srcWallet) throws WalletHandlingException  {

		System.out.println("Enter coin amount to be removed: ");
		double amount = getScanner().nextDouble();
		double updatedBalance = srcWallet.removeCoinsFromWallet(amount);
		return updatedBalance;
	}
	
	public static boolean transferCoinsToAnotherWallet(WalletTransaction srcWallet) throws WalletHandlingException {
		
		boolean status = false;
		System.out.println("Enter destination wallet number: ");
		long walletNo = getScanner().nextLong();
		WalletTransaction destWallet = searchWallet(walletNo);
		if(destWallet == null) {
			throw new WalletHandlingException("Invalid or incorrect destination wallet number!");
		} else {
			System.out.println("Enter coin amount to be transfered: ");
			double amount = getScanner().nextDouble();
			status = srcWallet.transferCoinsToAnotherWallet(destWallet, amount);
		}		
		return status;
	}
	
	public static WalletTransaction searchWallet(long walletNumber) {
		
		Wallet wallet = getWalletMap().get(walletNumber);
		if(wallet != null) {
			WalletTransaction walletTrx = mapObjects(wallet);
			return walletTrx;
		}
		return null;
	}
	
	public static WalletTransaction mapObjects(Wallet wallet) {
		
		WalletTransaction walletTrx = new WalletTransaction();
		walletTrx.setWalletBalance(wallet.getWalletBalance());
		walletTrx.setWalletHolderName(wallet.getWalletHolderName());
		walletTrx.setWalletId(wallet.getWalletId());
		walletTrx.setWalletRegistrationDate(wallet.getWalletRegistrationDate());
		walletTrx.setWalletType(wallet.getWalletType());
		return walletTrx;
	}	
}
