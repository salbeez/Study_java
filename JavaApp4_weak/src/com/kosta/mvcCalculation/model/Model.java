package com.kosta.mvcCalculation.model;

/**
 * @author ksota ��Ģ�����ϴ� ����� �޼ҵ�
 */
public class Model {
	private int su1, su2;
	private String oper;// ������
	private int result;

	public Model(int su1, int su2, String oper) {
		this.su1 = su1;
		this.su2 = su2;
		this.oper = oper;
		
		choice();
	}
	
	private void choice(){//���õ� �����ڿ� ���� �˸��� �޼ҵ� ȣ��
//		if(oper.equals("+")){
//			
//		}else if(oper.equals("-")){
//			
//		}else if (oper.equals("/")){}//,,,�̷��� �ϰų�
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

	public String getResult() {//�ٸ� ������ ȣ���Ҽ� �ֵ��� 
		return "����� : "+su1+oper+su2+"="+result;
	}
}
