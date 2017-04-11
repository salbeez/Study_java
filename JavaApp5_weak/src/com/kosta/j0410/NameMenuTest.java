package com.kosta.j0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class NameMenuTest {

	public static boolean num_check(String str) {// 숫자조합일 경우 리턴 true

		// String str="123a";
		for (int i = 0; i < str.length(); i++) {// str의 인덱스 표현
			char ch = str.charAt(i);
			// if(ch >='0' && ch <= '9'){//ch문자가 숫자라면
			// if(ch < '0' || ch > '9'){//ch문자가 숫자가 아니라면
			if (!(ch >= '0' && ch <= '9')) {// ch문자가 숫자가 아니라면
				return false;// 숫자 아닌 문자 발견!!
			}
		} // for
		if (str.length() == 0)
			return false;
		return true;
	}// num_check

	public static void main(String[] args) throws IOException {

		// 번호입력, 이름입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		NameMenu menu = new NameMenu();

		int num;
		do {
			System.out.println("<이름메뉴>");
			System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
			System.out.print("번호입력==> ");
			String str = in.readLine(); // "123a"엔터
			// if(문자열str에 숫자가 아닌 문자가 존재한다면){continue;}
			// 제어문 continue; ---> 반복문내에서 사용
			// [for문]--> 증감연산자 분기, [while문,do~while문] ---> 조건식으로 분기

			if (num_check(str)) {// ==true){
				num = Integer.parseInt(str);// "1" "2" "3" "4" "5"
			} else {
				num = 0;
				System.out.println("#번호만 입력하세요!!");
			}

			System.out.println();
			String tableName =null;
			switch (num) {
			case 1:
				System.out.print("이름입력: ");
				String addName = in.readLine().trim();
				// "홍길동 ".trim() ----> "홍길동"
				if (menu.insert(addName)) {
					System.out.println("입력성공");
				} else {
					System.out.println("실패 ㅠㅠ");
				}
				break;

			case 2:
				System.out.print("테이블 이름(names): ");
				tableName = "names";
				Vector<String> v = menu.select(tableName);
				System.out.println("이름 목록");
				
				for(String s:v){
					System.out.println(s);
				}
				break;

			case 3:
				System.out.print("테이블 이름(names): ");
				tableName = in.readLine().trim();
				System.out.print("수정할이름입력: ");
				String oldName = in.readLine();// 기존이름
				System.out.print("변경할이름입력: ");
				String newName = in.readLine();// 변경이름
				/*
				 * if(menu.update(oldName, newName)){ //수정잘되었음 }else{ //수정안됨
				 * System.out.println("#존재하지 않는 이름입니다!!"); }
				 */
				if (!menu.update(tableName,oldName, newName)) {// ==false){
					System.out.println("#존재하지 않는 이름입니다!!");
				}

				break;
			case 4:
				System.out.print("삭제할이름입력: ");
				String delName = in.readLine();

					menu.delete(delName);// 삭제
					break;
			}

			System.out.println();
		} while (num != 5);

		System.out.println("-- END --");

	}// main
}