package com.core.tester;

import java.util.Scanner;
import com.core.pojo.Wallet;
import com.core.utils.CommonUtils;

public class MainWalletTester {
	
	private static Scanner scanner = null;
	static {
		scanner = CommonUtils.getScanner();
	}

	public static void main(String[] args) {
		
		int choice = 0;
		try {
			do {
				System.out.println("===================== MENU =====================");		
				System.out.printf("%-25s %-15s%n", "1.Add Wallet Details", "2.Remove Existing Wallet");
				System.out.printf("%-25s %-15s%n", "3.Search Wallet(By ID)", "4.Display Wallet Details");
				System.out.printf("%-25s %-15s%n", "5.Apply Coupon/Discount", "6.Coin Transfer");
				System.out.printf("%-25s %-15s%n", "7.Sort", "8.Exit");
				System.out.println("Enter your choice: ");
				choice = scanner.nextInt();
				switch(choice) {
				case 1:
					Wallet wallet = WalletOperationsTester.addNewWallet();
					System.out.println("New digital wallet added successfully!!, Details: " + wallet);
					break;
				case 2:
					wallet = WalletOperationsTester.removeWallet();
					System.out.println("Wallet removed successfully!, Details: " + wallet);
					break;
				case 3:
					wallet = WalletOperationsTester.searchWallet();
					System.out.println("Wallet details found successfully!, Details: " + wallet);
					break;
				case 4:
					DisplayWalletTester.displayWallets();
					break;
				case 5:
					DiscountAndCouponsTester.applyDiscountOrCoupon();
					break;
				case 6:
					WalletTransactionTester.makeTransaction();
					break;
				case 7:
					SortWalletTester.sortWallets();
					break;
				case 8:
					exit();
				}
			}while(choice != 8);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void exit() {
		System.out.println("===Exiting===");
		System.exit(0);
	}

	public static Scanner getScanner() {
		return scanner;
	}
}

