package vending_machine;

import org.jfree.data.category.DefaultCategoryDataset;

public class Mothod_Model {
	DefaultCategoryDataset dataset;
	
	public Mothod_Model() {
		dataset = new DefaultCategoryDataset();
	}
//	�����.....
	public DefaultCategoryDataset getDataSet(){

		// ������ �Է� ( ��, ����, ī�װ� )�����Ǽ�,String,String
		// �׷��� ,.... ����� ������ �Է��ϸ�...	
		dataset.addValue(9.0, "����", "1��");
		dataset.addValue(7.0, "����", "2��");
		dataset.addValue(2.0, "����", "3��");
		dataset.addValue(6.0, "����", "4��");
		dataset.addValue(6.0, "����", "5��");
		dataset.addValue(9.0, "����", "6��");
		dataset.addValue(5.0, "����", "7��");
		dataset.addValue(4.0, "����", "8��");
		dataset.addValue(8.0, "����", "9��");
		dataset.addValue(8.0, "����", "10��");
		dataset.addValue(8.0, "����", "11��");
		dataset.addValue(8.0, "����", "12��");
		return dataset;
	}
}
//Study_java/JavaApp5_weak/src/com/kosta/j0322/ObjectWriteTest.java