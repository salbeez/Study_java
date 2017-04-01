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

	// 뷰등록
	UserView uv;
	Vector<Vegitable> current_item_V;
	// 모델등록
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
		// 재품메뉴 클릭시 1~8
		for (int i = 0; i < 8; i++) {
			uv.bt_menu[i].addActionListener(this);
		}

		// 돈버튼 클릭시 1~4
		uv.bt_bill1.addActionListener(this);
		uv.bt_bill5.addActionListener(this);
		uv.bt_bill10.addActionListener(this);
		uv.bt_bill50.addActionListener(this);

		// 반환버튼 클릭시
		uv.bt_out.addActionListener(this);

		// 반환버튼 클릭시
		uv.bt_exch.addActionListener(this);

		// 관리자 버튼 클릭시
		uv.bt_admin.addActionListener(this);

		// 관리자 종료버튼 클릭시
		// uv.bt_re.addActionListener(this);

	}

	public void initialize() {

		// 현재 아이템을 호출
		current_item_V = user_model.readCurrnetItem();

		for (int i = 0; i < 8; i++) {
			if (!current_item_V.get(i).getName().equals("0")) {// 해당 인덱스에 관리자가
																// 아이템을 넣었다면
				// 즉, 0이 아니라면
				uv.la[i].setIcon(new ImageIcon(current_item_V.get(i).getPath()));
			} else {
				uv.la[i].setIcon(new ImageIcon("image/m.jpg"));
			}
		}

		for (int i = 0; i < 8; i++) {
			if (current_item_V.get(i).getRemains() > 0) {
				uv.bt_menu[i].setText(current_item_V.get(i).getPrice() + "원");
			} else {
				uv.bt_menu[i].setText("매진");
			}
		}
		m1.rf_total();
		uv.tf_balance.setText(m1.sum + "");// sum은 사용자가 넣은 현금
		menu(user_model.onOff(m1.sum));// 여기서 칼라설정

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
		int total = m1.sum;// 사용자가 넣은 금액

		if (ob == uv.bt_bill1) {// 1000원 버튼을 눌렀을때
			cur_UserMoney(m1.total(0));

		} else if (ob == uv.bt_bill5) {// 5000원 버튼을 눌렀을때
			cur_UserMoney(m1.total(1));
		} else if (ob == uv.bt_bill10) {// 10000원 버튼을 눌렀을때
			cur_UserMoney(m1.total(2));
		} else if (ob == uv.bt_bill50) {// 50000원 버튼을 눌렀을때
			cur_UserMoney(m1.total(3));
		} else if (ob == uv.bt_exch) {// 동전반환 버튼을 눌렀을때
			// 클리어 전에 있는 tf의 값이 매출액이다
			m1.afterExchange(total);// 현금 보유량을 변경
			menu(user_model.clear());// 초록불을 전부 빨간색으로
			total = 0;// 사용자가 넣은 현금=0
			m1.clear();// 사용자가 넣은 현금량 ,txt파일도 0으로 만듬
			uv.tf_balance.setText("0");

		} else if (ob == uv.bt_menu[0]) {// 제품 1을 눌렀을때
			System.out.println("======");
			idx = 0;
			another(idx);
		} else if (ob == uv.bt_menu[1]) {// 제품 2을 눌렀을때
			idx = 1;
			another(idx);
		} else if (ob == uv.bt_menu[2]) {// 제품 3을 눌렀을때
			idx = 2;
			another(idx);
		} else if (ob == uv.bt_menu[3]) {// 제품 4을 눌렀을때
			idx = 3;
			another(idx);
		} else if (ob == uv.bt_menu[4]) {// 제품 5을 눌렀을때
			idx = 4;
			another(idx);
		} else if (ob == uv.bt_menu[5]) {// 제품 6을 눌렀을때
			idx = 5;
			another(idx);
		} else if (ob == uv.bt_menu[6]) {// 제품 7을 눌렀을때
			idx = 6;
			another(idx);
		} else if (ob == uv.bt_menu[7]) {// 제품 8을 눌렀을때
			idx = 7;
			another(idx);
		} else if (ob == uv.bt_out) {
			uv.la_out.setIcon(new ImageIcon("image/m.jpg"));

		}

	}// actionperformed

	public void cur_UserMoney(int userMoney) {
		System.out.println("사용자가 넣은 현금량" + userMoney);
		uv.tf_balance.setText("" + userMoney);
		Vector<Boolean> v = user_model.onOff(userMoney);// 1000원
		menu(v);
	}

	public void another(int idx) {
		uv.ta_info.setText("\n\t상품정보\n");
		uv.ta_info.append("\t상품명: " + current_item_V.get(idx).getName() + "\n");
		uv.ta_info.append("\t가격: " + current_item_V.get(idx).getPrice() + "원\n");
		uv.ta_info.append("\t생산자: " + current_item_V.get(idx).getFarmer() + "\n");

		if (user_model.afterRemains(idx, uv.bt_menu[idx].getBackground())) {
			uv.bt_menu[idx].setBackground(Color.RED);
			uv.bt_menu[idx].setText("매진");
			m1.sum = m1.sum - current_item_V.get(idx).getPrice();// 잔액

			user_model.read_TodayRevenue();// 먼저 그전 매출액이 있는지 확인후
			user_model.write_TodayRevenue(idx);// 매출액 계산 저장
			uv.tf_balance.setText(m1.sum + "");
			System.out.println(m1.sum);
			m1.wf_total();
			menu(user_model.onOff(m1.sum));
			uv.la[idx].setIcon(new ImageIcon("image/m.jpg"));
			uv.la_out.setIcon(new ImageIcon(current_item_V.get(idx).getPath()));
			// 상품구입에 성공하면 이미지 파일을 이동하는 uv 에 있는 메소드를 호출
			// 이미지 uv.la1~la8
			// 배출구 :uv.la_out
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

			if (cur_time.equals(savePoint)) {// 밤 11시 59분 59초라면
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter("selldata2.txt", true));// 이어쓰기
																					// 가능
					// 오늘의 매출을 읽고;
					String todayRevenueWrite = formatter.format(currentCal.getTime()) + user_model.read_TodayRevenue() + "\n";

					bw.write(todayRevenueWrite);
					System.out.println("오늘 매출액 저장");
					//매출액의 초기화
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
