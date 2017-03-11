package com.kosta.j0310;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ksota Frame은 기본 레이아웃이 BorderLayout
 */

public class EventTest extends Frame implements ActionListener {
	Button bt, bt2;
	int count;

	public EventTest() {
		setTitle("이벤트 테스트");
		bt = new Button("버튼");
		bt2 = new Button("버튼2");

		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		setSize(300, 300);
		setVisible(true);

		bt.addActionListener(this);
		bt2.addActionListener(this);
	}

	public static void main(String[] args) {
		new EventTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//누가 활성화 했는지 확인
//		String e.getComponentAt(); ==>return String
//		▶만약 이벤트 소스가 버튼이라면 Button이라면 버튼의 라벨이 전달

//		e.getSource(); ==>return Object 
//		▶만약 bt를 눌러 이벤트핸들러를 호출했다면 
//				Object obj = bt; 주소값을 복사해서 obj에게 전달 
//		▶결론) e.getSource()는 이벤트 소스의 레퍼런스를 리턴
		
//		String label = e.getActionCommand();
//		if(label.equals("버튼")){ case 1;
		
		Object obj = e.getSource();// case 2; 이게 좀더... 괜찮다고 한다
		if(obj==bt){
		setTitle("안녕");
		bt.setLabel(""+count);
		count++;
		}
		else{
		//프로그램 종료 메소드
		System.exit(0);
		}

	}

}
