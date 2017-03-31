package vending_machine_V;

import java.io.Serializable;

public class Vegitable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//  ���̵� �����ְ� ������Ʈ�� ���� �������� ���̵� ��ġ 
																		//��, ����
	private String name;
	private int price;
	private int remains;	//���
	private String farmer;// ������
	private String path; //�̹��� ���
	
	public Vegitable(String name, int price, int remains, String farmer, String path) {
		super();
		this.name = name;
		this.price = price;
		this.remains = remains;
		this.farmer = farmer;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRemains() {
		return remains;
	}

	public void setRemains(int remains) {
		this.remains = remains;
	}

	public String getFarmer() {
		return farmer;
	}

	public void setFarmer(String farmer) {
		this.farmer = farmer;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
