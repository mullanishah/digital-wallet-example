package com.core.pojo;

import java.io.Serializable;
import java.util.Date;
import com.core.utils.WalletType;
import static com.core.utils.CommonUtils.*;

public class Wallet implements Serializable {

	private static final long serialVersionUID = 1L;
	private long walletId;
	private String walletHolderName; 
	private WalletType walletType;						//premium, basic, free,
	private Date walletRegistrationDate;	
	private double walletBalance;
	
	public Wallet(long walletId, String walletHolderName, WalletType walletType, Date walletRegistrationDate, double walletBalance) {
		super();
		this.walletId = walletId;
		this.walletHolderName = walletHolderName;
		this.walletType = walletType;
		this.walletRegistrationDate = walletRegistrationDate;
		this.walletBalance = walletBalance;
	}

	public Wallet() {
		// TODO Auto-generated constructor stub
	}

	public long getWalletId() {
		return walletId;
	}

	public void setWalletId(long walletId) {
		this.walletId = walletId;
	}

	public String getWalletHolderName() {
		return walletHolderName;
	}

	public void setWalletHolderName(String walletHolderName) {
		this.walletHolderName = walletHolderName;
	}

	public WalletType getWalletType() {
		return walletType;
	}

	public void setWalletType(WalletType walletType) {
		this.walletType = walletType;
	}

	public Date getWalletRegistrationDate() {
		return walletRegistrationDate;
	}

	public void setWalletRegistrationDate(Date walletRegistrationDate) {
		this.walletRegistrationDate = walletRegistrationDate;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	@Override
	public String toString() {
		return "Wallet [Id: " + walletId + ", Holder: " + walletHolderName + ", Type: " + walletType.toString().toLowerCase() + ", Registration: " 
				+ getSdf().format(walletRegistrationDate) + ", Balance: " + walletBalance + "]";
	}	
}
