package com.kosta.j0308;

public class ExceptionTest3 {
	public static void main(String[] args) {
		/* Run Configurations -> Arguments�� ���� apply-> Ȯ��
		 * su1		su2
		 * 10			5
		 * 10			0
		 * ab			cd
		 * 10			x
		 * */
		System.out.println("�Ű������� ���� ���� �ΰ��� ��");
		
		try {
			int su1 = Integer.parseInt(args[0]);	//ArrayIndexOutOfBounds,NumberFormat
			int su2 = Integer.parseInt(args[1]);	//ArrayIndexOutOfBounds,NumberFormat
			
			System.out.println("su1 = "+su1+", su2 = "+su2);
			System.out.println("su1�� su2�� ���� �� = "+(su1/su2));// Arithmeic
			System.out.println("�������� ������ �����Ͽ����ϴ�");
		} /*catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("�ΰ��� ���� �Է�");
		}
		catch(NumberFormatException ne){
			System.out.println("���ڸ� �Է�");
//			return;
		}
		catch(ArithmeticException ae){
			System.out.println("0���� ������ �����ϴ�");
		}*/
		catch(Exception e){
			System.out.println("��� ���� ó��");
		}
		finally {
			//���� �߻��� ������� ������ ����
//			�� ���ĸ� ���ܿ��� return�� ������ "������ ����"�� ������ �ȵ�����
//			Finally������ ����ȴ�
			System.out.println("finally() : �ݵ�� �����ϴ� ����" );
		}
//		try~catch~finally
		System.out.println("������ ����");
	}
}

/**/
