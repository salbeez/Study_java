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

	private void init() {// 객체 생성
		bt_input = new JButton("입력");
		bt_update = new JButton("수정");
		bt_del = new JButton("삭제");
		bt_exit = new JButton("종료");
		bt_selectName = new JButton("부분 검색");
		bt_selectPersons = new JButton("전체 검색");

		String col[] = { "번호", "이름", "나이", "직업" };
		Object data[][] = new Object[0][4];// 0행 addrow.시 시작할 인덱스

		model = new DefaultTableModel(data, col);
		table = new JTable(model);
		scroll = new JScrollPane(table);

		p = new JPanel();
		p2 = new JPanel();

		label = new JLabel("현제시간 : ");
	}

	private void setting() {
		setTitle("MVC CRUD테이블");

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

	public void display(Vector<Person> whatpersons) {// 부분검색이된 person이냐 아니면 전체적인
														// person인가..
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
				int month = calendar.get(Calendar.MONTH) + 1;// 1월을 0으로 시작함
				int date = calendar.get(Calendar.DATE);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int min = calendar.get(Calendar.MINUTE);
				int sec = calendar.get(Calendar.SECOND);
				label.setText("" + year + "년 " + month + "월 " + date + "일 " + hour + "시 " + min + "분 " + sec + "초");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
