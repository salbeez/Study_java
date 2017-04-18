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
   
   //임의의 중복되지 않는 세자리 수(0~9)를 표현.
   int com[];//컴퓨터 난수 저장
   int user[];//사용자 입력하는 수를 저장
   Random r;
   int count;
   
   boolean start;//게임시작시 true저장
  
   /*
      <기능추가> - 개선
      
    --------------------- 사용자 입장 --------------------------  
    1. 최초 게임 룰 설명
    2. 게임 시작시 입력Component에 포커스 맞춰주기 (커서의 위치)
         ----> 컴포넌트.requestFocus();
    3. 힌트 : 정답 숫자 중 한개 알려주기
    
    --------------------- 개발자 입장 --------------------------  
    4. JTextArea내에서 쓰기금지.
         ----> ta.setEditable(boolean); //쓰기설정 (TextField와 TextArea설정)
         ----> ta.setEnabled(boolean); //활성,비활성 설정 (전체 컴포넌트설정)
    
    5. 새게임 버튼 클릭하기 전까지 JTextField내에서 쓰기금지. 
    6. 새게임 버튼 클릭 ----> 게임시작초기화
        ---> JTextField 활성화
        ---> JTextArea 설명지우기
        ---> 카운트 초기화 : count=0;  
        ---> 정답,힌트 버튼 활성화
      
    7. 사용자가 입력한 데이터에 대한 검사
        ---> 세자리 숫자만 유효한 데이터!!
        ---> 유효하지 못한 데이터(문자나 문자열길이가 3이 아닌 데이터) 알림.
        ---> 숫자중복체크
    */
   
     
   public BaseBallGame2() {
	  setTitle("숫자야구게임");	 	  
	 
	  com = new int[3]; // com[0]  com[1]  com[2]
	  
	  user = new int[3]; //user[0] user[1] user[2]
	  r = new Random(); 
	  
	  ta = new JTextArea();
	    //new Font(String name글자체,int style,int size)
	    ta.setFont(new Font("굴림체",Font.BOLD,17) );
	    ta.setLineWrap(true);
	    //(너비)범위를 넘어서는 text가 발생할 때 줄 바꿈.(자동 줄바꿈)
	    
	    //쓰기금지
	    ta.setEditable(false);
	    //ta.setEnabled(false);
	                       
	  scroll_ta = new JScrollPane(ta);
	  la = new JLabel("입력:");
	  tf = new JTextField();
	    tf.setEnabled(false); //게임시작전 쓰기금지
	    tf.addMouseListener(new MouseAdapter() {
	    	//오버라이딩
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	          //JOptionPane.showMessageDialog(this, //--->this: 내부클래스 참조
	        		  //"게임시작을 위해 [새게임]버튼을 클릭!!");
	    	  if(!start)// == false  )//게임이 시작되지 않았다면	
	    		showMsg("게임시작을 위해 [새게임]버튼을 클릭!!");
	    	}
		});
	    
	  bt_new = new JButton("새게임");
	  bt_clear = new JButton("지우기");
	  bt_dap = new JButton("정답");
	   bt_dap.setEnabled(false);
	  bt_hint = new JButton("힌트"); 
	   bt_hint.setEnabled(false);
	  bt_exit = new JButton("종료"); 	  
	  
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
      
      ruleDescription();//게임설명 호출
      tf.requestFocus(); //입력컴포넌트(tf)포커스 맞추기
      
      eventUp();
   }//생성자
   
   private void eventUp(){//연결자 등록
	   bt_new.addActionListener(this);
	   bt_dap.addActionListener(this);
	   bt_clear.addActionListener(this);
	   bt_exit.addActionListener(this); 
	   bt_hint.addActionListener(this); 
	   
	   tf.addActionListener(this);
   }//eventUp
   
   
   @Override
   public void actionPerformed(ActionEvent e) {//이벤트 핸들러
   //----> Action(버튼클릭, 엔터입력)발생시 호출
	  Object ob = e.getSource();//이벤트소스 얻기 ----->  Source(bt,tf) 대한 주소
	 	   
	   if(ob == tf){//텍스트필드에서 엔터 입력 했을 때
		 String str = tf.getText();//입력값 얻기 
		 System.out.println("STR="+ str); //"329"
		                    //문자열 인덱스      012
		                    //str.charAt(0) ----> '3'
		
		 if(!str.matches("[0-9]{3}")){//세자리 숫자가 아니라면!!
			 showMsg("세자리 숫자만 입력!!");
			 tf.setText("");
			 return;
		 }
		 
		 for(int i=0; i<user.length; i++){
		    user[i]=str.charAt(i)-48;  
		 }
		 
		 if(duplicateCheck(user)){//중복된 수 발견!!
			 showMsg("같은 수는 입력 불가!!");
			 tf.setText("");
			 return;
		 }
		 
		 int strike=0,ball=0;
		 //비교(컴퓨터가 발생시킨 난수(int[]) - 사용자가 입력한 수(int[]))
		 for(int i=0; i<com.length; i++){    //com배열 인덱스    i= 0 1 2
			 //3번 반복
			for(int j=0; j<user.length; j++ ){//user배열 인덱스 j= 0 1 2
			   //3번 반복
			   //예)com--> 329     user--> 539
				
				if(com[i] == user[j]){//숫자값이 일치했을때
					//일치하는 수를 찾기!! ----> strike 또는 ball 후보!!
				   if(i==j)//숫자일치, 자리위치(번지수)가 일치했을때
					strike++;
				   else//숫자일치, 자리위치가 달랐을때
					ball++;
				}
			}//안쪽for
		 }//바깥쪽for
		 
		 //비교결과를 화면(JTextArea)에 출력!!
		 //346 ▶ 1Strike 1Ball
		count++; 
		 
		if(strike==3) {
			ta.append("♥축하합니다♥ 정답["+str+"]을 맞추셨습니다^^*\n");
			exitGame();		
		}
		else 
		 ta.append(count +" : "+  str+" ▶ "+strike+"Strike "+ball+"Ball\n");
		 
		 tf.setText("");
	   }else if(ob == bt_dap){//정답버튼 클릭 했을 때
		  
		   ta.append("▣ 정답은 ["+com[0]+com[1]+com[2]+"]입니다.\n");	
		   exitGame();
		 
	   }else if(ob == bt_clear){//지우기버튼 클릭 했을 때
		   //텍스트 지우기
		   initText();
	   }else if(ob == bt_new){//새게임버튼 클릭 했을 때
		   
		   initGame();  		   
		   createNum();
		   
	   }else if(ob == bt_hint){
		   
		   JOptionPane.showMessageDialog(this, "힌트 수==> "
		                       +com[ r.nextInt(3) ]);
		   bt_hint.setEnabled(false);//버튼 비활성화!!
		   
		   //com[번지] ---> 번지: 0~2
	   }else if(ob == bt_exit){//종료버튼 클릭 했을 때
		   //프로그램 종료
		   System.exit(0);
	   }
   }//actionPerformed
   

