package com.kosta.j0414;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class HashSetLotto {
	/*
	 * public static void main(String[] args) { HashSet<Integer> lotto = new
	 * HashSet<>(); Random rand =new Random();
	 * 
	 * for (;;) { lotto.add(rand.nextInt(45)+1); if(lotto.size() ==6){ break; }
	 * } System.out.println(lotto.toString()); }
	 */

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		int cnt=10000000;
		long start =  System.currentTimeMillis();
		for(int i =0; i<cnt ;i++){
			list1.add("홍길동");
		}
		long end =  System.currentTimeMillis();
		System.out.println("arrayList = "+(end-start));
		
		start =  System.currentTimeMillis();
		for(int i =0; i<cnt ;i++){
			list1.add("길라임");
		}
		end =  System.currentTimeMillis();
		System.out.println("LinkedList = "+(end-start));
	}
}
