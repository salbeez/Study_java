package com.kosta.j0307;

import java.util.Vector;

/**
 * Vector<E> : <E>�� ���׸� Ÿ�� : �� ��������� �ڷ��� ����(���)->��Ἲ�� ������
 * 
 * <E> : element(���)�� ���� �ڷ����� ���.
 * <K> : key
 * <V> : value
 * <T> : type
 * <��� �ڷ���>
 * */

class A {
	void hello(){
		System.out.println("A class hello");
	}
}
public class VectorTest2 {

		public static void main(String[] args) {
			Vector v = new Vector();
			v.add(new A());
			
			Object ob= v.get(0);//��� ���� (index)������
//			ob.hello();// ����!! (����: �θ� ���۷����� ���� �ڽĿ�� ȣ��Ұ�)
			A a = (A)ob;
			a.hello();//�ڽ� ĳ����
			
			Vector<A> v2 = new Vector<A>();
//			Vector<A> v2 = new Vector<>(); //jdk 7���� ���� <>���� ���� ����
			v2.add(new A());
			
			A a2 = v2.get(0);
			a2.hello();
			
			v2.toArray();//���͸� �迭�� ����
		}
}
