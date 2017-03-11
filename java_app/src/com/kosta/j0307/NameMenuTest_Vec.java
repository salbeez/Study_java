package com.kosta.j0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author ksota 
 * main()�޼ҵ� ���� �ݺ��Ǵ� �޴� ��� ��ȣ�Է� �߰� ���� ������ �ʿ��� �̸� �Է�
 */
public class NameMenuTest_Vec {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		
		CRUDInterface_Vec menu = new NameMenu_Vec();		//�������̽� �����ϰ�
		int num;

		System.out.println("�޴� �Է�  1:����  2:�˻�  3:����  4:����  5:���  0:����");
		do{
			num = Integer.parseInt(br.readLine());	
			switch(num) {
			case 1:
				System.out.print("���� �� �̸��� �Է� :");
				menu.insertName(br.readLine());
				break;
			case 2: 
				System.out.print("�˻� �� �̸��� �Է� :");
				menu.searchName(br.readLine());
				break;
			case 3: 
				System.out.print("���� �� �̸��� �Է� :");
				String str = br.readLine();
				System.out.print("�� �̸��� �Է� :");
				String str2 = br.readLine();
				menu.updateName(str, str2);
				break;
			case 4:
				System.out.print("���� �� �̸��� �Է� :");
				menu.deleteName(br.readLine());
				break;
			case 5:	
				System.out.print("���\n");
				menu.printName();
				break;
			default : System.out.println("�޴��� ���õ� ������ �ٽ� ������ �ּ���, �� 0�̸� ����");
			}
		}while(num!=0);
	}
}
