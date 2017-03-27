package vending_machine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ObjectWriteTest {

	
	public static void main(String[] args) {
		try {
			FileOutputStream fos= new FileOutputStream("a.ser");
			
			ObjectOutputStream oos = 
					new ObjectOutputStream(fos);
			
			GregorianCalendar gc = new GregorianCalendar();
			Calendar d = gc.getInstance();
			
			Revenue_Year  p =new Revenue_Year(d.get(Calendar.MONTH), 1000);
			Revenue_Year  p2 =new Revenue_Year(d.get(Calendar.MONTH)+1,975);
			Revenue_Year  p3 =new Revenue_Year(d.get(Calendar.MONTH)+2, 987);
			Revenue_Year  p4 =new Revenue_Year(d.get(Calendar.MONTH)+3, 844);
			
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
				Revenue_Year p_read = (Revenue_Year) ois.readObject();
				
				System.out.println("월 : "+p_read.getMonth());
				System.out.println("매출액 : "+p_read.getRevenue());//매출액
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