package vending_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	Admin_View view;
	Mothod_Model model;
	
	public Controll() {
		init();
		setting();
		eventUp();
	}

	private void init() {
		view = new Admin_View();
		model = new Mothod_Model();
	}

	private void setting() {
	}

	private void eventUp() {
		view.bt_day.addActionListener(this);
		view.bt_weak.addActionListener(this);
		view.bt_year.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == view.bt_day) {
			view.chart = view.getChart(model.getDataSet());//차트를 리턴 받아서
			view.cp.setChart(view.chart);
			System.out.println("*");
			
		} else if (obj == view.bt_weak) {

		} else if (obj == view.bt_year) {

		}
	}

	public static void main(String[] args) {
		new Controll();
	}

}
