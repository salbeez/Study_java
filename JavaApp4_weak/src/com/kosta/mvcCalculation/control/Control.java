package com.kosta.mvcCalculation.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kosta.mvcCalculation.model.Model;
import com.kosta.mvcCalculation.view.View;

/**
 * @author ksota 전체 프로그램 제어 폼을 통해 전달된 요청을 분석해서 알맞은 메소드를 호출.
 */
//  <컨트롤러의 역할> : 프로그램 전체적인 흐름제어
// 	1. 사용자의 요청(요구) 사항 분석 [버튼 1을 클릭했는지 , 버튼2를 클릭했는지 ...]  obj==bt or bt2
//	2. 사용자의 입력한 데이터를 얻어오는거 [] 판단.... 여기에 choice를 놔도 될듯...
//	3. 모델 클래스 객체 생성
//		=> 메소드 호출0
//		=> 결과값을 저장
//	4. 이동할 페이지(Frame)를 선택(페이지 이동 제어)
//	5. 유효성 검사[추가 옵션] ex) 사용자가 입력한 데이터가 올바른 값인지 뷰단에서도 할수 있음
//	6. 인증 or 보안
public class Control implements ActionListener{
	View view;
	
	public Control() {
		view = new View();
		eventUp();
	}


	private void eventUp(){//연결자
		view.bt_calc.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//요구 분석
		Object obj =  e.getSource();		
		if(obj ==view.bt_calc){
			int su1 = Integer.parseInt(view.tf_su1.getText()); //2.
			int su2 =Integer.parseInt(view.tf_su2.getText());
			String oper = (String)view.combo_oper.getSelectedItem();
			
			Model model = new Model(su1, su2, oper);//3
				String result = model.getResult();//3-1, 3-2
				
			view.la_result.setText(result);	//4
				
		}
	}
	
	public static void main(String[] args) {
		new Control();
	}
}
