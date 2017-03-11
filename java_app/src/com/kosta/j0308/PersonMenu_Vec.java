package com.kosta.j0308;

import java.util.Vector;

/**
 * @author ksota
 */

public class PersonMenu_Vec implements CRUDInterface_Vec_Person {

	Vector<Person> persons;
	Person p;
	short fullcheck;// �Է� �ִ� �ο���

	public PersonMenu_Vec() {
		// TODO Auto-generated constructor stub
		persons = new Vector<>();
		fullcheck = 5;//
	}

	@Override
	public void insertName(String name, String job, int age) {

		if (fullcheck != 0) {// ���� �����Ͱ� ��� �� ���ִٸ�...
			if (!duplicateName(name)) {// �ߺ� Ȯ���� ����Ǹ� ����

				p = new Person(name, age, job);
				persons.add(p);

				System.out.println(persons.indexOf(p) + " ��°�� " + p.toString() + " �Է��߽��ϴ�");
				fullcheck--;// �߰�

			} else {
				System.out.println("�ߺ��� �̸� ����");
			}
		} else {
			System.out.println("�ش� �迭�� ��� �����־� ������ �� �����ϴ�");
		}
	}

	@Override
	public void updateName(String name, String newJob, int newAge) {
		int i = searchName(name);
		if (i != -1) {// '-1' �˻� ����
			persons.get(i).setPerson(newAge, newJob);
			System.out.println("���� �Ͽ����ϴ�");
		}
	}

	@Override
	public int searchName(String name) {

		for (int j = 0; j < persons.size(); j++) {
			if (persons.get(j).getName().equals(name)) {
				System.out.println("�˻� ����");
				return j;// �˻� ������ �ش� �ε����� �Ѱ��ش�
			}
		}
		System.out.println("�˻� ����");
		return -1;
	}

	@Override
	public boolean duplicateName(String name) {// �ߺ� �˻�
		// TODO Auto-generated method stub

		if (fullcheck != 5) {// �迭�� ���� ����� ���� �ʰ�
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
				System.out.println("���� ������ �ش� ���� Size�� 0 �Դϴ�");
			} else {
				System.out.println("���� ����");
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
