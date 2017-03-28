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

	Admin_View admin_view;
	farmItem_View farm_view;
	Mothod_Model model;

	Vector<Vegitable> farmItems;// �� �������� ����
	Vector<Vegitable> sellItems;// �Ǹ��� �������� ����

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
			// �Է�â x��ư-->����
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
			// ����� ���Ͽ��� �ֱ� 1����
			admin_view.chart = admin_view.getChart(model.getDataSet(3));
			// ��Ʈ�� ���� �޾Ƽ�
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
			System.out.println(sellItems.size());// �Ǹ��� �������� ��
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
