package vending_machine;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Revenue_Year implements Serializable{ //Serializable은 마크 인터페이스로
	//직렬화를 한다는 것만 알려주는 인터페이스
	private int month;		//월								//ObjectStream을 쓰려고 한다면 꼭 써야한다.
	private int Revenue;	//매출액								//우편에서 도장 쾅쾅 찍는다는 느낌으로
	
	
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