package com.kosta.j0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author ksota 
 * main()메소드 포함 반복되는 메뉴 출력 번호입력 추가 수정 삭제에 필요한 이름 입력
 */
public class NameMenuTest_Vec {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		
		CRUDInterface_Vec menu = new NameMenu_Vec();		//인터페이스 연결하고
		int num;

		System.out.println("메뉴 입력  1:삽입  2:검색  3:수정  4:삭제  5:출력  0:종료");
		do{
			num = Integer.parseInt(br.readLine());	
			switch(num) {
			case 1:
				System.out.print("삽입 할 이름을 입력 :");
				menu.insertName(br.readLine());
				break;
			case 2: 
				System.out.print("검색 할 이름을 입력 :");
				menu.searchName(br.readLine());
				break;
			case 3: 
				System.out.print("수정 할 이름을 입력 :");
				String str = br.readLine();
				System.out.print("새 이름을 입력 :");
				String str2 = br.readLine();
				menu.updateName(str, str2);
				break;
			case 4:
				System.out.print("삭제 할 이름을 입력 :");
				menu.deleteName(br.readLine());
				break;
			case 5:	
				System.out.print("출력\n");
				menu.printName();
				break;
			default : System.out.println("메뉴에 선택된 값으로 다시 선택해 주세여, 단 0이면 종료");
			}
		}while(num!=0);
	}
}
