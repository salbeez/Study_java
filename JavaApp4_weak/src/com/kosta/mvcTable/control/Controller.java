package com.kosta.mvcTable.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import com.kosta.mvcTable.model.Person;
import com.kosta.mvcTable.model.Table_Interface;
import com.kosta.mvcTable.model.Table_Method;
import com.kosta.mvcTable.view.TableInput_View;
import com.kosta.mvcTable.view.TableMain_View;
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
public class Controller implements ActionListener{
	
	TableMain_View main_v;
	TableInput_View input_v;
	TableUpdate_View update_v;
	Table_Interface model;
	private int count=1;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		main_v = new TableMain_View();
		input_v =new TableInput_View();
		update_v = new TableUpdate_View();
		model = new Table_Method();
		eventUp();
	}

	private void eventUp() {
		// TODO Auto-generated method stub
		main_v.bt_input.addActionListener(this);
		
		input_v.b_input.addActionListener(this);// �Է�â ->�Է� ����
		update_v.b_input.addActionListener(this);// ����â ->���� ����			
		
		main_v.bt_update.addActionListener(this);
		main_v.bt_del.addActionListener(this);//����
		main_v.bt_exit.addActionListener(this);//����
		
		input_v.addWindowListener(new WindowAdapter() {
			//�Է�â x��ư-->����
			public void windowClosing(WindowEvent e) {
				input_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
		update_v.addWindowListener(new WindowAdapter() {
			//�Է�â x��ư-->����
			public void windowClosing(WindowEvent e) {
				update_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		new Controller();
	}
	public void display(){
		Vector<Person> v = model.getPersons();
		main_v.model.setRowCount(0);
		for(int i=0; i<v.size(); i++){
			Person p = v.get(i);
			Object row[] = {p.getNo(),p.getName(),p.getAge(),p.getJob()};
			main_v.model.addRow(row);
		}
	}
	private boolean validity(String name, String age, String job){

		if(name.equals("") && age.equals("") && job.equals("")){//���߿� �ϳ��� �Ƚ�ٸ�
			System.out.println(false);
			return false;
		}
		System.out.println(true);
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == main_v.bt_input){//����- �Է�
			main_v.setVisible(false);
			input_v.setVisible(true);
		}else if(obj == main_v.bt_update){//���� = ����
			main_v.setVisible(false);
			update_v.setVisible(true);
			
		}else if(obj ==input_v.b_input){ //�Է�--> ����
			String name = input_v.t_name.getText();
			String age = input_v.t_age.getText();
			String job = input_v.t_job.getText();
			
			if(validity(name,age,job)){
				model.input(new Person(count,name, age, job));
				count++;
			}

			display();//���
			
			main_v.setVisible(true);
			input_v.setVisible(false);
			//�ʱ�ȭ
			input_v.t_name.setText("");
			input_v.t_age.setText("");
			input_v.t_job.setText("");
		}else if(obj ==update_v.b_input){ //����â --> ����
			String name = update_v.t_name.getText();
			String age = update_v.t_age.getText();
			String job = update_v.t_job.getText();
			
			int index = main_v.table.getSelectedRow();
			System.out.println(index);
				
			if(validity(name,age,job)){
					model.modify(index, new Person(index++,name, age, job));
			}
				
				display();//���
				main_v.setVisible(true);
				update_v.setVisible(false);
			
				//�ʱ�ȭ
				update_v.t_name.setText("");
				update_v.t_age.setText("");
				update_v.t_job.setText("");

			
		}else if(obj == main_v.bt_del){
			int index = main_v.table.getSelectedRow();
			model.delete(index);
			display();//���
		}else if(obj == main_v.bt_exit){// ����
			//
		}
	}
}
