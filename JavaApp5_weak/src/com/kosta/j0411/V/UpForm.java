package com.kosta.j0411.V;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpForm extends JFrame{
   JLabel la_no, la_name,la_age,la_job;
   public JTextField tf_no, tf_name,tf_age,tf_job;
   public JButton bt_submit, bt_reset;
   
   
   public UpForm() {
	 setTitle("수정폼");  
	   
     la_no = new JLabel("번호");
     la_name = new JLabel("이름");
     la_age = new JLabel("나이");
     la_job = new JLabel("직업");
     
     tf_no = new JTextField();
       tf_no.setEditable(false);
     tf_name = new JTextField();
     tf_age = new JTextField();
     tf_job = new JTextField();
     
     bt_submit = new JButton("수정");
     bt_reset = new JButton("취소");
     
     la_no.setBounds(30, 30, 30, 30);
     la_name.setBounds(30, 80, 30, 30);
     la_age.setBounds(30, 130, 30, 30);
     la_job.setBounds(30, 180, 30, 30);
     
     tf_no.setBounds(70, 30, 80, 30);
     tf_name.setBounds(70, 80, 80, 30);
     tf_age.setBounds(70, 130, 80, 30);
     tf_job.setBounds(70, 180, 80, 30);
     
     bt_submit.setBounds(30, 230, 60, 30);
     bt_reset.setBounds(100, 230, 60, 30);
     
     setLayout(null);
     add(la_no);
     add(la_name);
     add(la_age);
     add(la_job);
     add(tf_no);
     add(tf_name);
     add(tf_age);
     add(tf_job);
     add(bt_submit);
     add(bt_reset);
     
     setBounds(600,200,210,330);
     //setVisible(true);     
    
   }//생성자
   public void initText(){
	  tf_name.setText("");
	  tf_age.setText("");
	  tf_job.setText("");
	  tf_name.requestFocus();
   }
}//InputForm





