package vending_machine;

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

public class ObjectWriteTest {

	public static void main(String[] args) {
		try {
/*			FileOutputStream fos = new FileOutputStream("framItems.ser");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			Date from = new Date();
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			for (int i = 0; i < 16; i++) {
				from.setDate(i);
				String strCal = transFormat.format(from);
				
				System.out.print("채소 이름 :");
				String name = br.readLine();
				
				System.out.print("가격 :");
				int price = Integer.parseInt(br.readLine());
				
				System.out.print("재고량 :");
				int remains = Integer.parseInt(br.readLine());
				
				System.out.print("생산자 :");
				String pro = br.readLine();
				
				
				Vegitable p = new Vegitable(name,price,remains,pro);
				oos.writeObject(p);
			}

			oos.close();
			System.out.println("객체쓰기 성공");*/
			// ==========================================
			File file = new File("nowItem.ser");// 파일 정보 가져오고
			FileInputStream fis = new FileInputStream(file);// 파일에 있는 정보를 가져오고
			ObjectInputStream ois = new ObjectInputStream(fis);// 오브젝트 형태로 가져온다

			int count = 0;
			System.out.println(ois.available());
			while ((count = fis.available()) > 0) {
				System.out.println("\t\tcount : " + count);
				
				
				Vegitable p_read = (Vegitable) ois.readObject();
				System.out.println("\t\t\t\t"+"현재 값이 : "+p_read);
				if(p_read != null){
				System.out.println("채소이름 :"+p_read.getName()+" 가격 : "+p_read.getPrice()+" 재고량 : "+p_read.getRemains()+" 생산자 : "+p_read.getFarmer());			
				}
//				System.out.println("주 : " + p_read.getCalendar());
//				System.out.println("매출액 : " + p_read.getRevenue());// 매출액
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