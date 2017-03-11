package com.kosta.j0307;

public interface CRUDInterface_Vec {

	public void insertName(String name);	//����
	public int searchName(String name);		//�˻�
	public void updateName(String oldN, String newN);	//����,����
	public void deleteName(String name);	//����
	public void printName();						//���
	public boolean duplicateName(String name);			//�ߺ�
}
