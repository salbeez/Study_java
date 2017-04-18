package com.kosta.j0315;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame2 extends JFrame  implements ActionListener{
   JTextArea ta;
   JScrollPane scroll_ta;
   JLabel la;
   JTextField tf;
   
   JButton bt_new, bt_clear, bt_dap, bt_exit, bt_hint;
	
   JPanel panel;
   
   //������ �ߺ����� �ʴ� ���ڸ� ��(0~9)�� ǥ��.
   int com[];//��ǻ�� ���� ����
   int user[];//����� �Է��ϴ� ���� ����
   Random r;
   int count;
   
   boolean start;//���ӽ��۽� true����
  
   /*
      <����߰�> - ����
      
    --------------------- ����� ���� --------------------------  
    1. ���� ���� �� ����
    2. ���� ���۽� �Է�Component�� ��Ŀ�� �����ֱ� (Ŀ���� ��ġ)
         ----> ������Ʈ.requestFocus();
    3. ��Ʈ : ���� ���� �� �Ѱ� �˷��ֱ�
    
    --------------------- ������ ���� --------------------------  
    4. JTextArea������ �������.
         ----> ta.setEditable(boolean); //���⼳�� (TextField�� TextArea����)
         ----> ta.setEnabled(boolean); //Ȱ��,��Ȱ�� ���� (��ü ������Ʈ����)
    
    5. ������ ��ư Ŭ���ϱ� ������ JTextField������ �������. 
    6. ������ ��ư Ŭ�� ----> ���ӽ����ʱ�ȭ
        ---> JTextField Ȱ��ȭ
        ---> JTextArea ���������
        ---> ī��Ʈ �ʱ�ȭ : count=0;  
        ---> ����,��Ʈ ��ư Ȱ��ȭ
      
    7. ����ڰ� �Է��� �����Ϳ� ���� �˻�
        ---> ���ڸ� ���ڸ� ��ȿ�� ������!!
        ---> ��ȿ���� ���� ������(���ڳ� ���ڿ����̰� 3�� �ƴ� ������) �˸�.
        ---> �����ߺ�üũ
    */
   
     
   public BaseBallGame2() {
	  setTitle("���ھ߱�����");	 	  
	 
	  com = new int[3]; // com[0]  com[1]  com[2]
	  
	  user = new int[3]; //user[0] user[1] user[2]
	  r = new Random(); 
	  
	  ta = new JTextArea();
	    //new Font(String name����ü,int style,int size)
	    ta.setFont(new Font("����ü",Font.BOLD,17) );
	    ta.setLineWrap(true);
	    //(�ʺ�)������ �Ѿ�� text�� �߻��� �� �� �ٲ�.(�ڵ� �ٹٲ�)
	    
	    //�������
	    ta.setEditable(false);
	    //ta.setEnabled(false);
	                       
	  scroll_ta = new JScrollPane(ta);
	  la = new JLabel("�Է�:");
	  tf = new JTextField();
	    tf.setEnabled(false); //���ӽ����� �������
	    tf.addMouseListener(new MouseAdapter() {
	    	//�������̵�
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	          //JOptionPane.showMessageDialog(this, //--->this: ����Ŭ���� ����
	        		  //"���ӽ����� ���� [������]��ư�� Ŭ��!!");
	    	  if(!start)// == false  )//������ ���۵��� �ʾҴٸ�	
	    		showMsg("���ӽ����� ���� [������]��ư�� Ŭ��!!");
	    	}
		});
	    
	  bt_new = new JButton("������");
	  bt_clear = new JButton("�����");
	  bt_dap = new JButton("����");
	   bt_dap.setEnabled(false);
	  bt_hint = new JButton("��Ʈ"); 
	   bt_hint.setEnabled(false);
	  bt_exit = new JButton("����"); 	  
	  
	  panel = new JPanel();
	  
	  scroll_ta.setBounds(10, 10, 350, 280);
	  la.setBounds(10, 320, 30,30);
	  tf.setBounds(50, 320, 310,30);
                                                     
	  bt_new.setBounds(380, 60, 90,30);
	  bt_clear.setBounds(380, 110, 90,30);
	  bt_dap.setBounds(380, 160, 90,30);
	  bt_hint.setBounds(380, 210, 90,30);
	  bt_exit.setBounds(380, 260, 90,30);
	  
	  panel = new JPanel();
	  panel.setLayout(null);
	  panel.setBackground(Color.orange);
	  panel.add(scroll_ta);	  
	  panel.add(la);	  
	  panel.add(tf);	  
	  panel.add(bt_new);	  
	  panel.add(bt_clear);	  
	  panel.add(bt_dap);	  
	  panel.add(bt_hint);	  
	  panel.add(bt_exit);
	  
      add(panel);
      setBounds(300,200, 500, 400);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE); 
      
      ruleDescription();//���Ӽ��� ȣ��
      tf.requestFocus(); //�Է�������Ʈ(tf)��Ŀ�� ���߱�
      
      eventUp();
   }//������
   
   private void eventUp(){//������ ���
	   bt_new.addActionListener(this);
	   bt_dap.addActionListener(this);
	   bt_clear.addActionListener(this);
	   bt_exit.addActionListener(this); 
	   bt_hint.addActionListener(this); 
	   
	   tf.addActionListener(this);
   }//eventUp
   
   
   @Override
   public void actionPerformed(ActionEvent e) {//�̺�Ʈ �ڵ鷯
   //----> Action(��ưŬ��, �����Է�)�߻��� ȣ��
	  Object ob = e.getSource();//�̺�Ʈ�ҽ� ��� ----->  Source(bt,tf) ���� �ּ�
	 	   
	   if(ob == tf){//�ؽ�Ʈ�ʵ忡�� ���� �Է� ���� ��
		 String str = tf.getText();//�Է°� ��� 
		 System.out.println("STR="+ str); //"329"
		                    //���ڿ� �ε���      012
		                    //str.charAt(0) ----> '3'
		
		 if(!str.matches("[0-9]{3}")){//���ڸ� ���ڰ� �ƴ϶��!!
			 showMsg("���ڸ� ���ڸ� �Է�!!");
			 tf.setText("");
			 return;
		 }
		 
		 for(int i=0; i<user.length; i++){
		    user[i]=str.charAt(i)-48;  
		 }
		 
		 if(duplicateCheck(user)){//�ߺ��� �� �߰�!!
			 showMsg("���� ���� �Է� �Ұ�!!");
			 tf.setText("");
			 return;
		 }
		 
		 int strike=0,ball=0;
		 //��(��ǻ�Ͱ� �߻���Ų ����(int[]) - ����ڰ� �Է��� ��(int[]))
		 for(int i=0; i<com.length; i++){    //com�迭 �ε���    i= 0 1 2
			 //3�� �ݺ�
			for(int j=0; j<user.length; j++ ){//user�迭 �ε��� j= 0 1 2
			   //3�� �ݺ�
			   //��)com--> 329     user--> 539
				
				if(com[i] == user[j]){//���ڰ��� ��ġ������
					//��ġ�ϴ� ���� ã��!! ----> strike �Ǵ� ball �ĺ�!!
				   if(i==j)//������ġ, �ڸ���ġ(������)�� ��ġ������
					strike++;
				   else//������ġ, �ڸ���ġ�� �޶�����
					ball++;
				}
			}//����for
		 }//�ٱ���for
		 
		 //�񱳰���� ȭ��(JTextArea)�� ���!!
		 //346 �� 1Strike 1Ball
		count++; 
		 
		if(strike==3) {
			ta.append("�������մϴ٢� ����["+str+"]�� ���߼̽��ϴ�^^*\n");
			exitGame();		
		}
		else 
		 ta.append(count +" : "+  str+" �� "+strike+"Strike "+ball+"Ball\n");
		 
		 tf.setText("");
	   }else if(ob == bt_dap){//�����ư Ŭ�� ���� ��
		  
		   ta.append("�� ������ ["+com[0]+com[1]+com[2]+"]�Դϴ�.\n");	
		   exitGame();
		 
	   }else if(ob == bt_clear){//������ư Ŭ�� ���� ��
		   //�ؽ�Ʈ �����
		   initText();
	   }else if(ob == bt_new){//�����ӹ�ư Ŭ�� ���� ��
		   
		   initGame();  		   
		   createNum();
		   
	   }else if(ob == bt_hint){
		   
		   JOptionPane.showMessageDialog(this, "��Ʈ ��==> "
		                       +com[ r.nextInt(3) ]);
		   bt_hint.setEnabled(false);//��ư ��Ȱ��ȭ!!
		   
		   //com[����] ---> ����: 0~2
	   }else if(ob == bt_exit){//�����ư Ŭ�� ���� ��
		   //���α׷� ����
		   System.exit(0);
	   }
   }//actionPerformed
   

