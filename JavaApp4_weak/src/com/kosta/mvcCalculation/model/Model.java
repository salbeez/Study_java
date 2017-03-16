package com.kosta.mvcCalculation.model;

/**
 * @author ksota 사칙연산하는 기능의 메소드
 */
public class Model {
	private int su1, su2;
	private String oper;// 연산자
	private int result;

	public Model(int su1, int su2, String oper) {
		this.su1 = su1;
		this.su2 = su2;
		this.oper = oper;
		
		choice();
	}
	
	private void choice(){//선택된 연산자에 따라 알맞은 메소드 호출
//		if(oper.equals("+")){
//			
//		}else if(oper.equals("-")){
//			
//		}else if (oper.equals("/")){}//,,,이렇게 하거나
//		
		switch (oper) {
		case "+": plus();
			break; 
		case "-": minus();
			break;
		case "*": multi();
			break;
		case "/": div();
			break;
		default: //
			break;
		}
	}

	private void plus() {
		result = su1+su2;
	}

	private void minus() {
		result = su1-su2;
	}

	private void multi() {
		result = su1*su2;
	}

	private void div() {
		result = su1/su2;
	}

	public String getResult() {//다른 곳에서 호출할수 있도록 
		return "결과값 : "+su1+oper+su2+"="+result;
	}
}
