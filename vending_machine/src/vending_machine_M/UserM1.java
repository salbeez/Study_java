package vending_machine_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//wf_total(int i) i = 0 �� ��� File total.txt�� ���� �ƴҰ�� todayRevenue.txt�� �ۼ��Ѵ�
public class UserM1 {

	public int sum;// ����ڰ� ����(��ư�� ȭ��) �ѱݾ׷�
	int moneyArr[] = new int[4];// �� ȭ��� ���ǱⰡ ������ ����

	public UserM1(){
		read_exchange();
	}

	public int total(int idx) {
		//idx ��ư ��ȣ 1=õ�� 2=5õ��  

		switch (idx) {
		case 0:
			sum = sum + 1000;
			moneyArr[0]++;
			wf_exchange();//���� �������� �ֽ�ȭ
			wf_total();// ����ڰ� ���� �ݾ��� �ֽ�ȭ
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
			String str = String.valueOf(sum); //����ڰ� ���� ���ݷ�
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

	public void wf_exchange() {//���� ������ �ִ� ����
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

	public void rf_total() {//���� ���� ���� ��������

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

	public void afterExchange(int money) { // �Ž�������ư ��������exchangemoney�� ��ȭ

		read_exchange();

		int change=0;
		int a = 0, b = 0, c = 0, d = 0;
		change = money;
		System.out.println("\t\t\t"+change);
		a = change / 50000;
		b = (change % 50000) / 10000;
		c = ((change % 50000) % 10000) / 5000;
		d = (((change % 50000) % 10000) % 5000) / 1000;
		System.out.print("��ȭ�� : "+moneyArr[0] + " ");
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

		wf_exchange();// ���� �������� �ֽ�ȭ

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
