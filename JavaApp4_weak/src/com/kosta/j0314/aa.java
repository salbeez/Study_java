package com.kosta.j0314;

import java.util.Arrays;
import java.util.Random;


public class aa {
	public static void main(String[] args) {
		Random rd = new Random();
		int b[]=new int[3];
		
		for(int i=0; i<3; i++){
			b[i]= rd.nextInt(9)+1;
			for(int j=0; j<i; j++){
				if(b[i]==b[j]){
					i--;
					break;
				}
			}
		}
		System.out.println(b[1]);
		System.out.println(Arrays.toString(b));
	}
}
