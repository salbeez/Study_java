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
			System.out.println("��ü���� ����");
//			==========================================
			File file = new File("a.ser");//���� ���� ��������
			FileInputStream fis = new FileInputStream(file);// ���Ͽ� �ִ� ������ ��������
			ObjectInputStream ois = new ObjectInputStream(fis);//������Ʈ ���·� �����´�
			
			int count=0;
			System.out.println(ois.available());
			while((count=fis.available()) >0){
				System.out.println("\t\tcount : "+count);
				Revenue_Year p_read = (Revenue_Year) ois.readObject();
				
				System.out.println("�� : "+p_read.getMonth());
				System.out.println("����� : "+p_read.getRevenue());//�����
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