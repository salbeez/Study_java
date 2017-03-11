package com.kosta.j0307;

/**
 * @author ksota
 *
 *         class �̸� {
 *
 *         �ʵ�
 *
 *         class �̸�2{ static�� ����Ǹ� ����Ŭ����, ������ ������ innerŬ������� �Ѵ�
 *							static�� ���� �޸� �Ҵ��̵� �������� static������ ����Ҽ� ������...
 *         }
 *
 *         �޼ҵ�
 * 
 *         }
 */
class NestClass { //]
	static int i =10;
	void hello() {
		NestedClass nested = new NestedClass();
		nested.print();//���� Ŭ������ �ϱ� ���ؼ��� ��ü ����
	}

	static class NestedClass {
		int j = 20;

		void print() {
			System.out.println("i = "+ i +"\nj = "+ j);
		}
	}
}

public class NestedClassTest {
	
	public static void main(String[] args) {
		NestClass nesting = new NestClass();
		nesting.hello();
		
//		print()�޼ҵ� ���� ȣ��
//		�ܺ� Ŭ������.����Ŭ���� �������� = new �ܺ� Ŭ����(). �ܺ� Ŭ����
		
//		������ static �� ������
//		NestClass.NestedClass nested = new NestClass().new NestedClass();
		
//		static ������
		NestClass.NestedClass nested = new NestClass.NestedClass();
		nested.print();
	}

}
