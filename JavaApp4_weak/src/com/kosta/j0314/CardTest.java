package com.kosta.j0314;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardTest extends Frame implements ActionListener{
	Button bt1,bt2,bt3;
	Panel p1,p2,p3;
	Panel yellowp,bluep,redp;
	CardLayout card;

	public CardTest() {
		bt1 = new Button("다음");
		bt2 = new Button("다음");
		bt3 = new Button("다음");
		
		yellowp = new Panel();
		yellowp.setBackground(Color.YELLOW);
		bluep = new Panel();
		bluep.setBackground(Color.BLUE);
		redp = new Panel();
		redp.setBackground(Color.RED);
//		---
		p1 = new Panel();
		p1.setLayout(new BorderLayout(0,10));
		p1.add("Center", yellowp);
		p1.add("South", bt1);
		
		p2 = new Panel();
		p2.setLayout(new BorderLayout(0,10));
		p2.add("Center", bluep);
		p2.add("South", bt2);
		
		p3 = new Panel();
		p3.setLayout(new BorderLayout(0,10));
		p3.add("Center", redp);
		p3.add("South", bt3);
		
//		
		card = new CardLayout();
		setTitle("카드 레이아웃");
		setLayout(card);//같은 위치의 컴포넌트 정렬
		
		add("a1",p1);
		add("a2",p2);
		add("a3",p3);

//		
		setVisible(true);
		setBounds(300, 200,200,300);//x,y,width,height
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});//== extends WindowAdapter
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
	}

	public static void main(String[] args) {
		new CardTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Object obj = e.getSource();
		 
		 if(obj ==bt1){
			 card.show(this, "a2");
		 }else if(obj ==bt2){
			 card.show(this, "a3");
		 }else{
			 card.show(this, "a1");
		 }
	}
}
