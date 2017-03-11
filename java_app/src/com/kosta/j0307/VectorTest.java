package com.kosta.j0307;

import java.util.Enumeration;
import java.util.Vector;

/*
 * <java.util.Vector>
 *- 가변길이 배열
 * - 객체에 대한 참조(주소)를 가지는 배열
 * 생성자)
 *    Vector(): 묵시적으로 10개의 방을 가진 Vector객체생성.
 *    Vector(int initialCapacity): size지정된 크기의 Vector객체생성.
 *    Vector(int initialCapacity, int capacityIncrement): size크기의 Vector객체생성.
 *                5             3 
 *    Capacity : 용량 , increament : 증가치
 *             	ex) 6번째 데이터가 들어오면 방3개가 추가(추가분이 다차면 또 추가분이 생김)
 *  새로운 요소가 추가되어 크기가 늘어나야 하는경우 incr지정만큼 늘어남.
 *  
 *  관련메소드)
 *    boolean hasMoreElements()  : 요소가 있으면 true, 없으면 false 리턴
 *    Object  nextElement()      : 다음 요소를 반환.
 *    
 */
public class VectorTest {
	public static void main(String[] args) {
		
		Vector v = new Vector(5,3);	//참조 데이터를 담는 클래스
		
		/*데이터 --> element//매개변수 object obj는 최상위 클래스 이므로
		 *  object의 자식은 전부다 쓸수 있다
		 */
		Integer su = new Integer(1);
		v.addElement(su);	
		
		//단 한번만 호출한다면
		v.addElement(new Integer(2));
		
		/*권장하지는 않는다 ▼*/
		int su4 = new Integer(30); //jdk 5 이상 부터
		Integer su5 = 40;
		v.addElement(3);
		
		for(int i=0; i<10; i++){
			v.addElement(i);
		}
		System.out.println("백터의 용량(방크기)"+  v.capacity());
		System.out.println("백터의 요소 갯수" + v.size());
		
		v.addElement(true);
		v.addElement(3.14);
		v.addElement("자바");
		
		System.out.println("\n백터의 용량(방크기)"+  v.capacity());
		System.out.println("백터의 요소 갯수" + v.size());
		
		// 요소 포함시 true 리턴
		System.out.println(v.contains(3.14)+"\n");
		
		//백터의 모든 요소 출력
		Enumeration enu = v.elements();
		//열거형 인터페이스 : Enumeration : [1,2,3,4,5..."자바"]
		
		while(enu.hasMoreElements()){ //요소가 있는지 여부 검사
				System.out.println(enu.nextElement());//next는 보통 다음 스탭을 실행한다
		}
		//jdk 5.0 이전에는 막집어 넣고 뺄때 문제 (int도 넣고 String도 넣고 class도 넣고) 
		//5.0 이후에는 VectorTest2로 이동( 중요 )
		//Vector<E> : <E>는 제네릭 타입 : 뭘 집어넣을지 자료형 선언
	
	}
}
