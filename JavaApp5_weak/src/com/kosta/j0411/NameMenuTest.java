package com.kosta.j0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class NameMenuTest {
	
	
   public static boolean num_check(String str){//���������� ��� ���� true
	   
	   //String str="123a";
	   for(int i=0; i<str.length(); i++){//str�� �ε��� ǥ��
	        char ch=str.charAt(i);
	        //if(ch >='0'  &&   ch <= '9'){//ch���ڰ� ���ڶ��
	        //if(ch < '0'  ||   ch > '9'){//ch���ڰ� ���ڰ� �ƴ϶��
	        if( !(ch >='0'  &&   ch <= '9') ){//ch���ڰ� ���ڰ� �ƴ϶��
	        	return false;//���� �ƴ� ���� �߰�!!
	        }
	   }//for  
	   if(str.length()==0) return false;
	   return true;
   }//num_check	
	
	
	
   public static void main(String[] args) throws IOException {
	 
	 //��ȣ�Է�, �̸��Է�
	 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 NameMenu menu = new NameMenu();
	 
	 int num;
	 do{
	   System.out.println("<�̸��޴�>");
	   System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����"); 
	   System.out.print("��ȣ�Է�==> ");
	   String str = in.readLine(); 
	   
	   if(num_check(str)){//==true){	   
	     num= Integer.parseInt(str);//"1" "2" "3"  "4"  "5"
	   }else{
		 num=0;
		 System.out.println("#��ȣ�� �Է��ϼ���!!");
	   }
	   
	   System.out.println();
	   switch(num){
	     case 1: System.out.print("�̸��Է�: ");
	             String addName = in.readLine().trim();
	            	
	             if(menu.insert(addName)){
	            	 System.out.println("#�Է¼���!!");
	             }else{
	            	 System.out.println("#�Է½���!!");
	             }
	            
	    	     break;
	    	     
	     case 2: Vector<String> v = menu.select();
	              System.out.println("#�̸����");
	              for(int i=0; i<v.size(); i++){
	            	  System.out.println(" "+v.get(i));
	              }
	    	     break;
	    	     
	     case 3: 
	    	   System.out.print("�������̸��Է�: ");
	    	      String oldName = in.readLine();//�����̸�
	    	   System.out.print("�������̸��Է�: ");	    	   
	    	      String newName = in.readLine();//�����̸�
	    	 
	    	      if(menu.update(oldName, newName)){//==true){
	    	    	  System.out.println("#��������!!");
	    	      }else{
	    	         System.out.println("#�������� �ʴ� �̸��Դϴ�!!"); 
	    	      }
	    	      
	    	     break;
	     case 4:
	    	   System.out.print("�������̸��Է�: ");
	    	      String delName = in.readLine();
	    	   if(menu.delete(delName)){
	    		   System.out.println("#��������!!");
	    	   }else{
	    	      System.out.println("#�������� �ʴ� �̸��Դϴ�!!"); 
	    	   }
	   }
	     
	   System.out.println();
	  }while( num != 5 );
	 
	  System.out.println("-- END --");
	   
   }//main
}
