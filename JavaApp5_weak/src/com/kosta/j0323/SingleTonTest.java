package com.kosta.j0323;

class A{
	
	int su;//0
	
	static A instance;//null
	
	private A(){}
	
	void hello(){}
	
	public static A getInstance(){
	   if(instance == null){
		   instance = new A();
	   }
		return instance;
	}//getInstance
}



public class SingleTonTest 
{//�̱��� Ŭ����: Ŭ������ü�� �Ѱ������Ͽ� ���� ������ �������� ���!!
	//-----> �� Ŭ���� �� �ѹ��� ��ü������ �ϰڴ�!!
    public static void main(String[] args) {
		  A a1 = A.getInstance(); //new A();
		    //a1.hello();
		  
		  A a2 = A.getInstance(); // new A();
		  A a3 = A.getInstance(); // new A();
		  
		  System.out.println(a1);
		  System.out.println(a2);
		  System.out.println(a3);
		  
	}
}
