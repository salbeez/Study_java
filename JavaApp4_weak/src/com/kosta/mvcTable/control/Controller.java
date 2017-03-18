package com.kosta.mvcTable.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kosta.mvcTable.model.Person;
import com.kosta.mvcTable.model.Table_Interface;
import com.kosta.mvcTable.model.Table_Method;
import com.kosta.mvcTable.view.TableInput_View;
import com.kosta.mvcTable.view.TableMain_View;
import com.kosta.mvcTable.view.TableSelection_View;
import com.kosta.mvcTable.view.TableUpdate_View;

//<��Ʈ�ѷ��� ����> : ���α׷� ��ü���� �帧����
//	1. ������� ��û(�䱸) ���� �м� [��ư 1�� Ŭ���ߴ��� , ��ư2�� Ŭ���ߴ��� ...]  obj==bt or bt2
//2. ������� �Է��� �����͸� �����°� [] �Ǵ�.... ���⿡ choice�� ���� �ɵ�...
//3. �� Ŭ���� ��ü ����
//	=> �޼ҵ� ȣ��0
//	=> ������� ����
//4. �̵��� ������(Frame)�� ����(������ �̵� ����)
//5. ��ȿ�� �˻�[�߰� �ɼ�] ex) ����ڰ� �Է��� �����Ͱ� �ùٸ� ������ ��ܿ����� �Ҽ� ����
//6. ���� or ����
public class Controller implements ActionListener {

	TableMain_View main_v;
	TableInput_View input_v;
	TableUpdate_View update_v;
	TableSelection_View selection_v;
	Table_Interface model;
	
	private int count = 0;

	public Controller() {
		// TODO Auto-generated constructor stub
		main_v = new TableMain_View();
		input_v = new TableInput_View();
		update_v = new TableUpdate_View();
		selection_v = new TableSelection_View();
		model = new Table_Method();
		eventUp();

		main_v.bt_update.setEnabled(false);
	}

