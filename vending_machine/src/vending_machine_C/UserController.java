package vending_machine_C;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.ImageIcon;

import vending_machine_M.UserM1;
import vending_machine_M.UserModel;
import vending_machine_V.UserView;
import vending_machine_V.Vegitable;

public class UserController implements ActionListener, Runnable {

	// ����
	UserView uv;
	Vector<Vegitable> current_item_V;
	// �𵨵��
	UserM1 m1;
	UserModel user_model;
	Calendar currentCal;
	Calendar saveTimeCal;

	public UserController() {
		uv = new UserView();
		m1 = new UserM1();
		user_model = new UserModel();
		initialize();
		eventUp();

		saveTimeCal = new GregorianCalendar();

		Thread time = new Thread(this);
		time.start();
	}

	public void eventUp() {//
		// ��ǰ�޴� Ŭ���� 1~8
		for (int i = 0; i < 8; i++) {
			uv.bt_menu[i].addActionListener(this);
		}

		// ����ư Ŭ���� 1~4
		uv.bt_bill1.addActionListener(this);
		uv.bt_bill5.addActionListener(this);
		uv.bt_bill10.addActionListener(this);
		uv.bt_bill50.addActionListener(this);

		// ��ȯ��ư Ŭ����
		uv.bt_out.addActionListener(this);

		// ��ȯ��ư Ŭ����
		uv.bt_exch.addActionListener(this);

		// ������ ��ư Ŭ����
		uv.bt_admin.addActionListener(this);

		// ������ �����ư Ŭ����
		// uv.bt_re.addActionListener(this);

	}

	public void initialize() {

		// ���� �������� ȣ��
		current_item_V = user_model.readCurrnetItem();

		for (int i = 0; i < 8; i++) {
			if (!current_item_V.get(i).getName().equals("0")) {// �ش� �ε����� �����ڰ�
																// �������� �־��ٸ�
				// ��, 0�� �ƴ϶��
				uv.la[i].setIcon(new ImageIcon(current_item_V.get(i).getPath()));
			} else {
				uv.la[i].setIcon(new ImageIcon("image/m.jpg"));
			}
		}

		for (int i = 0; i < 8; i++) {
			if (current_item_V.get(i).getRemains() > 0) {
				uv.bt_menu[i].setText(current_item_V.get(i).getPrice() + "��");
			} else {
				uv.bt_menu[i].setText("����");
			}
		}
		m1.rf_total();
		uv.tf_balance.setText(m1.sum + "");// sum�� ����ڰ� ���� ����
		menu(user_model.onOff(m1.sum));// ���⼭ Į����

	}// initialize

