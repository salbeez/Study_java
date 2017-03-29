package vending_machine;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.xml.ws.FaultAction;

import org.jfree.data.category.DefaultCategoryDataset;

public class Mothod_Model {
	FileInputStream fis;
	String strFilePath, str[] = new String[2];
	int startIdx, endIdx;

	Vector<String[]> str_V;
	Vector<Vegitable> framItems;// 총 아이템의 정보
	Vector<Vegitable> sellItems;// 판매할 아이템의 정보들

	public Vector<Vegitable> readFarmItems() {
		framItems = new Vector<>();
		File file = new File("framItems.ser");// 파일 정보 가져오고
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);// 오브젝트 형태로 가져온다

			int count = 0;
			System.out.println(ois.available());
			while ((count = fis.available()) > 0) {
				System.out.println("\t\tcount : " + count);
				Vegitable p_read = (Vegitable) ois.readObject();
				framItems.add(p_read);
				System.out.println("채소이름 :" + p_read.getName() + " 가격 : " + p_read.getPrice() + "재고량 : "
						+ p_read.getRemains() + " 생산자 : " + p_read.getFarmer());
			}

			fis.close();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 파일에 있는 정보를 가져오고

		return framItems;
	}

	public String[] exchangeRead() {
		File file = new File("exchange.txt");// 파일 정보 가져오고
		FileInputStream fis;
		String str = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			str = in.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (str == null) {// 만약 아무것도 안쓰여져 있다면
			String s[] = { "0", "0", "0", "0" };
			return s;
		}
		String strArr[] = str.split(",");

		return strArr;
	}

	public void currentSellItems(Vector<Vegitable> sellItems) {
		
		try {
			
			BufferedWriter br = new BufferedWriter(new FileWriter("nowItem.txt"));
			
			for (int j = 0; j < sellItems.size(); j++) {
				Vegitable p = sellItems.get(j);
				String str = p.getName()+","+p.getPrice()+","+p.getRemains()+","+p.getFarmer()+p.getPath()+"\n";
				br.write(str);
				System.out.println(str);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exchangeWirte(String money[]) {// [0]천원,오천원,만원,오만원
		File file = new File("exchange.txt");// 쓸 파일 가져오고
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));

			String str = money[0] + "," + money[1] + "," + money[2] + "," + money[3];
			out.write(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void divisionFile(){
		File file = new File("selldata.txt");
		String month=null;
		String readStr=null;
		int moneyMonth=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			while (  (readStr=br.readLine()) != null) {
				
				String strArr[]=readStr.split(",");
				
				if(month==strArr[1]){//개월 1~31
					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 매출액.....차트용
	public DefaultCategoryDataset getDataSet(int selectFile) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		str_V = new Vector<>();
		// 데이터 입력 ( 값, 범례, 카테고리 )정수실수,String,String
		// 그래프 ,.... 여기다 파일을 입력하면...
		switch (selectFile) {
		case 1:// year
			strFilePath = "months.txt";
			str[0] = "월별";
			str[1] = "월";
			startIdx = 5;
			endIdx = 7;
			break;
		case 2:// year
			strFilePath = "month.txt";
			str[0] = "한달";
			str[1] = "일";
			startIdx = 8;
			endIdx = 10;
			break;
		case 3:// Current 
			strFilePath = "month.txt";
			str[0] = "최근 일주일";
			str[1] = "일";
			startIdx = 8;
			endIdx = 10;
			break;
		default:
			break;
		}

		try {
			File file = new File(strFilePath);// 파일 정보 가져오고
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String readStr=null;

			if (selectFile == 3) {
				while (  (readStr=br.readLine()) != null) {
					String strArr[]=readStr.split(",");
					str_V.add(strArr);
				}

				for (int i = str_V.size() - 7; i < str_V.size(); i++) {
					int 매출량 = Integer.parseInt(str_V.get(i)[3]);
					dataset.addValue(매출량, str[0], str_V.get(i)[2] + str[1]);
				}
			
			} else {
				while (  (readStr=br.readLine()) != null) {

					String strArr[]=readStr.split(",");
					dataset.addValue(Integer.parseInt(strArr[3]), str[0],strArr[2] + str[1]);
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("!!");
			e.printStackTrace();
		} // 파일에 있는 정보를 가져오고

		return dataset;
	}
}
// Study_java/JavaApp5_weak/src/com/kosta/j0322/ObjectWriteTest.java

/*
 * 자바(JAVA) 형 변환(String과 Date) String to Date
 * 
 * String from = "2013-04-08 10:10:10"; SimpleDateFormat transFormat = new
 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date to = transFormat.parse(from);
 * 
 * 
 * Date to String
 * 
 * Date from = new Date(); SimpleDateFormat transFormat = new
 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String to =
 * transFormat.format(from);
 */