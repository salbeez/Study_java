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
	JScrollPane scroll_table;//스크롤바가 있는 JTable
	
	public JButton bt_insert, bt_update, bt_delete, bt_exit,
	               bt_search_name, bt_search_all;
	JPanel southp,northp;
	
	JLabel la;//날짜 정보 출력
	Calendar cal;
	
    public MainView() {
       String columnNames[]={"번호","이름","나이","직업"};
       Object data[][]=new Object[0][4];
//    	   {
//    	     {1,"홍길동",13,"학생"},
//    	     {2,"길라임",14,"학생"},
//    	     {3,"김주원",15,"학생"},
//    	     {4,"김유신",16,"화랑"}    			   
//    	   };
               //0행4열 --> 0행:addRow시 시작할 인덱스
	   dtm = new DefaultTableModel(data, columnNames);	
       table = new JTable(dtm);
       scroll_table = new JScrollPane(table);
       
       bt_insert = new JButton("입력");
       bt_update = new JButton("수정");
       bt_delete = new JButton("삭제");
       bt_search_name = new JButton("이름검색");
       bt_search_all = new JButton("전체검색");
       bt_exit = new JButton("종료");
       
       southp = new JPanel();
          southp.add(bt_insert);
          southp.add(bt_update);
          southp.add(bt_delete);
          southp.add(bt_search_name);
          southp.add(bt_search_all);
          southp.add(bt_exit);      
       
      
       la = new JLabel();
       //la = new JLabel("2017년 3월 20일 12시 22분 30초");
          
       
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
	}//생성자
    
    public void run(){//setTimeLabel(){
      try{	
    	while(true){
    	 Thread.sleep(1000);
    	 cal = Calendar.getInstance();
    	 //getInstance()메소드가 실행되는 순간의 시간 정보를 리턴 ----> cal(모든 시간정보 저장)
    	       //cal = new GregorianCalendar();
    	       
    	 int year=cal.get(Calendar.YEAR);
    	 int month=cal.get(Calendar.MONTH)+1;//1월~12월 ---> 리턴: 0~11
    	 int date=cal.get(Calendar.DATE);//참고 DATE(날짜) DAY(요일)
    	 int h=cal.get(Calendar.HOUR_OF_DAY);
    	 int m=cal.get(Calendar.MINUTE);
    	 int s=cal.get(Calendar.SECOND);	
    	 
    	 la.setText(year+"년 "+month+"월 "+date+"일 "+h+"시 "+m+"분 "+s+"초");
    	 //System.out.println(year+"년 "+month+"월 "+date+"일 "+h+"시 "+m+"분 "+s+"초");
    	} 
    	
      }catch(InterruptedException e){}
    }//setTimeLabel
    
    
    
   
    public void displayTable(Vector<PersonDTO> v){
        dtm.setRowCount(0);//이전 데이터를 지우고 0행 부터 다시 카운트(출력) 
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






