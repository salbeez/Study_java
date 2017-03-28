package vending_machine;

import java.awt.Dimension;
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

	public Controll() {
		init();
		setting();
		eventUp();
	}

	private void init() {
		admin_view = new Admin_View();
		farm_view = new farmItem_View();
		model = new Mothod_Model();

		sellItems = new Vector<>();
	}

	private void setting() {
		farmItems = model.readFarmItems();
		System.out.println(farmItems.size());
	}

	private void eventUp() {
		admin_view.bt_day.addActionListener(this);
		admin_view.bt_weak.addActionListener(this);
		admin_view.bt_year.addActionListener(this);
		admin_view.bt_img.addActionListener(this);

		farm_view.bt[0].addActionListener(this);
		farm_view.bt[1].addActionListener(this);
		farm_view.bt[2].addActionListener(this);
		farm_view.bt[3].addActionListener(this);
		farm_view.bt[4].addActionListener(this);
		farm_view.bt[5].addActionListener(this);
		farm_view.bt[6].addActionListener(this);
		farm_view.bt[7].addActionListener(this);
		farm_view.bt[8].addActionListener(this);
		farm_view.bt[9].addActionListener(this);
		farm_view.bt[10].addActionListener(this);
		farm_view.bt[11].addActionListener(this);
		farm_view.bt[12].addActionListener(this);
		farm_view.bt[13].addActionListener(this);
		farm_view.bt[14].addActionListener(this);
		farm_view.bt[15].addActionListener(this);

		admin_view.bt_vet1.addActionListener(this);
		admin_view.bt_vet2.addActionListener(this);
		admin_view.bt_vet3.addActionListener(this);
		admin_view.bt_vet4.addActionListener(this);
		admin_view.bt_vet5.addActionListener(this);
		admin_view.bt_vet6.addActionListener(this);
		admin_view.bt_vet7.addActionListener(this);
		admin_view.bt_vet8.addActionListener(this);

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
		} else if (obj == admin_view.bt_img) {
			admin_view.setVisible(false);
			farm_view.setVisible(true);

		} else if (obj == admin_view.bt_vet1) {

		} else if (obj == admin_view.bt_vet2) {

		} else if (obj == admin_view.bt_vet3) {

		} else if (obj == admin_view.bt_vet4) {

		} else if (obj == admin_view.bt_vet5) {

		} else if (obj == admin_view.bt_vet6) {

		} else if (obj == admin_view.bt_vet7) {

		} else if (obj == admin_view.bt_vet8) {

		} else {
			JButton bt = (JButton) obj;
			int i = Integer.parseInt(bt.getLabel()) - 1;//
			sellItems.add(farmItems.get(i));
			// sellItems.set----------
			System.out.println(sellItems.size());// 판매할 아이템의 수
			farm_view.setVisible(false);
			admin_view.setVisible(true);

			for (int j = 0; j < sellItems.size(); j++) {
				System.out.println(sellItems.get(j).getName());
			}
		}
		admin_view.cp.setPreferredSize(new Dimension(300, 400));
		admin_view.cp.setChart(admin_view.chart);
	}

	public static void main(String[] args) {
		new Controll();
	}

}
