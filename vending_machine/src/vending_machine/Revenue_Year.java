package vending_machine;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Revenue_Year implements Serializable { // Serializable�� ��ũ �������̽���
	// ����ȭ�� �Ѵٴ� �͸� �˷��ִ� �������̽�
	private String calendar; // �� //ObjectStream�� ������ �Ѵٸ� �� ����Ѵ�.
	private int Revenue; // ����� //������ ���� ���� ��´ٴ� ��������

	public Revenue_Year(String calendar, int revenue) {
		this.calendar = calendar;
		Revenue = revenue;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public int getRevenue() {
		return Revenue;
	}

	public void setRevenue(int revenue) {
		Revenue = revenue;
	}

}