//���Ӽ���
   public void ruleDescription(){
	   ta.setText("\n\n\t<���ھ߱�����>");
	   ta.append("\n1. ���ӽ����� ���ؼ� �����ӹ�ư�� Ŭ��");
	   ta.append("\n2. �Է¿� �ߺ������ʴ� ���ڸ����� �Է�   �� ����");
	   ta.append("\n3. ���ڿ� �ڸ�����  ���߸� Strike"+
	              "����   �� ���߸� Ball�� �߰��˴ϴ�.");
	   ta.append("\n4. ������ ���� ������ �����ư�� Ŭ��");
	   ta.append("\n5. ��Ÿ ���ǻ����� ������ �����ڿ���     �����ٶ�"+
	               "(070-5039-5815)");
   }//ruleDescription
   
   public void showMsg(String msg){
	  JOptionPane.showMessageDialog(this, msg);
   }//showMsg
   
   public void initText(){//TextField�� TextArea�ʱ�ȭ(�����)
	  ta.setText("");
	  tf.setText("");
	  tf.requestFocus();
   }//initText
   
   public void initGame(){//�����ʱ�ȭ(���ӽ���)	
	    start=true;
	   
	    tf.setEnabled(true);
	    bt_dap.setEnabled(true);
	    bt_hint.setEnabled(true);
	    
	    count=0;
	    
	    initText();  
   }//initGame
   
   public void exitGame(){//�� ���� ����
	    start=false;
	   
	    tf.setEnabled(false);
	    bt_dap.setEnabled(false);
	    bt_hint.setEnabled(false);
	    
	    count=0;	   
   }//exitGame
   
   
   private void createNum() {
	   com[0]= r.nextInt(10);//0~9
		 do{ 
		   com[1]= r.nextInt(10);
		 }while(com[1]==com[0]);//�ߺ��� ���� �߻��Ѵٸ�
		 
		 do{
		   com[2]= r.nextInt(10);
		 }while(com[2]==com[1] || com[2]==com[0]);	 	   
   }//createNum
   
   
   public boolean duplicateCheck(int su[]){
	  for(int i=0; i<su.length-1; i++){
		 for(int j=i+1; j<su.length; j++){
			 //  i=0    i=1    i=2
			 //j=1,2    j=2    j=X
			 if(su[i]==su[j]){
				 return true;
			 }
		 }
	  }//�ٱ�for
	  return false;
   }//duplicateCheck
   
   
   public boolean validCheck(String str){//��ȿ�� �˻�	  
	  if(str.length()!=3)return false;	  
	  for(int i=0; i<str.length(); i++){
		   char ch = str.charAt(i);//'0'~'9'
		   if(ch<'0' || ch>'9') return false;
	  }	  
	  return true;
   }
   
   public static void main(String[] args) {
	   new BaseBallGame2();
   }

}



