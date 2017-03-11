package com.kosta.j0310;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class CheckBoxTest extends Frame {
	
	Checkbox cb1,cb2,cb3,cb4;
	TextArea ta;
	Label label;
	
	CheckboxGroup cbg;

	Panel p1,p2;
	
	public CheckBoxTest() {
//Create
		cbg = new CheckboxGroup();
		
		cb1 = new Checkbox("���",false);
		cb2 = new Checkbox("����",false);
		cb3 = new Checkbox("����",false,cbg);
		cb4 = new Checkbox("����",false,cbg);
		
		ta = new TextArea();
		label = new Label("���� : ");
		
		p1 = new Panel();
		p2 = new Panel();
//		
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		p1.add(cb1);
		p1.add(cb2);
		
		p2.add(label);
		p2.add(cb3);
		p2.add(cb4);
		
		p1.setBackground(Color.YELLOW);
		p2.setBackground(Color.ORANGE);
		
		add("North",p1);
		add("Center",ta);
		add("South",p2);
		
		setTitle("üũ�ڽ� �׽�Ʈ");
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CheckBoxTest();
	}
}
