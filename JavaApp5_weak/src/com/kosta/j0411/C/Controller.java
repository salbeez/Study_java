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

	// 연결자 등록
	private void eventUp() {
		// 메인뷰
		main_v.bt_insert.addActionListener(this);
		main_v.bt_update.addActionListener(this);
		main_v.bt_delete.addActionListener(this);
		main_v.bt_exit.addActionListener(this);
		main_v.bt_search_name.addActionListener(this);
		main_v.bt_search_all.addActionListener(this);

		// 입력폼
		form.bt_submit.addActionListener(this);
		form.bt_reset.addActionListener(this);

		// 수정폼
		upform.bt_submit.addActionListener(this);
		upform.bt_reset.addActionListener(this);

		form.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				form.setVisible(false);
				main_v.setVisible(true);
			}
		});

		upform.addWindowListener(new WindowAdapter() {
			// 수정폼X버튼 ----> 메인
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
		} else if (obj == form.bt_submit) {// 입력폼 -> 입력 버튼 누름

			PersonDTO person = new PersonDTO();

			person.setName(form.tf_name.getText());
			if (form.tf_age.getText().matches("[0-9]+")) {
				person.setAge(Integer.parseInt(form.tf_age.getText()));
			} else {
				main_v.showMsg("숫자만 입력 , 디폴드 값:0");
			}
			person.setJob(form.tf_job.getText());

			if (dao.insert(person)) {
				System.out.println("성공");
				main_v.displayTable(dao.selectAll());
				form.setVisible(false);
				main_v.setVisible(true);
				main_v.showMsg("입력 성공");
			} else {
				System.out.println("실패");
				form.showMsg("입력  실패");
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
				System.out.println("수정 성공");
				main_v.displayTable(dao.selectAll());
				upform.setVisible(false);
				main_v.setVisible(true);
				main_v.showMsg("수정 성공");
				upform.initText();
				main_v.displayTable(dao.selectAll());
			} else {
				System.out.println("실패");
			}
			main_v.bt_delete.setEnabled(false);
			main_v.bt_update.setEnabled(false);
		} else if (obj == main_v.bt_search_name) {
			String name = JOptionPane.showInputDialog("검색할 단어로 시작하는 모든 이름을 찾습니다");
			main_v.displayTable(dao.select(name));

		} else if (obj == main_v.bt_delete) {// 삭제
			int row = main_v.table.getSelectedRow();
			int no = Integer.parseInt(main_v.table.getValueAt(row, 0).toString());
			if (dao.delete(no)) {
				main_v.displayTable(dao.selectAll());
				main_v.showMsg("삭제 성공");
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
