package com.kosta.mvcTable.model;

import java.util.Vector;

public interface Table_Interface {
	//�����͸� �Է� �޾� ���Ϳ� �ִ´� 
	void input(Person p);
	//���Ϳ� ���� ����� �����͸� �����Ѵ�
	void modify(int index,Person p);
	//������ �ε����� ����� ����
	void delete(int index);
	//��� ����� �����͸� �����Ѵ�.
	public Vector<Person> getPersons();
	//�˻��� ���ڷ� �����ϴ� ��� ����� �����͸� ����Ѵ� (�̸��� ������)
	public Vector<Person> section_Search(int section,String str);
	
}
