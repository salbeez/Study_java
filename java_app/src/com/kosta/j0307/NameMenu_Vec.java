package com.kosta.j0307;

import java.util.Vector;

/**
 * @author ksota
 */
public class NameMenu_Vec implements CRUDInterface_Vec {

	Vector<String> names;
	 short fullcheck;//�Է� �ִ� �ο���

	public NameMenu_Vec() {
		// TODO Auto-generated constructor stub
		names = new Vector<>();
		fullcheck = 5;//
	}

	@Override
	public void insertName(String name) {

		if (fullcheck != 0) {// ���� �����Ͱ� ��� �� ���ִٸ�...
			if (!duplicateName(name)) {// �ߺ� Ȯ���� ����Ǹ� ����
				names.add(name);
				System.out.println(names.indexOf(name) + " ��°�� " + name + " �Է��߽��ϴ�");
				fullcheck--;// �߰�

			} else {
				System.out.println("�ߺ��� �̸� ����");
			}
		} else {
			System.out.println("�ش� �迭�� ��� �����־� ������ �� �����ϴ�");
		}
	}

	@Override
	public void updateName(String oldN, String newN) {
		int i = searchName(oldN);
		if (i != -1) {// '-1' �˻� ����
			names.set(i, newN);
			System.out.println("���� �Ͽ����ϴ�");
		}
	}

	@Override
	public int searchName(String name) {
		int i;
		i = names.indexOf(name);		//ã�� ���ϸ� -1��ȯ
		if (i != -1) {//�ش� �̸��� �������� ���� ���
			if (names.get(i).equals(name)) {
				System.out.println("�˻� ����");
				return i;// �˻� ������ �ش� �ε����� �Ѱ��ش�
			}
		}
		System.out.println("�˻� ����");

		return -1;

	}

	@Override
	public boolean duplicateName(String name) {// �ߺ� �˻�
		// TODO Auto-generated method stub

		if (fullcheck != 5) {// �迭�� ���� ����� ���� �ʰ�
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
				System.out.println("���� ������ �ش� ���� Size�� 0 �Դϴ�");
			} else {
				System.out.println("���� ����");
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
