package com.kosta.j0307;

import java.util.Vector;

/**
 * ���׸� Ÿ���� ������� �� ���� : �߰����� �ڽ� ĳ������ �ʿ����
 */
public class VectorTest3 {
	public static void main(String[] args) {
		// ������ �߰� �˻� ���� ����
		Vector<String> v = new Vector<>();

		// �߰��Լ�
		/*
		 * v.addElement(obj);; v.add(e); v.insertElementAt(obj, index);
		 * v.add(int index, String element); insert�� ����
		 * 
		 * 0: ȫ�浿 1: ����� 2: ���ֿ�
		 * 
		 * v.insertElementAt("������", 1); 0: ȫ�浿 1: ������ 2: ����� 3: ���ֿ�
		 */

		// �߰� �ϴ� �̰͸� ���� v.add(������)
		v.add("ȫ�浿");
		v.add("�����");
		v.add("���ֿ�");
		v.add("ȫ�浿");

		// �˻�
		for (int i = 0; i < v.size(); i++) {// ������ �ε��� ǥ��
			// v.size() :������ ����� ��� ����
			String name = v.get(i);
		
			System.out.println(i + " " + name);
		}

		// ���� (�����) -> (������)

		// v.set(index, element);
		// v.setElementAt(obj, index);
		v.setElementAt("������", 1);// ����

		// ����

		// v.remove(index);
		// v.remove(object o);

		v.remove("ȫ�浿");// index ������ ���� 0��°�� ����

		// ���ͳ��� ��ü �����͸� ����
		v.removeAllElements();
		v.clear();

		//
		// is ~ �޼ҵ� : ���¸� ǥ���ϴ� �޼ҵ�
		System.out.println(v.isEmpty());
	}

}
