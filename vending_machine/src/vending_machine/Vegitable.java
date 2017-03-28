package vending_machine;

import java.io.Serializable;

public class Vegitable implements Serializable{
	String name;
	int price;
//	int remains;
	String farmer;// »ý»êÀÚ

	public Vegitable(String name, int price, String farmer) {
		this.name = name;
		this.price = price;
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

	public String getFarmer() {
		return farmer;
	}

	public void setFarmer(String farmer) {
		this.farmer = farmer;
	}

}
