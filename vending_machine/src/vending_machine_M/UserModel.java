package vending_machine_M;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import vending_machine_V.Vegitable;

public class UserModel {
	Vector<Boolean> priceCheckV;
	public Vector<Vegitable> current_item_V;

	BufferedReader in, br;
	FileOutputStream out;

	int moneyArr[];
	public int todayRevenue;

	String tempArr[];
	String exchange[];

	public UserModel() {
		priceCheckV = new Vector<>();
		exchange = new String[4];

		for (int i = 0; i < exchange.length; i++) {
			exchange[i] = "0";
		}

		for (int i = 0; i < 8; i++) {// 초기화
			priceCheckV.add(false);
		}

		current_item_V = new Vector<>();

		moneyArr = new int[4]; // 잔돈
	}

	public Vector<Vegitable> readCurrnetItem() {
		current_item_V.removeAllElements();
		try {
			in = new BufferedReader(new FileReader("nowItem.txt"));
			for (int i = 0; i < 8; i++) {
				tempArr = in.readLine().split(",");
				current_item_V.add(new Vegitable(tempArr[0], Integer.parseInt(tempArr[1]), Integer.parseInt(tempArr[2]),
						tempArr[3], tempArr[4]));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println(current_item_V.size());
		return current_item_V;
	}

	public void writeNowItem() {
		try {
			out = new FileOutputStream("nowItem.txt");
			for (int i = 0; i < current_item_V.size(); i++) {
				String str = current_item_V.get(i).getName() + "," + (current_item_V.get(i).getPrice() + "") + ","
						+ (current_item_V.get(i).getRemains() + "") + "," + current_item_V.get(i).getFarmer() + ","
						+ current_item_V.get(i).getPath() + "" + "\n";
				out.write(str.getBytes());
			}
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vector<Boolean> onOff(int total) { // total (사용자가 넣은 현금)에 따른 버튼의 색 변화

		for (int i = 0; i < current_item_V.size(); i++) {
			if (total >= current_item_V.get(i).getPrice() && current_item_V.get(i).getRemains() > 0) {
				priceCheckV.set(i, true);
			} else {
				priceCheckV.set(i, false);
			}
		}
		return priceCheckV;
	}

	public Vector<Boolean> clear() { // exchange버튼 클릭시 (버튼 적색으로)
		for (int i = 0; i < current_item_V.size(); i++) {
			priceCheckV.set(i, false);
		}

		return priceCheckV;
	}

	public boolean afterRemains(int idx, Color c) { // 구매에 따른 remains재고 변화
		if (c.equals(Color.GREEN)) {

			if (current_item_V.get(idx).getRemains() > 0) {
				current_item_V.get(idx).setRemains(current_item_V.get(idx).getRemains() - 1);
				System.out.println("재고량 " + current_item_V.get(idx).getRemains());
				try {
					writeNowItem();// 현재 아이템의 목록을 저장
				} catch (Exception e) {
					e.printStackTrace();
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void write_TodayRevenue(int idx) {//오늘 판 매출액 저장
		BufferedWriter bw = null;
		String str = null;
		try {
			bw = new BufferedWriter(new FileWriter("todayRevenue.txt"));
			if(idx==100){
				str = "0";
			}else{
				str = current_item_V.get(idx).getPrice() +todayRevenue+ "";								
			}
			bw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public int read_TodayRevenue(){
		BufferedReader readToday =null;
		try {
			readToday = new BufferedReader(new FileReader("todayRevenue.txt"));
			todayRevenue = Integer.parseInt(readToday.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				readToday.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return todayRevenue;
		
	}
}
