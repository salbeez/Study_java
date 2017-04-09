package vending_machine_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//wf_total(int i) i = 0 일 경우 File total.txt에 쓰고 아닐경우 todayRevenue.txt에 작성한단
public class UserM1 {

	public int sum;// 사용자가 누른(버튼이 화폐) 총금액량
	int moneyArr[] = new int[4];// 각 화폐당 자판기가 보유한 지폐량

	public UserM1(){
		read_exchange();
	}

	public int total(int idx) {
		//idx 버튼 번호 1=천원 2=5천원  

		switch (idx) {
		case 0:
			sum = sum + 1000;
			moneyArr[0]++;
			wf_exchange();//지폐 보유량의 최신화
			wf_total();// 사용자가 넣은 금액의 최신화
			break;
		case 1:
			sum = sum + 5000;
			moneyArr[1]++;
			wf_exchange();
			wf_total();
			break;

		case 2:
			sum = sum + 10000;
			moneyArr[2]++;
			wf_exchange();
			wf_total();
			break;

		case 3:
			sum = sum + 50000;
			moneyArr[3]++;
			wf_exchange();
			wf_total();

		}
		return sum;
	}

	public void clear() {
		sum = 0;
		wf_total();
	}

	public void wf_total() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("total.txt"));
			String str = String.valueOf(sum); //사용자가 넣은 현금량
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

	public void wf_exchange() {//현재 가지고 있는 지폐량
		BufferedWriter bw = null;
		String str = null;
		try {
			bw = new BufferedWriter(new FileWriter("exchange.txt"));
			str = moneyArr[0] + "," + moneyArr[1] + "," + moneyArr[2] + "," + moneyArr[3];
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

	public void rf_total() {//사고로 인한 전원 꺼졌을시

		String str = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("total.txt"));
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		sum = Integer.parseInt(str);
	}

	public void afterExchange(int money) { // 거스름돈버튼 눌렀을때exchangemoney의 변화

		read_exchange();

		int change=0;
		int a = 0, b = 0, c = 0, d = 0;
		change = money;
		System.out.println("\t\t\t"+change);
		a = change / 50000;
		b = (change % 50000) / 10000;
		c = ((change % 50000) % 10000) / 5000;
		d = (((change % 50000) % 10000) % 5000) / 1000;
		System.out.print("변화전 : "+moneyArr[0] + " ");
		System.out.print(""+moneyArr[1] + " ");
		System.out.print(""+moneyArr[2] + " ");
		System.out.println(""+moneyArr[3]);
		
		moneyArr[0] = (moneyArr[0] - d);
		moneyArr[1] = (moneyArr[1] - c);
		moneyArr[2] = (moneyArr[2] - b);
		moneyArr[3] = (moneyArr[3] - a);

		System.out.print(""+moneyArr[0] + " ");
		System.out.print(""+moneyArr[1] + " ");
		System.out.print(""+moneyArr[2] + " ");
		System.out.println(""+moneyArr[3]);

		wf_exchange();// 현금 보유량의 최신화

	}// afterExchange
	
	public void read_exchange() {

		String str[] = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("exchange.txt"));
			str = (br.readLine()).split(",");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 4; i++) {
			moneyArr[i] = Integer.parseInt(str[i]);
		}

	}
}
