package com.core.tester;

import static com.core.utils.DataFeedingUtils.getWalletMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import com.core.pojo.Wallet;
import static com.core.utils.CommonUtils.*;

public class SortWalletTester {
	
	public static void sortWallets() throws Exception {
		
		System.out.println("==========================================");
		System.out.println("1.Sort on key\n"
						 + "2.Sort(on balance)\n"
						 + "3.Sort on wallet number(Ascending)\n"
						 + "4.sort on wallet number(Descending)");
		System.out.println("Choose your sorting preference: ");
		switch(getScanner().nextInt()) {
		case 1:
			sortBasedOnKey();
			break;
		case 2:
			sortBasedOnBalance();
			break;
		case 3:
			sortBasedOnWalletAsc();
			break;
		case 4:
			sortBasedOnWalletDesc();
			break;
		default: 
			System.out.println("Invalid sorting choice!!");
		}
	}
	
	//natural sorting on key
	private static void sortBasedOnKey() {
		
		TreeMap<Long, Wallet> treeMap = new TreeMap<Long, Wallet>();
		treeMap.putAll(getWalletMap());
		Set<Entry<Long, Wallet>> entries = treeMap.entrySet();
		for(Entry<Long, Wallet> entry : entries) {
			System.out.println(entry.getKey() + "<-->" + entry.getValue());
		}
	}
	
	//natural-sorting on value
	private static void sortBasedOnBalance() {
		Collection<Wallet> collection = getWalletMap().values();
		LinkedList<Wallet> linkedList = new LinkedList<Wallet>(collection);
		Collections.sort(linkedList, new Comparator<Wallet>() {
			@Override
			public int compare(Wallet w1, Wallet w2) {
				return ((Double)w1.getWalletBalance())
						.compareTo((Double)w2.getWalletBalance());
			}
		});
		System.out.println("Sort on balance: \n" + linkedList);
	}
	
	//Ascending
	private static void sortBasedOnWalletAsc() {
		TreeMap<Long, Wallet> sortedWalletMap = new TreeMap<Long, Wallet>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return o1.compareTo(o2);
			}			
		}); 
		sortedWalletMap.putAll(getWalletMap());
		System.out.println("Sort on wallet id(ascending): \n" + sortedWalletMap);
	}
	
	//Descending
	private static void sortBasedOnWalletDesc() {
		TreeMap<Long, Wallet> sortedWalletMap = new TreeMap<Long, Wallet>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				return o2.compareTo(o1);
			}			
		}); 
		sortedWalletMap.putAll(getWalletMap());
		System.out.println("Sort on wallet id(descending): \n" + sortedWalletMap);
	}

}
