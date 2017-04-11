package com.kosta.j0411.V;

import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosta.j0411.M.Person;
import com.kosta.j0411.M.PersonDTO;



public class MainView extends JFrame implements Runnable{
	DefaultTableModel dtm;
	public JTable table;
	JScrollPane scroll_table;//��ũ�ѹٰ� �ִ� JTable
	
	public JButton bt_insert, bt_update, bt_delete, bt_exit,
	               bt_search_name, bt_search_all;
	JPanel southp,northp;
	
	JLabel la;//��¥ ���� ���
	Calendar cal;
	
    public MainView() {
       String columnNames[]={"��ȣ","�̸�","����","����"};
       Object data[][]=new Object[0][4];
//    	   {
//    	     {1,"ȫ�浿",13,"�л�"},
//    	     {2,"�����",14,"�л�"},
//    	     {3,"���ֿ�",15,"�л�"},
//    	     {4,"������",16,"ȭ��"}    			   
//    	   };
               //0��4�� --> 0��:addRow�� ������ �ε���
	   dtm = new DefaultTableModel(data, columnNames);	
       table = new JTable(dtm);
       scroll_table = new JScrollPane(table);
       
       bt_insert = new JButton("�Է�");
       bt_update = new JButton("����");
       bt_delete = new JButton("����");
       bt_search_name = new JButton("�̸��˻�");
       bt_search_all = new JButton("��ü�˻�");
       bt_exit = new JButton("����");
       
       southp = new JPanel();
          southp.add(bt_insert);
          southp.add(bt_update);
          southp.add(bt_delete);
          southp.add(bt_search_name);
          southp.add(bt_search_all);
          southp.add(bt_exit);      
       
      
       la = new JLabel();
       //la = new JLabel("2017�� 3�� 20�� 12�� 22�� 30��");
          
       
       northp = new JPanel();
         northp.add(la);   
       
       setTitle("MainView");
       add("North", northp);
       add("Center", scroll_table);
	   add("South", southp);
	   
	   setBounds(300,200,500,300);
	   setVisible(true);   
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	   //setTimeLabel();
	   //Thread t = new Thread(this);
	   //t.start();
	   
	   new Thread(this).start();
	}//������
    
    public void run(){//setTimeLabel(){
      try{	
    	while(true){
    	 Thread.sleep(1000);
    	 cal = Calendar.getInstance();
    	 //getInstance()�޼ҵ尡 ����Ǵ� ������ �ð� ������ ���� ----> cal(��� �ð����� ����)
    	       //cal = new GregorianCalendar();
    	       
    	 int year=cal.get(Calendar.YEAR);
    	 int month=cal.get(Calendar.MONTH)+1;//1��~12�� ---> ����: 0~11
    	 int date=cal.get(Calendar.DATE);//���� DATE(��¥) DAY(����)
    	 int h=cal.get(Calendar.HOUR_OF_DAY);
    	 int m=cal.get(Calendar.MINUTE);
    	 int s=cal.get(Calendar.SECOND);	
    	 
    	 la.setText(year+"�� "+month+"�� "+date+"�� "+h+"�� "+m+"�� "+s+"��");
    	 //System.out.println(year+"�� "+month+"�� "+date+"�� "+h+"�� "+m+"�� "+s+"��");
    	} 
    	
      }catch(InterruptedException e){}
    }//setTimeLabel
    
    
    
   
    public void displayTable(Vector<PersonDTO> v){
        dtm.setRowCount(0);//���� �����͸� ����� 0�� ���� �ٽ� ī��Ʈ(���) 
        for(int i=0; i<v.size(); i++){
            PersonDTO p = v.get(i);
            Object row[]={p.getNo(), p.getName(), p.getAge(), p.getJob()};
            dtm.addRow(row);
        }
     }//displayTable
    
     public void showMsg(String message){
    	 JOptionPane.showMessageDialog(this, message);
     }
}






