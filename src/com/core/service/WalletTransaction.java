package com.core.service;

import com.core.exceptions.WalletHandlingException;
import com.core.pojo.Wallet;
import static com.core.utils.DataFeedingUtils.*;

public class WalletTransaction extends Wallet {

	private static final long serialVersionUID = 1L;
	
	public double addCoinsToWallet(double amount) throws WalletHandlingException  {
		
		this.setWalletBalance(this.getWalletBalance() + amount);
		getWalletMap().replace(this.getWalletId(), this);
		return this.getWalletBalance();
	}
	
	public double removeCoinsFromWallet(double amount) throws WalletHandlingException  {

		this.setWalletBalance(this.getWalletBalance() - amount);
		getWalletMap().replace(this.getWalletId(), this);
		return this.getWalletBalance();
	}
	
	public boolean transferCoinsToAnotherWallet(WalletTransaction destinationWallet, double amount) throws WalletHandlingException {
		Double updatedSrcBalance = removeCoinsFromWallet(amount);
		Double updatedDestBalance = destinationWallet.addCoinsToWallet(amount);
		if(updatedSrcBalance == null || updatedDestBalance == null) {
			throw new WalletHandlingException("Error in coin transaction!!");
		}
		return true;
	}

}
