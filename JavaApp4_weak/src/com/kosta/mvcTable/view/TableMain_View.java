package com.kosta.mvcTable.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kosta.mvcTable.model.Person;

public class TableMain_View extends JFrame implements Runnable {

	public JButton bt_input;
	public JButton bt_update;
	public JButton bt_del;
	public JButton bt_exit;
	public JButton bt_selectName;
	public JButton bt_selectPersons;
	public JTable table;
	public DefaultTableModel model;

	private JScrollPane scroll;
	private JPanel p, p2;
	private JLabel label;

	Calendar calendar;

	public TableMain_View() {
		init();
		setting();
	}

	private void init() {// ��ü ����
		bt_input = new JButton("�Է�");
		bt_update = new JButton("����");
		bt_del = new JButton("����");
		bt_exit = new JButton("����");
		bt_selectName = new JButton("�κ� �˻�");
		bt_selectPersons = new JButton("��ü �˻�");

		String col[] = { "��ȣ", "�̸�", "����", "����" };
		Object data[][] = new Object[0][4];// 0�� addrow.�� ������ �ε���

		model = new DefaultTableModel(data, col);
		table = new JTable(model);
		scroll = new JScrollPane(table);

		p = new JPanel();
		p2 = new JPanel();

		label = new JLabel("�����ð� : ");
	}

	private void setting() {
		setTitle("MVC CRUD���̺�");

		setLayout(new BorderLayout());

		p.setLayout(new FlowLayout());
		p.add(bt_input);
		p.add(bt_update);
		p.add(bt_del);
		p.add(bt_selectName);
		p.add(bt_selectPersons);
		p.add(bt_exit);

		p2.add(label);
		add("North", p2);
		add("Center", scroll);
		add("South", p);

		setVisible(true);
		setBounds(400, 300, 470, 300);// setBounds(x, y, width, height);

//		setTimeLabel();
//		Thread t = new Thread(this);	t.start();
		new Thread(this).start();
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void display(Vector<Person> whatpersons) {// �κа˻��̵� person�̳� �ƴϸ� ��ü����
														// person�ΰ�..
		Vector<Person> v = whatpersons;
		this.model.setRowCount(0);
		for (int i = 0; i < v.size(); i++) {
			Person p = v.get(i);
			Object row[] = { p.getNo(), p.getName(), p.getAge(), p.getJob() };
			this.model.addRow(row);
		}
	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(1000);
				calendar = new GregorianCalendar();
				p2.setLayout(new FlowLayout());
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;// 1���� 0���� ������
				int date = calendar.get(Calendar.DATE);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int min = calendar.get(Calendar.MINUTE);
				int sec = calendar.get(Calendar.SECOND);
				label.setText("" + year + "�� " + month + "�� " + date + "�� " + hour + "�� " + min + "�� " + sec + "��");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
