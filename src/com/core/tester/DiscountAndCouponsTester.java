package com.core.tester;

import static com.core.utils.CommonUtils.getScanner;
import static com.core.utils.DataFeedingUtils.getWalletMap;
import com.core.exceptions.WalletHandlingException;
import com.core.pojo.Wallet;
import com.core.utils.WalletType;

public class DiscountAndCouponsTester {
	
	@SuppressWarnings("unlikely-arg-type")
	public static void applyDiscountOrCoupon() throws Exception {
		
		int counter = 0;
		System.out.println("Enter type of wallet to apply coupon to (Premium, Basics): ");
		String walletType = getScanner().next();
		
		walletType = (walletType.equalsIgnoreCase("p")) ? WalletType.PREMIUM.toString() 
				: (walletType.equalsIgnoreCase("b") ? walletType = WalletType.BASICS.toString() : WalletType.FREE.toString());
					
		if(walletType.equalsIgnoreCase(WalletType.PREMIUM.toString()) || walletType.equalsIgnoreCase(WalletType.BASICS.toString())) {
			System.out.println("Enter coupon amount :");
			double amount = getScanner().nextDouble();
			
			for(Wallet w : getWalletMap().values()) {
				if(w.getWalletType().toString().equalsIgnoreCase(walletType)) {
					w.setWalletBalance(w.getWalletBalance() + amount);
					counter++;
				}
			}
		} else if(walletType.equalsIgnoreCase(WalletType.FREE.toString())) {
			System.out.println("Coupons not applicable to free type of wallets!!");
		} else {
			throw new WalletHandlingException("Invalid wallet type!");
		}		
		System.out.println("Coupon applied successfully!, " + counter + " wallets updated.");
	}

}
