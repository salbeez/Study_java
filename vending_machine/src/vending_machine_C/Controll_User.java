package vending_machine_C;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.kosta.v_machine.model.UserM1;
import com.kosta.v_machine.model.UserM2;

import vending_machine_V.User_View;
import vending_machine_V.Vegitable;


public class Controll_User implements ActionListener{

	//����
	User_View user_View;
	//AdminV1 av1;
	
	//�𵨵��
	UserM1 m1;
	UserM2 m2;
	
	Vector<Vegitable> item_v;
	
	public Controll_User() {
		item_v = new Vector<>();
		
		user_View = new User_View();
		//av1 = new AdminV1();
		
		m1= new UserM1();
		m2= new UserM2();
		
		item_v();
		eventUp();//������
	}
	
	public void eventUp(){//
		//��ǰ�޴� Ŭ���� 1~8
		user_View.bt_menu1.addActionListener(this);
		user_View.bt_menu2.addActionListener(this);
		user_View.bt_menu3.addActionListener(this);
		user_View.bt_menu4.addActionListener(this);
		user_View.bt_menu5.addActionListener(this);
		user_View.bt_menu6.addActionListener(this);
		user_View.bt_menu7.addActionListener(this);
		user_View.bt_menu8.addActionListener(this);
		
		//����ư Ŭ���� 1~4
		user_View.bt_bill1.addActionListener(this);
		user_View.bt_bill5.addActionListener(this);
		user_View.bt_bill10.addActionListener(this);
		user_View.bt_bill50.addActionListener(this);
		
		//��ȯ��ư Ŭ����
		user_View.bt_exch.addActionListener(this);
		
		//������ ��ư Ŭ����
		user_View.bt_admin.addActionListener(this);
		
		//������ �����ư Ŭ����
		//av1.bt_adminExit.addActionListener(this);
		
	}
	
	public void item_v(){
		try {
			BufferedReader in = new BufferedReader(new FileReader("nowItem.txt"));
			for(int i=0; i<8; i++){
				String str[] = in.readLine().split(",");
				item_v.add(new Vegitable(str[0], Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]), str[4]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void menu(Vector<Boolean> v){
		if(v.get(0)){
			user_View.bt_menu1.setBackground(Color.GREEN);
		}else if(v.get(1)){
			user_View.bt_menu2.setBackground(Color.GREEN);
		}else if(v.get(2)){
			user_View.bt_menu3.setBackground(Color.GREEN);
		}else if(v.get(3)){
			user_View.bt_menu4.setBackground(Color.GREEN);
		}else if(v.get(4)){
			user_View.bt_menu5.setBackground(Color.GREEN);
		}else if(v.get(5)){
			user_View.bt_menu6.setBackground(Color.GREEN);
		}else if(v.get(6)){
			user_View.bt_menu7.setBackground(Color.GREEN);
		}else if(v.get(7)){
			user_View.bt_menu8.setBackground(Color.GREEN);
		}
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == user_View.bt_bill1 ){//1000�� ��ư�� ��������
			Vector<Boolean> v = m2.onoff(m1.total(0));//1000��
			menu(v);
			
		}else if(ob == user_View.bt_bill5){//5000�� ��ư�� ��������
			Vector<Boolean> v = m2.onoff(m1.total(1));//5000��
			menu(v);
			
		}else if(ob == user_View.bt_bill10){//10000�� ��ư�� ��������
			Vector<Boolean> v = m2.onoff(m1.total(2));//10000��
			menu(v);
			
		}else if(ob == user_View.bt_bill50){//50000�� ��ư�� ��������
			Vector<Boolean> v = m2.onoff(m1.total(3));//50000��
			menu(v);
			
		}else if(ob == user_View.bt_exch){//������ȯ ��ư�� ��������
			
			
		}else if(ob == user_View.bt_menu1){//��ǰ 1�� ��������
			if(m2.buy(0, user_View.bt_menu1.getBackground())){
				user_View.bt_menu1.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu2){//��ǰ 2�� ��������
			if(m2.buy(1, user_View.bt_menu2.getBackground())){
				user_View.bt_menu2.setBackground(Color.RED);
			}
		
		}else if(ob == user_View.bt_menu3){//��ǰ 3�� ��������
			if(m2.buy(2, user_View.bt_menu3.getBackground())){
				user_View.bt_menu3.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu4){//��ǰ 4�� ��������
			if(m2.buy(3, user_View.bt_menu4.getBackground())){
				user_View.bt_menu4.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu5){//��ǰ 5�� ��������
			if(m2.buy(4, user_View.bt_menu5.getBackground())){
				user_View.bt_menu5.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu6){//��ǰ 6�� ��������
			if(m2.buy(5, user_View.bt_menu6.getBackground())){
				user_View.bt_menu6.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu7){//��ǰ 7�� ��������
			if(m2.buy(6, user_View.bt_menu7.getBackground())){
				user_View.bt_menu7.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu8){//��ǰ 8�� ��������
			if(m2.buy(7, user_View.bt_menu8.getBackground())){//m2.buy�޼ҵ� : ��ư�� Į�� �˻� ��ǰ�� �����Ҽ� �ִٸ� 
				user_View.bt_menu8.setBackground(Color.RED);
			}
			//���ż��� ��ǰ�� ���ⱸ�� ����Ʈ����
			
		}else if(ob == user_View.bt_admin){//������ ��ư�� ��������
			//������ �並 ���ش�
			//av1.setVisible(true);
			user_View.setVisible(false);
			//��_��ư ��Ȱ��ȭ
		}
/*		else if(ob == av1.bt_adminExit){//������ ��ư�� ��������
			//������ �並 ���ش�
			//av1.setVisible(false);
			user_View.setVisible(true);
			item_v();
			//��_��ư ��Ȱ��ȭ
		}*/
		
		
		
	}
	
	public static void main(String[] args) {
		Controll_User c = new Controll_User();
		
		System.out.println(c.item_v.get(2).name);
	}

}
