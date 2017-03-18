package com.kosta.mvcTable.model;

import java.util.Vector;

public interface Table_Interface {
	//데이터를 입력 받아 벡터에 넣는다 
	void input(Person p);
	//벡터에 넣은 사람의 데이터를 수정한다
	void modify(int index,Person p);
	//선택한 인덱스의 사람을 제거
	void delete(int index);
	//모든 사람의 데이터를 리턴한다.
	public Vector<Person> getPersons();
	//검색한 문자로 시작하는 모든 사람의 데이터를 출력한다 (이름과 관련한)
	public Vector<Person> section_Search(int section,String str);
	
}
