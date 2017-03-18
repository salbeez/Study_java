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

//<컨트롤러의 역할> : 프로그램 전체적인 흐름제어
//	1. 사용자의 요청(요구) 사항 분석 [버튼 1을 클릭했는지 , 버튼2를 클릭했는지 ...]  obj==bt or bt2
//2. 사용자의 입력한 데이터를 얻어오는거 [] 판단.... 여기에 choice를 놔도 될듯...
//3. 모델 클래스 객체 생성
//	=> 메소드 호출0
//	=> 결과값을 저장
//4. 이동할 페이지(Frame)를 선택(페이지 이동 제어)
//5. 유효성 검사[추가 옵션] ex) 사용자가 입력한 데이터가 올바른 값인지 뷰단에서도 할수 있음
//6. 인증 or 보안
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
		main_v.bt_del.setEnabled(false);
	}

	private void eventUp() {
		// TODO Auto-generated method stub
		main_v.bt_input.addActionListener(this);
		main_v.bt_update.addActionListener(this);
		main_v.bt_del.addActionListener(this);// 삭제
		main_v.bt_exit.addActionListener(this);// 종료
		main_v.bt_selectName.addActionListener(this);
		main_v.bt_selectPersons.addActionListener(this);

		input_v.b_input.addActionListener(this);// 입력창 ->입력 선택
		update_v.b_input.addActionListener(this);// 수정창 ->수정 선택
		selection_v.bt_Search_Submit.addActionListener(this);//검색창 -> 검색 선택
		

		input_v.addWindowListener(new WindowAdapter() {
			// 입력창 x버튼-->메인
			public void windowClosing(WindowEvent e) {
				input_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
		
		update_v.addWindowListener(new WindowAdapter() {
			// 입력창 x버튼-->메인
			public void windowClosing(WindowEvent e) {
				update_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
		selection_v.addWindowListener(new WindowAdapter() {
			// 검색창 x버튼-->메인
			public void windowClosing(WindowEvent e) {
				selection_v.setVisible(false);
				main_v.setVisible(true);
			}
		});
		// 테이블을 클릭했을 때 수정버튼 활성화
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

	public void display(Vector<Person> whatperson) {//부분검색이된 person이냐 아니면 전체적인 person인가..
		Vector<Person> v = whatperson;
		main_v.model.setRowCount(0);
		for (int i = 0; i < v.size(); i++) {
			Person p = v.get(i);
			Object row[] = { p.getNo(), p.getName(), p.getAge(), p.getJob() };
			main_v.model.addRow(row);
		}
	}

	private boolean validity(String name, String age, String job) {

		if (name.equals("") || age.equals("") || job.equals("")) {// 셋중에 하나라도														// 안썼다면
			return false;
			
		} else if (!age.matches("[0-9]+")) {// 나이 입력 창에 문자를 썼다면
			if (input_v.isVisible()) {
				JOptionPane.showMessageDialog(input_v, "나이는 숫자로 써주세요");
			} else {
				JOptionPane.showMessageDialog(update_v, "나이는 숫자로 써주세요");
			}
			return false;
		} else if (name.matches("[0-9]+") || job.matches("[0-9]+")) {// 문자입력창에 숫자를 썼다면
			if (input_v.isVisible()) {
				JOptionPane.showMessageDialog(input_v, "이름과 직업은 문자로 써주세요");
			} else {
				JOptionPane.showMessageDialog(update_v, "이름과 직업은 문자로 써주세요");
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
		if (obj == main_v.bt_input) {// 메인 -> 입력창
			main_v.setVisible(false);
			input_v.setVisible(true);
		} else if (obj == main_v.bt_update) {// 메인 => 수정창
			main_v.setVisible(false);
			update_v.setVisible(true);

		} else if(obj == main_v.bt_selectName){ //메인 -> 검색창
			main_v.setVisible(false);
			selection_v.setVisible(true);
		} else if(obj == main_v.bt_selectPersons){ //전체검색
			if(main_v.table.getRowCount()!=0){//테이블 목록이 전부 비워져 있지 않다면
				display(model.getPersons());//전체 출력
			}else{//비워져 있다면
				JOptionPane.showMessageDialog(main_v, "테이블 목록이 전부 비워져 있습니다");
			}
			
		} else if (obj == input_v.b_input) { // 입력--> 전송
			String name = input_v.t_name.getText();
			String age = input_v.t_age.getText();
			String job = input_v.t_job.getText();

			if (validity(name, age, job)) {
				model.input(new Person(++count, name, age, job));
				main_v.bt_del.setEnabled(true);
			}

			display(model.getPersons());// 출력

			main_v.setVisible(true);
			input_v.setVisible(false);
			// 초기화
			input_v.t_name.setText("");
			input_v.t_age.setText("");
			input_v.t_job.setText("");
		} else if (obj == update_v.b_input) { // 수정창 --> 전송
			String name = update_v.t_name.getText();
			String age = update_v.t_age.getText();
			String job = update_v.t_job.getText();

			int index = main_v.table.getSelectedRow();
			System.out.println(index);

			if (validity(name, age, job)) {// 하나라도 비워져 있지 않다면 true

				model.modify(index, new Person(++index, name, age, job));
			}

			display(model.getPersons());// 출력
			main_v.setVisible(true);
			update_v.setVisible(false);

			// 초기화
			update_v.t_name.setText("");
			update_v.t_age.setText("");
			update_v.t_job.setText("");
			main_v.bt_update.setEnabled(false);

		} else if (obj == main_v.bt_del) {
			if (count != 0) {// 데이터가 존재하고
				String str = JOptionPane.showInputDialog("삭제할 인덱스[No]를 선택해 주세요");
				
				//삭제할 인덱스로 빈칸이 아니고 && 숫자로 쓸경우
				if(!str.equals("") && str.matches("[0-9]+")){
					int index = Integer.parseInt(str);
					model.delete(--index);					
				}
			}
			display(model.getPersons());// 출력
			// int index = main_v.table.getSelectedRow();//마우스로 클릭한놈의 인덱스
			// model.delete(index);

		}
		else if(obj == selection_v.bt_Search_Submit){
			int section = selection_v.combo_Search.getSelectedIndex();//콤보 박스에서 선택한 인덱스

			if(selection_v.tf_Search.getText().length()>0){//TextF에 문자열을 썼다면
				Vector<Person> selectpersons= model.section_Search(section,selection_v.tf_Search.getText());
				display(selectpersons);				
			}else{
				JOptionPane.showMessageDialog(selection_v, "아무 문자열도 쓰지 않았습니다");
			}
			selection_v.tf_Search.setText("");
			main_v.setVisible(true);
			selection_v.setVisible(false);
		}
		else if (obj == main_v.bt_exit) {// 종료
			//
		}
	}
}
