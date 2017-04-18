package com.kosta.j0412.V;

import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kosta.j0411.M.PersonDTO;
import com.kosta.j0412.M.PersonBean;

public class ServiceForm extends JFrame {

	DefaultTableModel dtm;
	public JTable table;
	JScrollPane scroll_table;// ��ũ�ѹٰ� �ִ� JTable

	public JButton bt_view, bt_update, bt_delete, bt_search;

	JPanel southp, northp;

	public ServiceForm() {
		init();
		setting();
	}

	private void init() {
		String columnNames[] = { "ID", "�̸�", "����", "����", "��ȭ��ȣ", "�ּ�" };
		Object data[][] = new Object[0][6];

		dtm = new DefaultTableModel(data, columnNames);
		table = new JTable(dtm);
		scroll_table = new JScrollPane(table);

		bt_view = new JButton("����");
		bt_update = new JButton("����");
		bt_delete = new JButton("����");
		bt_search = new JButton("�˻�");

		southp = new JPanel();
		northp = new JPanel();
	}

	private void setting() {
		southp.add(bt_view);
		southp.add(bt_update);
		southp.add(bt_delete);
		southp.add(bt_search);

		add("Center", scroll_table);
		add("South", southp);

		setBounds(300, 200, 500, 300);
		setVisible(false);

	}

	public void displayTable(Vector<PersonBean> v) {
		dtm.setRowCount(0);// ���� �����͸� ����� 0�� ���� �ٽ� ī��Ʈ(���)
		for (int i = 0; i < v.size(); i++) {
			PersonBean p = v.get(i);
			String gender = null;
			int age = 0;

			System.out.println("\t\t"+p.getSsn1().substring(0, 2));
			if (p.getSsn1().startsWith("0")) {
				age = 2017 - (Integer.parseInt(p.getSsn1().substring(0, 2)) + 1 + 2000);
			} else {
				age = 2017 - (Integer.parseInt(p.getSsn1().substring(0, 2)) + 1 + 1900);
			}
			if (p.getSsn2().substring(0, 1).equals("1") || p.getSsn2().substring(0, 1).equals("3")) {
				gender = "��";
			} else {
				gender = "��";
			}
			Object row[] = { p.getId(), p.getName(), age, gender, p.getTel(), p.getAddr() };
			dtm.addRow(row);
		}
	}// displayTable

	public void showMsg(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	public String showInputMsg() {
		return JOptionPane.showInputDialog(this, "�˻� �� �ܾ�� �����ϴ� ID�� ã���ϴ� ");
	}
}
