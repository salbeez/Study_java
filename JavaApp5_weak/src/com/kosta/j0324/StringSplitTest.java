package com.kosta.j0324;






public class StringSplitTest {
    public static void main(String[] args) {
		String str="ȫ�浿,13,�л�";
		String arr[]=str.split(",");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+i+"]="+arr[i]);
		}
		
		System.out.println("======================");
		String str2="300|hello";
		
		String arr2[]=str2.split("\\|");
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("arr2["+i+"]="+arr2[i]);
		}
	}
}




