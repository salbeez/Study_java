package example_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

import vending_machine_V.Vegitable;

public class ObjectWriteTest {

	public static void main(String[] args) {
		try {
			/*FileOutputStream fos = new FileOutputStream("framItems.ser");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			Date from = new Date();
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			for (int i = 0; i < 16; i++) {
				/*System.out.println("==");
				from.setDate(i);
				String strCal = transFormat.format(from);
				
				System.out.print("ä�� �̸� :");
				String name = br.readLine();
				
				System.out.print("���� :");
				int price = Integer.parseInt(br.readLine());
				
				System.out.print("����� :");
				int remains = Integer.parseInt(br.readLine());
				
				System.out.print("������ :");
				String pro = br.readLine();
				
				System.out.print("�̹��� ��� :");
				String path = br.readLine();
				
				String name = br.readLine();
				String asd[] = name.split(",");
				Vegitable p = new Vegitable(asd[0],Integer.parseInt(asd[1]),Integer.parseInt(asd[2]),asd[3],asd[4]);
				oos.writeObject(p);
			}

			oos.close();
			System.out.println("��ü���� ����");*/
			// ==========================================
			File file = new File("framItems.ser");// ���� ���� ��������
			FileInputStream fis = new FileInputStream(file);// ���Ͽ� �ִ� ������ ��������
			ObjectInputStream ois = new ObjectInputStream(fis);// ������Ʈ ���·� �����´�

			int count = 0;
			System.out.println(ois.available());
			while ((count = fis.available()) > 0) {
				System.out.println("\t\tcount : " + count);
				
				
				Vegitable p_read = (Vegitable) ois.readObject();
				System.out.println("\t\t\t\t"+"���� ���� : "+p_read);
				if(p_read != null){
				System.out.println("ä���̸� :"+p_read.getName()+" ���� : "+p_read.getPrice()+" ����� : "+p_read.getRemains()+" ������ : "+p_read.getFarmer()+" �̹��� ��� :"+p_read.getPath());			
				}
//				System.out.println("�� : " + p_read.getCalendar());
//				System.out.println("����� : " + p_read.getRevenue());// �����
			}

			fis.close();
			ois.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}
}
// http://stackoverflow.com/questions/2626163/java-fileinputstream-objectinputstream-reaches-end-of-file-eof