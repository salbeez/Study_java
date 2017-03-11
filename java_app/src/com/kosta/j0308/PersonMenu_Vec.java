package com.kosta.j0308;

import java.util.Vector;

/**
 * @author ksota
 */

public class PersonMenu_Vec implements CRUDInterface_Vec_Person {

	Vector<Person> persons;
	Person p;
	short fullcheck;// 입력 최대 인원수

	public PersonMenu_Vec() {
		// TODO Auto-generated constructor stub
		persons = new Vector<>();
		fullcheck = 5;//
	}

	@Override
	public void insertName(String name, String job, int age) {

		if (fullcheck != 0) {// 만약 데이터가 모두 꽉 차있다면...
			if (!duplicateName(name)) {// 중복 확인후 통과되면 ㄱㄱ

				p = new Person(name, age, job);
				persons.add(p);

				System.out.println(persons.indexOf(p) + " 번째에 " + p.toString() + " 입력했습니다");
				fullcheck--;// 추가

			} else {
				System.out.println("중복된 이름 존재");
			}
		} else {
			System.out.println("해당 배열은 모두 꽉차있어 삽입할 수 없습니다");
		}
	}

	@Override
	public void updateName(String name, String newJob, int newAge) {
		int i = searchName(name);
		if (i != -1) {// '-1' 검색 실패
			persons.get(i).setPerson(newAge, newJob);
			System.out.println("수정 하였습니다");
		}
	}

	@Override
	public int searchName(String name) {

		for (int j = 0; j < persons.size(); j++) {
			if (persons.get(j).getName().equals(name)) {
				System.out.println("검색 성공");
				return j;// 검색 성공시 해당 인덱스를 넘겨준다
			}
		}
		System.out.println("검색 실패");
		return -1;
	}

	@Override
	public boolean duplicateName(String name) {// 중복 검사
		// TODO Auto-generated method stub

		if (fullcheck != 5) {// 배열이 전부 비워져 있지 않고
			for (int i = 0; i < persons.size(); i++) {
				if (persons.get(i).getName().equals(name)) {
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
			persons.remove(i);
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
		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
		}
	}
}
