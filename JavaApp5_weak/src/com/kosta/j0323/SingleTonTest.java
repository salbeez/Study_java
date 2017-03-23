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
{//싱글톤 클래스: 클래스객체를 한개생성하여 여러 곳에서 공동으로 사용!!
	//-----> 한 클래스 당 한번의 객체생성을 하겠다!!
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
