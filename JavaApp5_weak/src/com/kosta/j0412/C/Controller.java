package com.kosta.j0412.C;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import com.kosta.j0411.V.UpForm;
import com.kosta.j0412.M.Method_DAO;
import com.kosta.j0412.M.PersonBean;
import com.kosta.j0412.V.JoinForm;
import com.kosta.j0412.V.LoginForm;
import com.kosta.j0412.V.ServiceForm;
import com.kosta.j0412.V.UpdateForm;

public class Controller implements ActionListener {

	JoinForm join_v;
	UpdateForm upjoin_v;
	ServiceForm serv_v;
	LoginForm log_v;

	public Controller() {
		init();
		eventUp();
	}

	private void init() {
		join_v = new JoinForm();
		upjoin_v = new UpdateForm();
		serv_v = new ServiceForm();
		log_v = new LoginForm();

		serv_v.bt_delete.setEnabled(false);
		serv_v.bt_update.setEnabled(false);
	}

	private boolean pw_confirmation() {
		if (new String(join_v.pw.getPassword()).equals(new String(join_v.pw2.getPassword()))) {
			return true;
		} else {
			join_v.pw.setText("");
			join_v.pw2.setText("");
			join_v.showMsg("��� �ٽ� Ȯ��");
			return false;
		}
	}

	private void eventUp() {
		log_v.bt_log.addActionListener(this);
		log_v.bt_newJoin.addActionListener(this);
		join_v.bt_duple.addActionListener(this);
		join_v.bt_submmit.addActionListener(this);

		serv_v.bt_view.addActionListener(this);
		serv_v.bt_update.addActionListener(this);
		serv_v.bt_delete.addActionListener(this);
		serv_v.bt_search.addActionListener(this);

		upjoin_v.bt_submmit.addActionListener(this);

		join_v.addWindowListener(new WindowAdapter() {
			// ������X��ư ----> ����
			public void windowClosing(WindowEvent e) {
				join_v.setVisible(false);
				log_v.setVisible(true);
			}
		});
		upjoin_v.addWindowListener(new WindowAdapter() {
			// ������X��ư ----> ����
			public void windowClosing(WindowEvent e) {
				upjoin_v.setVisible(false);
				serv_v.setVisible(true);
			}
		});
		serv_v.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				serv_v.bt_delete.setEnabled(true);
				serv_v.bt_update.setEnabled(true);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == log_v.bt_log) {
			Method_DAO dao = new Method_DAO();
			PersonBean person = new PersonBean();

			person.setId(log_v.tf_id.getText());
			person.setPass(new String(log_v.tf_pw.getPassword()));

			if (dao.select(person)) {
				log_v.setVisible(false);
				serv_v.setVisible(true);
			} else {
				System.out.println("����");
			}
		} else if (obj == log_v.bt_newJoin) {
			log_v.setVisible(false);
			join_v.setVisible(true);
		} else if (obj == join_v.bt_duple) { // ---ȸ������â �ߺ�Ȯ�� ��ư Ŭ��
			Method_DAO dao = new Method_DAO();

			if (dao.selectDuple(join_v.tf_id.getText())) {// �˻��ؼ�
															// ����
															// id��
															// �ִٸ�
				join_v.flag = false;
				join_v.showMsg("���� ���� ID �ٽ� ����!!");
			} else {
				join_v.flag = true;
				System.out.println("ID �ߺ� ���� flag : " + join_v.flag);
			}

		} else if (obj == join_v.bt_submmit) {// ȸ������ ����
			Method_DAO dao = new Method_DAO();

			if (join_v.flag) {// �ߺ�Ȯ�� ��ư���� Ȯ�� ��
				if (pw_confirmation()) {
					String phone = join_v.tf_ph1.getText() + "-" + join_v.tf_ph2.getText() + "-"
							+ join_v.tf_ph3.getText();
					PersonBean person = new PersonBean(join_v.tf_id.getText(), new String(join_v.pw.getPassword()),
							join_v.tf_name.getText(), join_v.tf_ss1.getText(), new String(join_v.ssn2.getPassword()), phone,
							join_v.tf_addr.getText(), join_v.combo.getSelectedItem().toString());

					if (dao.insert(person)) {
						Vector<PersonBean> v = dao.selectAll();
						serv_v.displayTable(v);
						System.out.println("����");
						join_v.setVisible(false);
						log_v.setVisible(true);
					}
				}

			} else {
				join_v.showMsg("�ߺ�Ȯ�� ��ư�� �����ּ���");
			}
		} else if (obj == serv_v.bt_view) {
			Method_DAO dao = new Method_DAO();
			Vector<PersonBean> v = dao.selectAll();
			serv_v.displayTable(v);
		} else if (obj == serv_v.bt_update) {
			upjoin_v.setVisible(true);
			serv_v.setVisible(false);
		} else if (obj == upjoin_v.bt_submmit) {
			Method_DAO dao = new Method_DAO();
			PersonBean person = new PersonBean();
			int row = serv_v.table.getSelectedRow();
			String id = serv_v.table.getValueAt(row, 0).toString();
			person.setId(id);
			person.setPass(new String(upjoin_v.pw.getPassword()));
			person.setTel(
					upjoin_v.tf_ph1.getText() + "-" + upjoin_v.tf_ph2.getText() + "-" + upjoin_v.tf_ph2.getText());
			person.setAddr(upjoin_v.tf_addr.getText());
			person.setJob(upjoin_v.combo.getSelectedItem().toString());

			if (dao.update(person)) {
				Vector<PersonBean> v = dao.selectAll();
				serv_v.displayTable(v);
				upjoin_v.setVisible(false);
				serv_v.setVisible(true);
				serv_v.bt_delete.setEnabled(false);
				serv_v.bt_update.setEnabled(false);
			}
		} else if (obj == serv_v.bt_delete) {
			Method_DAO dao = new Method_DAO();
			int row = serv_v.table.getSelectedRow();
			String id = serv_v.table.getValueAt(row, 0).toString();// �ش����� id
																	// ��������
			if (dao.delete(id)) {
				Vector<PersonBean> v = dao.selectAll();
				serv_v.displayTable(v);
			}
		} else if (obj == serv_v.bt_search) {
			Method_DAO dao = new Method_DAO();
			String name = serv_v.showInputMsg();
			Vector<PersonBean> v = dao.selectId(name);
			serv_v.displayTable(v);
		}

	}

	public static void main(String[] args) {
		new Controller();
	}
}
