package vending_machine_C;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;

import vending_machine_M.Method_Model_Admin;
import vending_machine_V.Admin_View;
import vending_machine_V.Vegitable;
import vending_machine_V.farmItem_View;


//<��Ʈ�ѷ��� ����> : ���α׷� ��ü���� �帧����
//1. ������� ��û(�䱸) ���� �м� [��ư 1�� Ŭ���ߴ��� , ��ư2�� Ŭ���ߴ��� ...]  obj==bt or bt2
//2. ������� �Է��� �����͸� �����°� [] �Ǵ�.... ���⿡ choice�� ���� �ɵ�...
//3. �� Ŭ���� ��ü ����
//=> �޼ҵ� ȣ��0
//=> ������� ����
//4. �̵��� ������(Frame)�� ����(������ �̵� ����)
//5. ��ȿ�� �˻�[�߰� �ɼ�] ex) ����ڰ� �Է��� �����Ͱ� �ùٸ� ������ ��ܿ����� �Ҽ� ����
//6. ���� or ����
public class Controll_Admin implements ActionListener {

	Admin_View admin_view;
	farmItem_View farm_view;
	Method_Model_Admin model;

	Vector<Vegitable> farmItems;// �� �������� ����
	public Vector<Vegitable> sellItems;// �Ǹ��� �������� ����

	int index;

	public Controll_Admin() {
		init();
		setting();
		eventUp();
	}

	private void init() {
		admin_view = new Admin_View();
		farm_view = new farmItem_View();
		model = new Method_Model_Admin();

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
		admin_view.bt_re.addActionListener(this);
		
		for (int i = 0; i < farm_view.bt.length; i++) {
			farm_view.bt[i].addActionListener(this);
		}
		for (int i = 0; i < admin_view.bt_vet.length; i++) {
			admin_view.bt_vet[i].setFont(admin_view.bt_vet[i].getFont().deriveFont(15.0f));
			admin_view.bt_vet[i].addActionListener(this);
		}

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
			System.out.println("����");
			String money[]= new String[4];
			money[0] = admin_view.tf_one.getText();
			money[1] = admin_view.tf_five.getText();
			money[2] = admin_view.tf_ten.getText();
			money[3] = admin_view.tf_fifty.getText();
			
			model.exchangeWirte(money);
			// exchange.txt
		} else if(obj == admin_view.bt_re){
/*			//������ �Ǹ� �������� nowItem.ser�� �ִ´�
			model.currentSellItems(sellItems);
			System.out.println("���� ��");*/
		}else {// ������ 16���� ��ư
			JButton bt = (JButton) obj;
			int i = Integer.parseInt(bt.getLabel()) - 1;//
			sellItems.set(index, farmItems.get(i));
			admin_view.bt_vet[index].setLabel(sellItems.get(index).getName());
			System.out.println("�Ǹ��� �������� �� : " + sellItems.size());// �Ǹ��� �������� ��
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
/*
	public static void main(String[] args) {
		new Controll_Admin();
	}
*/
}