package com.kosta.j0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class NameMenuTest {

	public static boolean num_check(String str) {// ���������� ��� ���� true

		// String str="123a";
		for (int i = 0; i < str.length(); i++) {// str�� �ε��� ǥ��
			char ch = str.charAt(i);
			// if(ch >='0' && ch <= '9'){//ch���ڰ� ���ڶ��
			// if(ch < '0' || ch > '9'){//ch���ڰ� ���ڰ� �ƴ϶��
			if (!(ch >= '0' && ch <= '9')) {// ch���ڰ� ���ڰ� �ƴ϶��
				return false;// ���� �ƴ� ���� �߰�!!
			}
		} // for
		if (str.length() == 0)
			return false;
		return true;
	}// num_check

	public static void main(String[] args) throws IOException {

		// ��ȣ�Է�, �̸��Է�
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		NameMenu menu = new NameMenu();

		int num;
		do {
			System.out.println("<�̸��޴�>");
			System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����");
			System.out.print("��ȣ�Է�==> ");
			String str = in.readLine(); // "123a"����
			// if(���ڿ�str�� ���ڰ� �ƴ� ���ڰ� �����Ѵٸ�){continue;}
			// ��� continue; ---> �ݺ��������� ���
			// [for��]--> ���������� �б�, [while��,do~while��] ---> ���ǽ����� �б�

			if (num_check(str)) {// ==true){
				num = Integer.parseInt(str);// "1" "2" "3" "4" "5"
			} else {
				num = 0;
				System.out.println("#��ȣ�� �Է��ϼ���!!");
			}

			System.out.println();
			String tableName =null;
			switch (num) {
			case 1:
				System.out.print("�̸��Է�: ");
				String addName = in.readLine().trim();
				// "ȫ�浿 ".trim() ----> "ȫ�浿"
				if (menu.insert(addName)) {
					System.out.println("�Է¼���");
				} else {
					System.out.println("���� �Ф�");
				}
				break;

			case 2:
				System.out.print("���̺� �̸�(names): ");
				tableName = "names";
				Vector<String> v = menu.select(tableName);
				System.out.println("�̸� ���");
				
				for(String s:v){
					System.out.println(s);
				}
				break;

			case 3:
				System.out.print("���̺� �̸�(names): ");
				tableName = in.readLine().trim();
				System.out.print("�������̸��Է�: ");
				String oldName = in.readLine();// �����̸�
				System.out.print("�������̸��Է�: ");
				String newName = in.readLine();// �����̸�
				/*
				 * if(menu.update(oldName, newName)){ //�����ߵǾ��� }else{ //�����ȵ�
				 * System.out.println("#�������� �ʴ� �̸��Դϴ�!!"); }
				 */
				if (!menu.update(tableName,oldName, newName)) {// ==false){
					System.out.println("#�������� �ʴ� �̸��Դϴ�!!");
				}

				break;
			case 4:
				System.out.print("�������̸��Է�: ");
				String delName = in.readLine();

					menu.delete(delName);// ����
					break;
			}

			System.out.println();
		} while (num != 5);

		System.out.println("-- END --");

	}// main
}