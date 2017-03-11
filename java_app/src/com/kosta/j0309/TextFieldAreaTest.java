package com.kosta.j0309;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldAreaTest extends Frame{
	
	TextField tf;
	TextField tf2;
	TextArea ta;
	Label label;
	Panel p,p2;
	
	public TextFieldAreaTest() {
		//按眉 积己
		tf = new TextField(10);
		tf2 = new TextField(10);
		ta = new TextArea();
		label = new Label("颇老 捞抚 :");
		p = new Panel();
		p2 = new Panel();
		
		//加己 汲沥( Layout, add)
		setTitle("TextFieldAreaTest");
		
		p.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		p.add(tf);
		p.setBackground(Color.green);
		
		label.setForeground(Color.RED);
		p2.setBackground(Color.YELLOW);
		p2.add(label);
		p2.add(tf2);
		
		add("North",p);
		add("Center",ta);
		add("South",p2);

		//付公府 2俺
		setSize(300,300);
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new TextFieldAreaTest();
	}
}
