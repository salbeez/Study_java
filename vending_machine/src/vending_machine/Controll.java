package vending_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

//<��Ʈ�ѷ��� ����> : ���α׷� ��ü���� �帧����
//1. ������� ��û(�䱸) ���� �м� [��ư 1�� Ŭ���ߴ��� , ��ư2�� Ŭ���ߴ��� ...]  obj==bt or bt2
//2. ������� �Է��� �����͸� �����°� [] �Ǵ�.... ���⿡ choice�� ���� �ɵ�...
//3. �� Ŭ���� ��ü ����
//=> �޼ҵ� ȣ��0
//=> ������� ����
//4. �̵��� ������(Frame)�� ����(������ �̵� ����)
//5. ��ȿ�� �˻�[�߰� �ɼ�] ex) ����ڰ� �Է��� �����Ͱ� �ùٸ� ������ ��ܿ����� �Ҽ� ����
//6. ���� or ����
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
			view.chart = view.getChart(model.getDataSet());//��Ʈ�� ���� �޾Ƽ�
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
