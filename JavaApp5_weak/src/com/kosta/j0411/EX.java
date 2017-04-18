package com.kosta.j0411;

import java.util.*;

public class EX {
	public static void main(String args[]) {
		// create hash set
		HashSet<String> newset = new HashSet<String>();

		// populate hash set
		newset.add("Learning");
		newset.add("Easy");
		newset.add("Simply");
		newset.add("James");
		newset.add("Scott");
		newset.add("Tiger");

		// create an iterator
		Iterator iterator = newset.iterator();

		// check values
		while (iterator.hasNext()) {
			System.out.println("Value: " + iterator.next() + " ");
		}
	}
}