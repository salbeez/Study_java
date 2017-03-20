package com.kosta.j0320;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class MenuChoice extends JFrame implements 	ActionListener{
	
	JRadioButton a,b,c;
	ButtonGroup gr;
	JCheckBox ap,st,ba;
	JComboBox<String> combo;
	JTextArea ta;
	
	JPanel p,p4;
	
	public MenuChoice() {
		a=new JRadioButton("아침",true);
		b=new JRadioButton("점심");
		c=new JRadioButton("저녁");
		gr = new ButtonGroup();
		gr.add(a);
		gr.add(b);
		gr.add(c);
		
		ap=new JCheckBox("사과");
		st=new JCheckBox("딸기");
		ba=new JCheckBox("바나나");
		
		ta = new JTextArea();
		combo = new JComboBox<>();
		
		p = new JPanel();
		p4 = new JPanel();
		
		p.setLayout(new GridLayout(2, 3));
		p.setBackground(Color.GRAY);
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(ap);
		p.add(st);
		p.add(ba);
		

		p4.setLayout(new FlowLayout());
		p4.setBackground(Color.ORANGE);
		combo.addItem("아침");
		combo.addItem("점심");
		combo.addItem("저녁");
		p4.add(combo);
		
		
		
		setLayout(new BorderLayout());
		
		add("North",p);
		add("Center",ta);
		add("South",p4);
		setVisible(true);
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		ap.addActionListener(this);
		st.addActionListener(this);
		ba.addActionListener(this);

		combo.addActionListener(this);
		
		

	}

	public static void main(String[] args) {
		new MenuChoice();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String title=null;
		boolean stg[][] = new boolean[3][3];
		
		if(e.getSource() ==combo){
			Object obj = combo.getSelectedItem();
			if(obj.equals("아침")){
				a.setSelected(true);
			}else if(obj.equals("점심")){
				b.setSelected(true);
			}else
				c.setSelected(true);
		}
		if(a.isSelected()){
			title ="아침";
		}else if(b.isSelected()){
			title ="점심";
		}else{
			title ="저녁";
		}
		combo.setSelectedItem(title);
		ta.setText("\n \n \n \n");
			ta.append("**"+title+"**");
				ta.append("1.사과 : "+ap.isSelected()+"\n");
				ta.append("2.딸기 : "+st.isSelected()+"\n");
				ta.append("3.바나나 : "+ba.isSelected()+"\n");
	}
}
