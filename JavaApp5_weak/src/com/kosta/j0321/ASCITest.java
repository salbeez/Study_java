package com.kosta.j0321;

public class ASCITest {
	
	public static void main(String[] args) {
		// 
		for(int i=32;i<127; i++){
			System.out.write(i);
			if(i%8 ==7) {System.out.write('\n');}
			else{System.out.write('\t');}
		}

	}
}
