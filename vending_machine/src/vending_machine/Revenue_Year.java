package vending_machine;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Revenue_Year implements Serializable{ //Serializable�� ��ũ �������̽���
	//����ȭ�� �Ѵٴ� �͸� �˷��ִ� �������̽�
	private int month;		//��								//ObjectStream�� ������ �Ѵٸ� �� ����Ѵ�.
	private int Revenue;	//�����								//������ ���� ���� ��´ٴ� ��������
	
	
	public Revenue_Year(int month, int revenue) {
		this.month = month;
		Revenue = revenue;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getRevenue() {
		return Revenue;
	}
	public void setRevenue(int revenue) {
		Revenue = revenue;
	}


}