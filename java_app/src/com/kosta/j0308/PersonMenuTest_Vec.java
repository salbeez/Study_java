package com.kosta.j0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author ksota 
 * main()메소드 포함 반복되는 메뉴 출력 번호입력 추가 수정 삭제에 필요한 사람입력
 */
public class PersonMenuTest_Vec {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		
		CRUDInterface_Vec_Person menu = new PersonMenu_Vec();		//인터페이스 연결하고
		int num,age;
		String name,job;

		System.out.println("메뉴 입력  1:삽입  2:검색  3:수정  4:삭제  5:출력  0:종료");
		do{
			num = Integer.parseInt(br.readLine());	
			switch(num) {
			case 1:
				System.out.print("삽입 할 사람을 입력 :");
				name= br.readLine();
				
				System.out.print("직업을 입력 :");
				job= br.readLine();
				
				System.out.print("나이 입력 :");
				age= Integer.parseInt(br.readLine());
				menu.insertName(name,job,age);
				break;
			case 2: 
				System.out.print("검색 할 사람을 입력 :");
				menu.searchName(br.readLine());
				break;
			case 3: 
				System.out.print("수정 할 사람을 입력 :");
				name = br.readLine();
				
				System.out.print("새 직업을 입력 :");
				job = br.readLine();
				
				System.out.print("새 나이를 입력 :");
				age= Integer.parseInt(br.readLine());
				
				menu.updateName(name, job,age);
				break;
			case 4:
				System.out.print("삭제 할 사람을 입력 :");
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
