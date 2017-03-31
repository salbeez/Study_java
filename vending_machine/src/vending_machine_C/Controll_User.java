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

	//뷰등록
	User_View user_View;
	//AdminV1 av1;
	
	//모델등록
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
		eventUp();//연결자
	}
	
	public void eventUp(){//
		//재품메뉴 클릭시 1~8
		user_View.bt_menu1.addActionListener(this);
		user_View.bt_menu2.addActionListener(this);
		user_View.bt_menu3.addActionListener(this);
		user_View.bt_menu4.addActionListener(this);
		user_View.bt_menu5.addActionListener(this);
		user_View.bt_menu6.addActionListener(this);
		user_View.bt_menu7.addActionListener(this);
		user_View.bt_menu8.addActionListener(this);
		
		//돈버튼 클릭시 1~4
		user_View.bt_bill1.addActionListener(this);
		user_View.bt_bill5.addActionListener(this);
		user_View.bt_bill10.addActionListener(this);
		user_View.bt_bill50.addActionListener(this);
		
		//반환버튼 클릭시
		user_View.bt_exch.addActionListener(this);
		
		//관리자 버튼 클릭시
		user_View.bt_admin.addActionListener(this);
		
		//관리자 종료버튼 클릭시
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
		if(ob == user_View.bt_bill1 ){//1000원 버튼을 눌렀을때
			Vector<Boolean> v = m2.onoff(m1.total(0));//1000원
			menu(v);
			
		}else if(ob == user_View.bt_bill5){//5000원 버튼을 눌렀을때
			Vector<Boolean> v = m2.onoff(m1.total(1));//5000원
			menu(v);
			
		}else if(ob == user_View.bt_bill10){//10000원 버튼을 눌렀을때
			Vector<Boolean> v = m2.onoff(m1.total(2));//10000원
			menu(v);
			
		}else if(ob == user_View.bt_bill50){//50000원 버튼을 눌렀을때
			Vector<Boolean> v = m2.onoff(m1.total(3));//50000원
			menu(v);
			
		}else if(ob == user_View.bt_exch){//동전반환 버튼을 눌렀을때
			
			
		}else if(ob == user_View.bt_menu1){//제품 1을 눌렀을때
			if(m2.buy(0, user_View.bt_menu1.getBackground())){
				user_View.bt_menu1.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu2){//제품 2을 눌렀을때
			if(m2.buy(1, user_View.bt_menu2.getBackground())){
				user_View.bt_menu2.setBackground(Color.RED);
			}
		
		}else if(ob == user_View.bt_menu3){//제품 3을 눌렀을때
			if(m2.buy(2, user_View.bt_menu3.getBackground())){
				user_View.bt_menu3.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu4){//제품 4을 눌렀을때
			if(m2.buy(3, user_View.bt_menu4.getBackground())){
				user_View.bt_menu4.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu5){//제품 5을 눌렀을때
			if(m2.buy(4, user_View.bt_menu5.getBackground())){
				user_View.bt_menu5.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu6){//제품 6을 눌렀을때
			if(m2.buy(5, user_View.bt_menu6.getBackground())){
				user_View.bt_menu6.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu7){//제품 7을 눌렀을때
			if(m2.buy(6, user_View.bt_menu7.getBackground())){
				user_View.bt_menu7.setBackground(Color.RED);
			}
			
		}else if(ob == user_View.bt_menu8){//제품 8을 눌렀을때
			if(m2.buy(7, user_View.bt_menu8.getBackground())){//m2.buy메소드 : 버튼의 칼라를 검사 물품을 구매할수 있다면 
				user_View.bt_menu8.setBackground(Color.RED);
			}
			//구매성공 제품을 배출구에 떨어트린다
			
		}else if(ob == user_View.bt_admin){//관리자 버튼을 눌렀을때
			//관리자 뷰를 켜준다
			//av1.setVisible(true);
			user_View.setVisible(false);
			//모델_버튼 비활성화
		}
/*		else if(ob == av1.bt_adminExit){//관리자 버튼을 눌렀을때
			//관리자 뷰를 꺼준다
			//av1.setVisible(false);
			user_View.setVisible(true);
			item_v();
			//모델_버튼 비활성화
		}*/
		
		
		
	}
	
	public static void main(String[] args) {
		Controll_User c = new Controll_User();
		
		System.out.println(c.item_v.get(2).name);
	}

}
