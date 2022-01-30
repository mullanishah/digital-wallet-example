package com.core.tester;

import static com.core.utils.CommonUtils.getScanner;
import static com.core.utils.CommonUtils.getSdf;
import static com.core.utils.DataFeedingUtils.getWalletMap;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;
import com.core.exceptions.WalletHandlingException;
import com.core.pojo.Wallet;

public class DisplayWalletTester {

	public static void displayWallets() throws Exception {
		System.out.println("==========================================");	
		System.out.println("1.All wallets\n"
						 + "2.Display all wallets by creation date\n"
						 + "3.Display wallets by conversions/ Statistics");
		System.out.println("Enter display choice: ");
		//int choice = getScanner().nextInt();
		switch(getScanner().nextInt()) {
		case 1:
			printAllWallets();
			break;
		case 2:	
			getWalletsByCreation();
			break;
		case 3:
			getStatistics();
			break;
		default:
			System.out.println("Invalid display choice!!");	
		}
	}
	
	private static void printAllWallets() {
		
		for(Wallet wallet : getWalletMap().values()) {
				System.out.println(wallet);
		}
	}
	
	private static void getWalletsByCreation() throws WalletHandlingException, ParseException {
		
		boolean anyEntryPresent = false;
		System.out.println("Enter date to search(dd-mm-yyyy): ");
		Date searchDate = getSdf().parse(getScanner().next());
		for(Wallet wallet : getWalletMap().values()) {
			if(wallet.getWalletRegistrationDate().after(searchDate)) {
				System.out.println(wallet);
				anyEntryPresent = true;
			}
		}
		if(anyEntryPresent == false)
			System.out.println("No data present after " + getSdf().format(searchDate));
	}
	
	private static void getStatistics() throws Exception {
		
		//no of wallets
		System.out.println("Total available wallets: " + getWalletMap().size());
		
		//display all keys
		Set<Long> keys = getWalletMap().keySet();
		System.out.println("Wallet numbers: " + keys);
		
		//display all values
		Collection<Wallet> values = getWalletMap().values();
		System.out.println("All wallets: " + values);
		
		//display keys and values
		System.out.println("Entries: ");
		Set<Entry<Long, Wallet>> entries = getWalletMap().entrySet();
		for(Entry<Long, Wallet> entry : entries) {
			System.out.println(entry.getKey() + "<-->" + entry.getValue());
		}
	}
}
