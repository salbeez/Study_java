package vending_machine;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

//<컨트롤러의 역할> : 프로그램 전체적인 흐름제어
//1. 사용자의 요청(요구) 사항 분석 [버튼 1을 클릭했는지 , 버튼2를 클릭했는지 ...]  obj==bt or bt2
//2. 사용자의 입력한 데이터를 얻어오는거 [] 판단.... 여기에 choice를 놔도 될듯...
//3. 모델 클래스 객체 생성
//=> 메소드 호출0
//=> 결과값을 저장
//4. 이동할 페이지(Frame)를 선택(페이지 이동 제어)
//5. 유효성 검사[추가 옵션] ex) 사용자가 입력한 데이터가 올바른 값인지 뷰단에서도 할수 있음
//6. 인증 or 보안
public class Controll implements ActionListener {

	Admin_View admin_view;
	farmItem_View farm_view;
	Mothod_Model model;

	Vector<Vegitable> farmItems;// 총 아이템의 정보
	Vector<Vegitable> sellItems;// 판매할 아이템의 정보

	int index;

	public Controll() {
		init();
		setting();
		eventUp();
	}

	private void init() {
		admin_view = new Admin_View();
		farm_view = new farmItem_View();
		model = new Mothod_Model();

		sellItems = new Vector<>(8);
	}

	private void setting() {
		farmItems = model.readFarmItems();

		for (int i = 0; i < 8; i++) {
			sellItems.add(null);
		}

		String arrayStr[] = model.exchangeRead();
		admin_view.tf_one.setText(arrayStr[0]);
		admin_view.tf_five.setText(arrayStr[1]);
		admin_view.tf_ten.setText(arrayStr[2]);
		admin_view.tf_fifty.setText(arrayStr[3]);
		
		int total=0;
		total += (Integer.parseInt(arrayStr[0]) * 1000); 
		total += (Integer.parseInt(arrayStr[1]) * 5000); 
		total += (Integer.parseInt(arrayStr[2]) * 10000); 
		total += (Integer.parseInt(arrayStr[3]) * 50000); 
		admin_view.tf_sum.setText(""+total);
	}

	private void eventUp() {
		admin_view.bt_day.addActionListener(this);
		admin_view.bt_weak.addActionListener(this);
		admin_view.bt_year.addActionListener(this);
		admin_view.bt_summit.addActionListener(this);

		for (int i = 0; i < farm_view.bt.length; i++) {
			farm_view.bt[i].addActionListener(this);
		}
		for (int i = 0; i < admin_view.bt_vet.length; i++) {
			admin_view.bt_vet[i].setFont(admin_view.bt_vet[i].getFont().deriveFont(15.0f));
			admin_view.bt_vet[i].addActionListener(this);
		}

		farm_view.addWindowListener(new WindowAdapter() {
			// 입력창 x버튼-->메인
			public void windowClosing(WindowEvent e) {
				admin_view.setVisible(true);
				farm_view.setVisible(false);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == admin_view.bt_day) {
			// 저장된 파일에서 최근 1주일
			admin_view.chart = admin_view.getChart(model.getDataSet(3));
			// 차트를 리턴 받아서
		} else if (obj == admin_view.bt_weak) {
			admin_view.chart = admin_view.getChart(model.getDataSet(2));
		} else if (obj == admin_view.bt_year) {
			admin_view.chart = admin_view.getChart(model.getDataSet(1));
		} else if (obj == admin_view.bt_vet[0]) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);
			index = 0;
		} else if (obj == admin_view.bt_vet[1]) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);
			index = 1;
		} else if (obj == admin_view.bt_vet[2]) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);
			index = 2;
		} else if (obj == admin_view.bt_vet[3]) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);
			index = 3;
		} else if (obj == admin_view.bt_vet[4]) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);
			index = 4;
			System.out.println("****");
		} else if (obj == admin_view.bt_vet[5]) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);
			index = 5;
		} else if (obj == admin_view.bt_vet[6]) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);
			index = 6;
		} else if (obj == admin_view.bt_vet[7]) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);
			index = 7;
		} else if (obj == admin_view.bt_summit) {
			System.out.println("전송");
			model.exchangeWirte();
			// exchange.txt
		} else {// 나머지 16개의 버튼
			JButton bt = (JButton) obj;
			int i = Integer.parseInt(bt.getLabel()) - 1;//
			sellItems.set(index, farmItems.get(i));
			admin_view.bt_vet[index].setLabel(sellItems.get(index).getName());
			System.out.println("판매할 이이템의 수 : " + sellItems.size());// 판매할 아이템의 수
			farm_view.setVisible(false);
			admin_view.setVisible(true);

			for (int j = 0; j < sellItems.size(); j++) {
				if (sellItems.get(j) != null) {
					System.out.println(j + 1 + " " + sellItems.get(j).getName());
				}
			}
		}
		admin_view.cp.setPreferredSize(new Dimension(300, 400));
		admin_view.cp.setChart(admin_view.chart);
	}

	public static void main(String[] args) {
		new Controll();
	}

}
