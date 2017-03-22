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
			
			People  p =new People("홍길동", 12, "도적");
			oos.writeObject(p);
			oos.close();
			System.out.println("객체쓰기 성공");
//			==========================================
			File file = new File("a.ser");//파일 정보 가져오고
			FileInputStream fis = new FileInputStream(file);// 파일을 인풋 스트림으로 바꿔주고
			ObjectInputStream ois = new ObjectInputStream(fis);//오브젝트 형태로 가져온다
			
			Object ob;
			System.out.println(ois.available());
			while( (ob=ois.readObject()) != null){
				People p_read = (People) ob;
				System.out.println("이름 : "+p_read.getName());
				System.out.println("나이 : "+p_read.getAge());
				System.out.println("직업 : "+p_read.getJob());
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
