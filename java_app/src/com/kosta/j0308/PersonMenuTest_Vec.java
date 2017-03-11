package com.kosta.j0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author ksota 
 * main()�޼ҵ� ���� �ݺ��Ǵ� �޴� ��� ��ȣ�Է� �߰� ���� ������ �ʿ��� ����Է�
 */
public class PersonMenuTest_Vec {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		
		CRUDInterface_Vec_Person menu = new PersonMenu_Vec();		//�������̽� �����ϰ�
		int num,age;
		String name,job;

		System.out.println("�޴� �Է�  1:����  2:�˻�  3:����  4:����  5:���  0:����");
		do{
			num = Integer.parseInt(br.readLine());	
			switch(num) {
			case 1:
				System.out.print("���� �� ����� �Է� :");
				name= br.readLine();
				
				System.out.print("������ �Է� :");
				job= br.readLine();
				
				System.out.print("���� �Է� :");
				age= Integer.parseInt(br.readLine());
				menu.insertName(name,job,age);
				break;
			case 2: 
				System.out.print("�˻� �� ����� �Է� :");
				menu.searchName(br.readLine());
				break;
			case 3: 
				System.out.print("���� �� ����� �Է� :");
				name = br.readLine();
				
				System.out.print("�� ������ �Է� :");
				job = br.readLine();
				
				System.out.print("�� ���̸� �Է� :");
				age= Integer.parseInt(br.readLine());
				
				menu.updateName(name, job,age);
				break;
			case 4:
				System.out.print("���� �� ����� �Է� :");
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