	public void menu(Vector<Boolean> v) {
		for (int i = 0; i < 8; i++)
			if (v.get(i)) {
				uv.bt_menu[i].setBackground(Color.GREEN);
			} else {
				uv.bt_menu[i].setBackground(Color.RED);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		int idx = -1;
		int total = m1.sum;// ����ڰ� ���� �ݾ�

		if (ob == uv.bt_bill1) {// 1000�� ��ư�� ��������
			cur_UserMoney(m1.total(0));

		} else if (ob == uv.bt_bill5) {// 5000�� ��ư�� ��������
			cur_UserMoney(m1.total(1));
		} else if (ob == uv.bt_bill10) {// 10000�� ��ư�� ��������
			cur_UserMoney(m1.total(2));
		} else if (ob == uv.bt_bill50) {// 50000�� ��ư�� ��������
			cur_UserMoney(m1.total(3));
		} else if (ob == uv.bt_exch) {// ������ȯ ��ư�� ��������
			// Ŭ���� ���� �ִ� tf�� ���� ������̴�
			m1.afterExchange(total);// ���� �������� ����
			menu(user_model.clear());// �ʷϺ��� ���� ����������
			total = 0;// ����ڰ� ���� ����=0
			m1.clear();// ����ڰ� ���� ���ݷ� ,txt���ϵ� 0���� ����
			uv.tf_balance.setText("0");

		} else if (ob == uv.bt_menu[0]) {// ��ǰ 1�� ��������
			System.out.println("======");
			idx = 0;
			another(idx);
		} else if (ob == uv.bt_menu[1]) {// ��ǰ 2�� ��������
			idx = 1;
			another(idx);
		} else if (ob == uv.bt_menu[2]) {// ��ǰ 3�� ��������
			idx = 2;
			another(idx);
		} else if (ob == uv.bt_menu[3]) {// ��ǰ 4�� ��������
			idx = 3;
			another(idx);
		} else if (ob == uv.bt_menu[4]) {// ��ǰ 5�� ��������
			idx = 4;
			another(idx);
		} else if (ob == uv.bt_menu[5]) {// ��ǰ 6�� ��������
			idx = 5;
			another(idx);
		} else if (ob == uv.bt_menu[6]) {// ��ǰ 7�� ��������
			idx = 6;
			another(idx);
		} else if (ob == uv.bt_menu[7]) {// ��ǰ 8�� ��������
			idx = 7;
			another(idx);
		} else if (ob == uv.bt_out) {
			uv.la_out.setIcon(new ImageIcon("image/m.jpg"));

		}

	}// actionperformed

	public void cur_UserMoney(int userMoney) {
		System.out.println("����ڰ� ���� ���ݷ�" + userMoney);
		uv.tf_balance.setText("" + userMoney);
		Vector<Boolean> v = user_model.onOff(userMoney);// 1000��
		menu(v);
	}

	public void another(int idx) {
		uv.ta_info.setText("\n\t��ǰ����\n");
		uv.ta_info.append("\t��ǰ��: " + current_item_V.get(idx).getName() + "\n");
		uv.ta_info.append("\t����: " + current_item_V.get(idx).getPrice() + "��\n");
		uv.ta_info.append("\t������: " + current_item_V.get(idx).getFarmer() + "\n");

		if (user_model.afterRemains(idx, uv.bt_menu[idx].getBackground())) {
			uv.bt_menu[idx].setBackground(Color.RED);
			uv.bt_menu[idx].setText("����");
			m1.sum = m1.sum - current_item_V.get(idx).getPrice();// �ܾ�

			user_model.read_TodayRevenue();// ���� ���� ������� �ִ��� Ȯ����
			user_model.write_TodayRevenue(idx);// ����� ��� ����
			uv.tf_balance.setText(m1.sum + "");
			System.out.println(m1.sum);
			m1.wf_total();
			menu(user_model.onOff(m1.sum));
			uv.la[idx].setIcon(new ImageIcon("image/m.jpg"));
			uv.la_out.setIcon(new ImageIcon(current_item_V.get(idx).getPath()));
			// ��ǰ���Կ� �����ϸ� �̹��� ������ �̵��ϴ� uv �� �ִ� �޼ҵ带 ȣ��
			// �̹��� uv.la1~la8
			// ���ⱸ :uv.la_out
		}
	}

	@Override
	public void run() {
		Calendar cal = new GregorianCalendar();
		
		System.out.println(saveTimeCal.getTime());
		while (true) {
			
			currentCal = cal.getInstance();
			String cur_time = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(currentCal.getTime());
			
			saveTimeCal.set(2017, currentCal.get(Calendar.MONTH), currentCal.get(Calendar.DATE), 23, 59, 59);
			String savePoint = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(saveTimeCal.getTime());
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy,MM,dd,");
			System.out.println(savePoint+"=="+cur_time);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (cur_time.equals(savePoint)) {// �� 11�� 59�� 59�ʶ��
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter("selldata2.txt", true));// �̾��
																					// ����
					// ������ ������ �а�;
					String todayRevenueWrite = formatter.format(currentCal.getTime()) + user_model.read_TodayRevenue() + "\n";

					bw.write(todayRevenueWrite);
					System.out.println("���� ����� ����");
					//������� �ʱ�ȭ
					user_model.todayRevenue=0;
					user_model.write_TodayRevenue(100);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(currentCal.getTime());
		}
	}

	/*
	 * public static void main(String[] args) throws Exception { UserController
	 * c = new UserController(); }
	 */
}
