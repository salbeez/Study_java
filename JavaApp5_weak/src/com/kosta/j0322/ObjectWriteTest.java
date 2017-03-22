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
			People  p2 =new People("길라임", 13, "스턴트맨");
			People  p3 =new People("망나뇽", 14, "포켓몬");
			People  p4 =new People("지영준", 27, "환자");
			oos.writeObject(p);
			oos.writeObject(p2);
			oos.writeObject(p3);
			oos.writeObject(p4);
			oos.close();
			System.out.println("객체쓰기 성공");
//			==========================================
			File file = new File("a.ser");//파일 정보 가져오고
			FileInputStream fis = new FileInputStream(file);// 파일에 있는 정보를 가져오고
			ObjectInputStream ois = new ObjectInputStream(fis);//오브젝트 형태로 가져온다
			
			int count=0;
			System.out.println(ois.available());
			while((count=fis.available()) >0){
				System.out.println("\t\tcount : "+count);
				People p_read = (People) ois.readObject();
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
//	http://stackoverflow.com/questions/2626163/java-fileinputstream-objectinputstream-reaches-end-of-file-eof