//게임설명
   public void ruleDescription(){
	   ta.setText("\n\n\t<숫자야구게임>");
	   ta.append("\n1. 게임시작을 위해서 새게임버튼을 클릭");
	   ta.append("\n2. 입력에 중복되지않는 세자리수를 입력   후 엔터");
	   ta.append("\n3. 숫자와 자릿수를  맞추면 Strike"+
	              "숫자   만 맞추면 Ball이 추가됩니다.");
	   ta.append("\n4. 정답을 보고 싶으면 정답버튼을 클릭");
	   ta.append("\n5. 기타 문의사항이 있으면 관리자에게     연락바람"+
	               "(070-5039-5815)");
   }//ruleDescription
   
   public void showMsg(String msg){
	  JOptionPane.showMessageDialog(this, msg);
   }//showMsg
   
   public void initText(){//TextField와 TextArea초기화(지우기)
	  ta.setText("");
	  tf.setText("");
	  tf.requestFocus();
   }//initText
   
   public void initGame(){//게임초기화(게임시작)	
	    start=true;
	   
	    tf.setEnabled(true);
	    bt_dap.setEnabled(true);
	    bt_hint.setEnabled(true);
	    
	    count=0;
	    
	    initText();  
   }//initGame
   
   public void exitGame(){//한 게임 종료
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
		 }while(com[1]==com[0]);//중복된 수가 발생한다면
		 
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
	  }//바깥for
	  return false;
   }//duplicateCheck
   
   
   public boolean validCheck(String str){//유효성 검사	  
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



