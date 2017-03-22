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
			oos.writeObject(p);
			oos.close();
			System.out.println("��ü���� ����");
//			==========================================
			File file = new File("a.ser");//���� ���� ��������
			FileInputStream fis = new FileInputStream(file);// ������ ��ǲ ��Ʈ������ �ٲ��ְ�
			ObjectInputStream ois = new ObjectInputStream(fis);//������Ʈ ���·� �����´�
			
			Object ob;
			System.out.println(ois.available());
			while( (ob=ois.readObject()) != null){
				People p_read = (People) ob;
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
