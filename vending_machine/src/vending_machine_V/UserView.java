package vending_machine_V;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserView extends JFrame {
     JButton bt_menu1,bt_menu2,bt_menu3,bt_menu4,bt_menu5,bt_menu6,bt_menu7,bt_menu8,
             bt_bill1,bt_bill5,bt_bill10,bt_bill50,
             bt_exch,bt_admin,bt_out;
     JTextField tf_balance;
     JTextArea ta_info;

     JPanel p_all,p_la1,p_la2,p_bt1,p_bt2,p_bill,p_exch;

     JLabel la_product, la_inform,la_bill,la_bar1,la_bar2, la_out,
            la1,la2,la3,la4,la5,la6,la7,la8;
     ImageIcon icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon_exch,icon_admin,
               icon_out;


    public UserView(){
        bt_menu1 = new JButton("제품1");
          bt_menu1.setBackground(Color.red);
        bt_menu2 = new JButton("제품2");
          bt_menu2.setBackground(Color.red);
        bt_menu3 = new JButton("제품3");
          bt_menu3.setBackground(Color.red);
        bt_menu4 = new JButton("제품4");
          bt_menu4.setBackground(Color.red);
        bt_menu5 = new JButton("제품5");
          bt_menu5.setBackground(Color.red);
        bt_menu6 = new JButton("제품6");
          bt_menu6.setBackground(Color.red);
        bt_menu7 = new JButton("제품7");
          bt_menu7.setBackground(Color.red);
        bt_menu8 = new JButton("제품8");
          bt_menu8.setBackground(Color.red);

        bt_bill1 = new JButton("1,000");
        bt_bill5 = new JButton("5,000");
        bt_bill10 = new JButton("10,000");
        bt_bill50 = new JButton("50,000");

        bt_exch = new JButton("잔돈");
          bt_exch.setBounds(305,575,80,80);
          
        bt_admin = new JButton("#");
          bt_admin.setBounds(5,615,40,40);
          
       bt_out = new JButton();
        bt_out.setBounds(420, 450, 140, 30);

        icon1 = new ImageIcon("C:\\Users\\kosta\\Desktop\\001.jpg");
        icon2 = new ImageIcon();
        icon3 = new ImageIcon();
        icon4 = new ImageIcon();
        icon5 = new ImageIcon();
        icon6 = new ImageIcon();
        icon7 = new ImageIcon();
        icon8 = new ImageIcon();
        icon_out = new ImageIcon();
        

        la1 = new JLabel(icon1);
        la2 = new JLabel(icon2);
        la3 = new JLabel(icon3);
        la4 = new JLabel(icon4);
        la5 = new JLabel(icon5);
        la6 = new JLabel(icon6);
        la7 = new JLabel(icon7);
        la8 = new JLabel(icon8);
        
        la_out = new JLabel(icon_out);
         la_out.setBounds(420,325,140,110);

        la_bar1 = new JLabel("신선한 과일,채소를 간편하게^^!");
         //la_bar1.setBounds(180,310,400,15);
        la_bar2 = new JLabel("제품이 나왔습니다.감사합니다^^!");
            la_bar2.setBounds(180,505,400,15);


        tf_balance = new JTextField();
         tf_balance.setBounds(280,530,130,40);

        ta_info = new JTextArea();
         ta_info.setBounds(60,325,340,170);
         ta_info.setText("\n\t<농산물자판기>");
         ta_info.append("\n 매일 새롭게 입고되는 신선한 농산물");
	     ta_info.append("\n 원하시는 상품을 누르면 상품에 대한 정보가 나옵니다.");
	     ta_info.append("\n 지폐 투입시 상품선택버튼으로 변경됩니다.");
	     ta_info.append("\n 문의처 : 02-1234-5678"); 
         		
       

        p_bill = new JPanel();
        p_bill.setLayout(new GridLayout(4,1));
          p_bill.add(bt_bill1);
          p_bill.add(bt_bill5);
          p_bill.add(bt_bill10);
          p_bill.add(bt_bill50);
        p_bill.setBounds(180,530,80,100);

        p_la1=new JPanel();
         p_la1.setLayout(new GridLayout(1, 4));
         p_la1.setBounds(10, 30, 560, 110);
         p_la1.add(la1);
         p_la1.add(la2);
         p_la1.add(la3);
         p_la1.add(la4);


        p_la2=new JPanel();
         p_la2.setLayout(new GridLayout(1, 4));
         p_la2.setBounds(10, 160, 560, 110);
         p_la2.add(la5);
         p_la2.add(la6);
         p_la2.add(la7);
         p_la2.add(la8);


        p_bt1=new JPanel();
         p_bt1.setLayout(new GridLayout(1, 4));
         p_bt1.setBounds(10, 140, 560, 30);
         p_bt1.add(bt_menu1);
         p_bt1.add(bt_menu2);
         p_bt1.add(bt_menu3);
         p_bt1.add(bt_menu4);


        p_bt2=new JPanel();
         p_bt2.setLayout(new GridLayout(1, 4));
         p_bt2.setBounds(10, 270, 560, 30);
         p_bt2.add(bt_menu5);
         p_bt2.add(bt_menu6);
         p_bt2.add(bt_menu7);
         p_bt2.add(bt_menu8);

         

        p_all = new JPanel();
          p_all.setLayout(null);
          p_all.setBackground(Color.orange);
          p_all.add(p_la1);
          p_all.add(p_bt1);
          p_all.add(p_la2);
          p_all.add(p_bt2);
          p_all.add(la_bar1);
          p_all.add(ta_info);
          p_all.add(la_bar2);
          p_all.add(p_bill);
          p_all.add(tf_balance);
          p_all.add(bt_exch);
          p_all.add(bt_admin);
          p_all.add(la_out);
          p_all.add(bt_out);


         add(p_all);
        setBounds(300,200,600,700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
public static void main(String[] args) {
    new UserView();
}
}