	private void eventUp() {
		// TODO Auto-generated method stub
		main_v.bt_input.addActionListener(this);
		main_v.bt_update.addActionListener(this);
		main_v.bt_del.addActionListener(this);// ����
		main_v.bt_exit.addActionListener(this);// ����
		main_v.bt_selectName.addActionListener(this);
		main_v.bt_selectPersons.addActionListener(this);

		input_v.b_input.addActionListener(this);// �Է�â ->�Է� ����
		update_v.b_input.addActionListener(this);// ����â ->���� ����
		selection_v.bt_Search_Submit.addActionListener(this);//�˻�â -> �˻� ����
		

		input_v.addWindowListener(new WindowAdapter() {
			// �Է�â x��ư-->����
			public void windowClosing(WindowEvent e) {
				input_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
		
		update_v.addWindowListener(new WindowAdapter() {
			// �Է�â x��ư-->����
			public void windowClosing(WindowEvent e) {
				update_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
		selection_v.addWindowListener(new WindowAdapter() {
			// �˻�â x��ư-->����
			public void windowClosing(WindowEvent e) {
				selection_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
		// ���̺��� Ŭ������ �� ������ư Ȱ��ȭ
		main_v.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				main_v.bt_update.setEnabled(true);
			}
		});

	}

	public static void main(String[] args) {
		new Controller();
	}

	public void display(Vector<Person> whatperson) {//�κа˻��̵� person�̳� �ƴϸ� ��ü���� person�ΰ�..
		Vector<Person> v = whatperson;
		main_v.model.setRowCount(0);
		for (int i = 0; i < v.size(); i++) {
			Person p = v.get(i);
			Object row[] = { p.getNo(), p.getName(), p.getAge(), p.getJob() };
			main_v.model.addRow(row);
		}
	}

	private boolean validity(String name, String age, String job) {

		if (name.equals("") && age.equals("") && job.equals("")) {// ���߿� �ϳ���
																	// �Ƚ�ٸ�
			return false;
		} else if (!age.matches("[0-9]+")) {// ���� �Է� â�� ���ڸ� ��ٸ�
			if (input_v.isVisible()) {
				JOptionPane.showMessageDialog(input_v, "���̴� ���ڷ� ���ּ���");
			} else {
				JOptionPane.showMessageDialog(update_v, "���̴� ���ڷ� ���ּ���");
			}
			return false;
		} else if (name.matches("[0-9]+") || job.matches("[0-9]+")) {// �����Է�â�� ���ڸ� ��ٸ�
			if (input_v.isVisible()) {
				JOptionPane.showMessageDialog(input_v, "�̸��� ������ ���ڷ� ���ּ���");
			} else {
				JOptionPane.showMessageDialog(update_v, "�̸��� ������ ���ڷ� ���ּ���");
			}
			return false;
		}
		System.out.println(true);
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == main_v.bt_input) {// ���� -> �Է�â
			main_v.setVisible(false);
			input_v.setVisible(true);
		} else if (obj == main_v.bt_update) {// ���� => ����â
			main_v.setVisible(false);
			update_v.setVisible(true);

		} else if(obj == main_v.bt_selectName){ //���� -> �˻�â
			main_v.setVisible(false);
			selection_v.setVisible(true);
		} else if(obj == main_v.bt_selectPersons){ //��ü�˻�
			if(main_v.table.getRowCount()!=0){//���̺� ����� ���� ����� ���� �ʴٸ�
				display(model.getPersons());//��ü ���
			}else{//����� �ִٸ�
				JOptionPane.showMessageDialog(main_v, "���̺� ����� ���� ����� �ֽ��ϴ�");
			}
			
		} else if (obj == input_v.b_input) { // �Է�--> ����
			String name = input_v.t_name.getText();
			String age = input_v.t_age.getText();
			String job = input_v.t_job.getText();

			if (validity(name, age, job)) {
				model.input(new Person(++count, name, age, job));
			}

			display(model.getPersons());// ���

			main_v.setVisible(true);
			input_v.setVisible(false);
			// �ʱ�ȭ
			input_v.t_name.setText("");
			input_v.t_age.setText("");
			input_v.t_job.setText("");
		} else if (obj == update_v.b_input) { // ����â --> ����
			String name = update_v.t_name.getText();
			String age = update_v.t_age.getText();
			String job = update_v.t_job.getText();

			int index = main_v.table.getSelectedRow();
			System.out.println(index);

			if (validity(name, age, job)) {// �ϳ��� ����� ���� �ʴٸ� true

				model.modify(index, new Person(++index, name, age, job));
			}

			display(model.getPersons());// ���
			main_v.setVisible(true);
			update_v.setVisible(false);

			// �ʱ�ȭ
			update_v.t_name.setText("");
			update_v.t_age.setText("");
			update_v.t_job.setText("");
			main_v.bt_update.setEnabled(false);

		} else if (obj == main_v.bt_del) {
			if (count != 0) {// �����Ͱ� �����ϰ�
				String str = JOptionPane.showInputDialog("������ �ε���[No]�� ������ �ּ���");
				
				//������ �ε����� ��ĭ�� �ƴϰ� && ���ڷ� �����
				if(!str.equals("") && str.matches("[0-9]+")){
					int index = Integer.parseInt(str);
					model.delete(--index);					
				}
			}
			display(model.getPersons());// ���
			// int index = main_v.table.getSelectedRow();//���콺�� Ŭ���ѳ��� �ε���
			// model.delete(index);

		}
		else if(obj == selection_v.bt_Search_Submit){
			int section = selection_v.combo_Search.getSelectedIndex();//�޺� �ڽ����� ������ �ε���
			
			Vector<Person> selectpersons= model.section_Search(section,selection_v.tf_Search.getText());
			display(selectpersons);
			
			main_v.setVisible(true);
			selection_v.setVisible(false);
		}
		else if (obj == main_v.bt_exit) {// ����
			//
		}
	}
}
