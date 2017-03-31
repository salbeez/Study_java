package vending_machine_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import vending_machine_V.Vegitable;

public class Method_Model_User implements Runnable {

	Vector<Vegitable> curr_vegit_V;
	Vegitable item;
	Calendar currentCal;

	public Method_Model_User() {
		curr_vegit_V = new Vector<>();
		readCurrntItem();

		Thread a = new Thread(this);
		a.start();
		wirteSellData();
	}

	public Vector<Vegitable> readCurrntItem() {

		File file = new File("nowItem.txt");
		BufferedReader readIn = null;
		String str = null;

		try {
			readIn = new BufferedReader(new FileReader(file));// 이미존재
			while ((str = readIn.readLine()) != null) {

				String strArr[] = str.split(",");
				if (strArr[0].equals("0")) {// 해당 인덱스에 값이 없다면
					strArr[4] = "image/m.jpg";
				}
				item = new Vegitable(strArr[0], Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]), strArr[3],
						strArr[4]);
				curr_vegit_V.add(item);
			}
			for (int i = 0; i < curr_vegit_V.size(); i++) {
				System.out.println(curr_vegit_V.get(i).getName() + "\t" + curr_vegit_V.get(i).getPrice() + "\t"
						+ curr_vegit_V.get(i).getRemains() + "\t" + curr_vegit_V.get(i).getFarmer() + "\t"
						+ curr_vegit_V.get(i).getPath());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				readIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return curr_vegit_V;
	}

	public void wirteSellData() {
		try {
			BufferedWriter wirteFile = new BufferedWriter(new FileWriter("selldata2.txt", true));
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy,MM,dd");
			Date d = new Date(currentCal.getTimeInMillis());// Calendar를 Date형식으로
			String to = transFormat.format(d)+"매출액\n";
			System.out.println(to);
			wirteFile.write(to);
			wirteFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			Calendar cal = new GregorianCalendar();
			currentCal = cal.getInstance();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(currentCal.get(Calendar.YEAR) + " " + currentCal.get(Calendar.MONTH) + " "
					+ currentCal.get(Calendar.DAY_OF_MONTH) + " " + currentCal.get(Calendar.HOUR_OF_DAY) + " "
					+ currentCal.get(Calendar.MINUTE) + " " + currentCal.get(Calendar.SECOND));
			if (currentCal.get(Calendar.HOUR) == 0 && currentCal.get(Calendar.MINUTE) == 0
					&& currentCal.get(Calendar.MILLISECOND) == 0) {
				// 오전12시=24시:00분 00초
				wirteSellData();//
			}
		}
	}

	public static void main(String[] args) {
		new Method_Model_User();
	}

}
