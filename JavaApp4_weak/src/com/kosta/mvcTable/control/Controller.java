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
//<컨트롤러의 역할> : 프로그램 전체적인 흐름제어
//	1. 사용자의 요청(요구) 사항 분석 [버튼 1을 클릭했는지 , 버튼2를 클릭했는지 ...]  obj==bt or bt2
//2. 사용자의 입력한 데이터를 얻어오는거 [] 판단.... 여기에 choice를 놔도 될듯...
//3. 모델 클래스 객체 생성
//	=> 메소드 호출0
//	=> 결과값을 저장
//4. 이동할 페이지(Frame)를 선택(페이지 이동 제어)
//5. 유효성 검사[추가 옵션] ex) 사용자가 입력한 데이터가 올바른 값인지 뷰단에서도 할수 있음
//6. 인증 or 보안
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
		
		input_v.b_input.addActionListener(this);// 입력창 ->입력 선택
		update_v.b_input.addActionListener(this);// 수정창 ->수정 선택			
		
		main_v.bt_update.addActionListener(this);
		main_v.bt_del.addActionListener(this);//삭제
		main_v.bt_exit.addActionListener(this);//종료
		
		input_v.addWindowListener(new WindowAdapter() {
			//입력창 x버튼-->메인
			public void windowClosing(WindowEvent e) {
				input_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
		update_v.addWindowListener(new WindowAdapter() {
			//입력창 x버튼-->메인
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

		if(name.equals("") && age.equals("") && job.equals("")){//셋중에 하나라도 안썼다면
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
		if(obj == main_v.bt_input){//메인- 입력
			main_v.setVisible(false);
			input_v.setVisible(true);
		}else if(obj == main_v.bt_update){//메인 = 수정
			main_v.setVisible(false);
			update_v.setVisible(true);
			
		}else if(obj ==input_v.b_input){ //입력--> 전송
			String name = input_v.t_name.getText();
			String age = input_v.t_age.getText();
			String job = input_v.t_job.getText();
			
			if(validity(name,age,job)){
				model.input(new Person(count,name, age, job));
				count++;
			}

			display();//출력
			
			main_v.setVisible(true);
			input_v.setVisible(false);
			//초기화
			input_v.t_name.setText("");
			input_v.t_age.setText("");
			input_v.t_job.setText("");
		}else if(obj ==update_v.b_input){ //수정창 --> 전송
			String name = update_v.t_name.getText();
			String age = update_v.t_age.getText();
			String job = update_v.t_job.getText();
			
			int index = main_v.table.getSelectedRow();
			System.out.println(index);
				
			if(validity(name,age,job)){
					model.modify(index, new Person(index++,name, age, job));
			}
				
				display();//출력
				main_v.setVisible(true);
				update_v.setVisible(false);
			
				//초기화
				update_v.t_name.setText("");
				update_v.t_age.setText("");
				update_v.t_job.setText("");

			
		}else if(obj == main_v.bt_del){
			int index = main_v.table.getSelectedRow();
			model.delete(index);
			display();//출력
		}else if(obj == main_v.bt_exit){// 종료
			//
		}
	}
}
