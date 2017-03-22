package com.kosta.j0322;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {

	
	public static void main(String[] args) {
		try {
			FileOutputStream fos= new FileOutputStream("a.ser");
			
			ObjectOutputStream oos = 
					new ObjectOutputStream(fos);
			
			People  p =new People("ȫ�浿", 12, "����");
			People  p2 =new People("�����", 13, "����Ʈ��");
			People  p3 =new People("������", 14, "���ϸ�");
			People  p4 =new People("������", 27, "ȯ��");
			oos.writeObject(p);
			oos.writeObject(p2);
			oos.writeObject(p3);
			oos.writeObject(p4);
			oos.close();
			System.out.println("��ü���� ����");
//			==========================================
			File file = new File("a.ser");//���� ���� ��������
			FileInputStream fis = new FileInputStream(file);// ���Ͽ� �ִ� ������ ��������
			ObjectInputStream ois = new ObjectInputStream(fis);//������Ʈ ���·� �����´�
			
			int count=0;
			System.out.println(ois.available());
			while((count=fis.available()) >0){
				System.out.println("\t\tcount : "+count);
				People p_read = (People) ois.readObject();
				System.out.println("�̸� : "+p_read.getName());
				System.out.println("���� : "+p_read.getAge());
				System.out.println("���� : "+p_read.getJob());
			}
			
			
			
			
			fis.close();
			ois.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
	}
}
//	http://stackoverflow.com/questions/2626163/java-fileinputstream-objectinputstream-reaches-end-of-file-eof