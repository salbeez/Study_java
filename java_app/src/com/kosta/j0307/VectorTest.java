package com.kosta.j0307;

import java.util.Enumeration;
import java.util.Vector;

/*
 * <java.util.Vector>
 *- �������� �迭
 * - ��ü�� ���� ����(�ּ�)�� ������ �迭
 * ������)
 *    Vector(): ���������� 10���� ���� ���� Vector��ü����.
 *    Vector(int initialCapacity): size������ ũ���� Vector��ü����.
 *    Vector(int initialCapacity, int capacityIncrement): sizeũ���� Vector��ü����.
 *                5             3 
 *    Capacity : �뷮 , increament : ����ġ
 *             	ex) 6��° �����Ͱ� ������ ��3���� �߰�(�߰����� ������ �� �߰����� ����)
 *  ���ο� ��Ұ� �߰��Ǿ� ũ�Ⱑ �þ�� �ϴ°�� incr������ŭ �þ.
 *  
 *  ���ø޼ҵ�)
 *    boolean hasMoreElements()  : ��Ұ� ������ true, ������ false ����
 *    Object  nextElement()      : ���� ��Ҹ� ��ȯ.
 *    
 */
public class VectorTest {
	public static void main(String[] args) {
		
		Vector v = new Vector(5,3);	//���� �����͸� ��� Ŭ����
		
		/*������ --> element//�Ű����� object obj�� �ֻ��� Ŭ���� �̹Ƿ�
		 *  object�� �ڽ��� ���δ� ���� �ִ�
		 */
		Integer su = new Integer(1);
		v.addElement(su);	
		
		//�� �ѹ��� ȣ���Ѵٸ�
		v.addElement(new Integer(2));
		
		/*���������� �ʴ´� ��*/
		int su4 = new Integer(30); //jdk 5 �̻� ����
		Integer su5 = 40;
		v.addElement(3);
		
		for(int i=0; i<10; i++){
			v.addElement(i);
		}
		System.out.println("������ �뷮(��ũ��)"+  v.capacity());
		System.out.println("������ ��� ����" + v.size());
		
		v.addElement(true);
		v.addElement(3.14);
		v.addElement("�ڹ�");
		
		System.out.println("\n������ �뷮(��ũ��)"+  v.capacity());
		System.out.println("������ ��� ����" + v.size());
		
		// ��� ���Խ� true ����
		System.out.println(v.contains(3.14)+"\n");
		
		//������ ��� ��� ���
		Enumeration enu = v.elements();
		//������ �������̽� : Enumeration : [1,2,3,4,5..."�ڹ�"]
		
		while(enu.hasMoreElements()){ //��Ұ� �ִ��� ���� �˻�
				System.out.println(enu.nextElement());//next�� ���� ���� ������ �����Ѵ�
		}
		//jdk 5.0 �������� ������ �ְ� ���� ���� (int�� �ְ� String�� �ְ� class�� �ְ�) 
		//5.0 ���Ŀ��� VectorTest2�� �̵�( �߿� )
		//Vector<E> : <E>�� ���׸� Ÿ�� : �� ��������� �ڷ��� ����
	
	}
}
