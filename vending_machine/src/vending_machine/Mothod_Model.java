package vending_machine;

import org.jfree.data.category.DefaultCategoryDataset;

public class Mothod_Model {
	DefaultCategoryDataset dataset;
	
	public Mothod_Model() {
		dataset = new DefaultCategoryDataset();
	}
//	매출액.....
	public DefaultCategoryDataset getDataSet(){

		// 데이터 입력 ( 값, 범례, 카테고리 )정수실수,String,String
		// 그래프 ,.... 여기다 파일을 입력하면...	
		dataset.addValue(9.0, "월별", "1월");
		dataset.addValue(7.0, "월별", "2월");
		dataset.addValue(2.0, "월별", "3월");
		dataset.addValue(6.0, "월별", "4월");
		dataset.addValue(6.0, "월별", "5월");
		dataset.addValue(9.0, "월별", "6월");
		dataset.addValue(5.0, "월별", "7월");
		dataset.addValue(4.0, "월별", "8월");
		dataset.addValue(8.0, "월별", "9월");
		dataset.addValue(8.0, "월별", "10월");
		dataset.addValue(8.0, "월별", "11월");
		dataset.addValue(8.0, "월별", "12월");
		return dataset;
	}
}
//Study_java/JavaApp5_weak/src/com/kosta/j0322/ObjectWriteTest.java