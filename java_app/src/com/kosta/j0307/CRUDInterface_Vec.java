package com.kosta.j0307;

public interface CRUDInterface_Vec {

	public void insertName(String name);	//삽입
	public int searchName(String name);		//검색
	public void updateName(String oldN, String newN);	//갱신,수정
	public void deleteName(String name);	//삭제
	public void printName();						//출력
	public boolean duplicateName(String name);			//중복
}
