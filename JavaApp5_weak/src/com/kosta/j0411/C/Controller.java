package com.kosta.j0411.C;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.kosta.j0411.M.PersonDAO;
import com.kosta.j0411.M.PersonDTO;
import com.kosta.j0411.V.InputForm;
import com.kosta.j0411.V.MainView;
import com.kosta.j0411.V.UpForm;

public class Controller implements ActionListener {

	MainView main_v;
	InputForm form;
	UpForm upform;
	PersonDAO dao;

	public Controller() {
		main_v = new MainView();
		form = new InputForm();
		upform = new UpForm();
		eventUp();

		dao = new PersonDAO();
		main_v.bt_delete.setEnabled(false);
		main_v.bt_update.setEnabled(false);
	}

	public static void main(String[] args) {
		new Controller();

		PersonDAO dao = new PersonDAO();
	}

	// ������ ���
	private void eventUp() {
		// ���κ�
		main_v.bt_insert.addActionListener(this);
		main_v.bt_update.addActionListener(this);
		main_v.bt_delete.addActionListener(this);
		main_v.bt_exit.addActionListener(this);
		main_v.bt_search_name.addActionListener(this);
		main_v.bt_search_all.addActionListener(this);

		// �Է���
		form.bt_submit.addActionListener(this);
		form.bt_reset.addActionListener(this);

		// ������
		upform.bt_submit.addActionListener(this);
		upform.bt_reset.addActionListener(this);

		form.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				form.setVisible(false);
				main_v.setVisible(true);
			}
		});

		upform.addWindowListener(new WindowAdapter() {
			// ������X��ư ----> ����
			public void windowClosing(WindowEvent e) {
				upform.setVisible(false);
				main_v.setVisible(true);
			}
		});

		main_v.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				main_v.bt_delete.setEnabled(true);
				main_v.bt_update.setEnabled(true);
			}
		});

	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == main_v.bt_insert) {
			main_v.setVisible(false);
			form.setVisible(true);
		} else if (obj == form.bt_submit) {// �Է��� -> �Է� ��ư ����

			PersonDTO person = new PersonDTO();

			person.setName(form.tf_name.getText());
			if (form.tf_age.getText().matches("[0-9]+")) {
				person.setAge(Integer.parseInt(form.tf_age.getText()));
			} else {
				main_v.showMsg("���ڸ� �Է� , ������ ��:0");
			}
			person.setJob(form.tf_job.getText());

			if (dao.insert(person)) {
				System.out.println("����");
				main_v.displayTable(dao.selectAll());
				form.setVisible(false);
				main_v.setVisible(true);
				main_v.showMsg("�Է� ����");
			} else {
				System.out.println("����");
				form.showMsg("�Է�  ����");
				form.initText();
			}
		} else if (obj == main_v.bt_update) {
			main_v.setVisible(false);
			upform.setVisible(true);

		} else if (obj == upform.bt_submit) {
			int row = main_v.table.getSelectedRow();
			int no = Integer.parseInt(main_v.table.getValueAt(row, 0).toString());
			System.out.println(no);
			PersonDTO person = new PersonDTO(no, upform.tf_name.getText(), Integer.parseInt(upform.tf_age.getText()),
					upform.tf_job.getText());
			if (dao.update(person)) {
				System.out.println("���� ����");
				main_v.displayTable(dao.selectAll());
				upform.setVisible(false);
				main_v.setVisible(true);
				main_v.showMsg("���� ����");
				upform.initText();
				main_v.displayTable(dao.selectAll());
			} else {
				System.out.println("����");
			}
			main_v.bt_delete.setEnabled(false);
			main_v.bt_update.setEnabled(false);
		} else if (obj == main_v.bt_search_name) {
			String name = JOptionPane.showInputDialog("�˻��� �ܾ�� �����ϴ� ��� �̸��� ã���ϴ�");
			main_v.displayTable(dao.select(name));

		} else if (obj == main_v.bt_delete) {// ����
			int row = main_v.table.getSelectedRow();
			int no = Integer.parseInt(main_v.table.getValueAt(row, 0).toString());
			if (dao.delete(no)) {
				main_v.displayTable(dao.selectAll());
				main_v.showMsg("���� ����");
			}
			main_v.bt_delete.setEnabled(false);
			main_v.bt_update.setEnabled(false);
		} else if (obj == main_v.bt_search_all) {
			main_v.displayTable(dao.selectAll());
		} else if (obj == main_v.bt_exit) {
			System.exit(0);
		}
	}

}
