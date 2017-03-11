package com.kosta.j0310;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;

/**
 * ���̾ƿ����� ������ ��ü�� ǥ���ؾ��Ѵ� ex) new Label();
 * */
public class VisualComponentTest extends Frame{
	
	Panel top_p,p1,p2,p3;
	Label label;
	Scrollbar scbar;
	List list;
	Choice ch;
	
	
	public VisualComponentTest() {
		top_p = new Panel();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		
		label = new Label("����");
		scbar = new Scrollbar(Scrollbar.HORIZONTAL);
		list = new List();
		ch = new Choice();
//		
		p1.setLayout(new BorderLayout());
		p1.add("West",label);
		p1.add("Center",scbar);
		top_p.setLayout(new GridLayout(3, 1));
		top_p.add(new Label());
		top_p.add(p1);
		
		list.add("�߱�", 0);
		list.add("�౸", 1);
		list.add("��", 2);
		list.add("�豸", 3);
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.CYAN);
		p2.add(ch);

		ch.addItem("�λ�");
		ch.addItem("����");
		ch.addItem("����");
		ch.addItem("�뱸");
		p3.setLayout(new FlowLayout());
		p3.add(list);
		
		setLayout(new GridLayout(3, 1));
	
		add(top_p);
		add(p2);
		add(p3);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new VisualComponentTest();
	}
}
