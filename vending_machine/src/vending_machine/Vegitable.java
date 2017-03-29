package vending_machine;

import java.io.Serializable;

public class Vegitable implements Serializable{
	private String name;
	private int price;
	private int remains;	//재고량
	private String farmer;// 생산자
	
	public Vegitable(String name, int price, int remains, String farmer) {
		super();
		this.name = name;
		this.price = price;
		this.remains = remains;
		this.farmer = farmer;
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



}
