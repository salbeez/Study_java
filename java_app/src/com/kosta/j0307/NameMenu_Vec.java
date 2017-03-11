package com.kosta.j0307;

import java.util.Vector;

/**
 * @author ksota
 */
public class NameMenu_Vec implements CRUDInterface_Vec {

	Vector<String> names;
	 short fullcheck;//입력 최대 인원수

	public NameMenu_Vec() {
		// TODO Auto-generated constructor stub
		names = new Vector<>();
		fullcheck = 5;//
	}

	@Override
	public void insertName(String name) {

		if (fullcheck != 0) {// 만약 데이터가 모두 꽉 차있다면...
			if (!duplicateName(name)) {// 중복 확인후 통과되면 ㄱㄱ
				names.add(name);
				System.out.println(names.indexOf(name) + " 번째에 " + name + " 입력했습니다");
				fullcheck--;// 추가

			} else {
				System.out.println("중복된 이름 존재");
			}
		} else {
			System.out.println("해당 배열은 모두 꽉차있어 삽입할 수 없습니다");
		}
	}

	@Override
	public void updateName(String oldN, String newN) {
		int i = searchName(oldN);
		if (i != -1) {// '-1' 검색 실패
			names.set(i, newN);
			System.out.println("수정 하였습니다");
		}
	}

	@Override
	public int searchName(String name) {
		int i;
		i = names.indexOf(name);		//찾지 못하면 -1반환
		if (i != -1) {//해당 이름이 존재하지 않은 경우
			if (names.get(i).equals(name)) {
				System.out.println("검색 성공");
				return i;// 검색 성공시 해당 인덱스를 넘겨준다
			}
		}
		System.out.println("검색 실패");

		return -1;

	}

	@Override
	public boolean duplicateName(String name) {// 중복 검사
		// TODO Auto-generated method stub

		if (fullcheck != 5) {// 배열이 전부 비워져 있지 않고
			for (int i = 0; i < names.size(); i++) {
				if (names.get(i).equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void deleteName(String name) {
		int i = searchName(name);
		if (i != -1) {
			names.remove(i);
			fullcheck--;
			if (fullcheck == 0) {
				System.out.println("삭제 성공과 해당 벡터 Size는 0 입니다");
			} else {
				System.out.println("삭제 성공");
			}
		}
	}

	@Override
	public void printName() {
		// TODO Auto-generated method stub
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));

		}
	}

}
