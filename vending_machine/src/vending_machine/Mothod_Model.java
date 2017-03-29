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
	Vector<String[]> allSellMoney;

	Vector<Vegitable> framItems;// �� �������� ����
	Vector<Vegitable> sellItems;// �Ǹ��� �������� ������

	public Vector<Vegitable> readFarmItems() {
		framItems = new Vector<>();
		File file = new File("framItems.ser");// ���� ���� ��������
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);// ������Ʈ ���·� �����´�

			int count = 0;
			System.out.println(ois.available());
			while ((count = fis.available()) > 0) {
				System.out.println("\t\tcount : " + count);
				Vegitable p_read = (Vegitable) ois.readObject();
				framItems.add(p_read);
				System.out.println("ä���̸� :" + p_read.getName() + " ���� : " + p_read.getPrice() + "��� : "
						+ p_read.getRemains() + " ������ : " + p_read.getFarmer());
			}

			fis.close();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ���Ͽ� �ִ� ������ ��������

		return framItems;
	}

	public String[] exchangeRead() {
		File file = new File("exchange.txt");// ���� ���� ��������
		FileInputStream fis;
		String str = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			str = in.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (str == null) {// ���� �ƹ��͵� �Ⱦ����� �ִٸ�
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
				String str = p.getName() + "," + p.getPrice() + "," + p.getRemains() + "," + p.getFarmer() + p.getPath()
						+ "\n";
				br.write(str);
				System.out.println(str);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exchangeWirte(String money[]) {// [0]õ��,��õ��,����,������
		File file = new File("exchange.txt");// �� ���� ��������
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

	private void divisionFile() {// �� ���� �о� ���� ��... �Ӹ��� ���۰� ���� ���ߴ�
		File file = new File("selldata.txt");

		BufferedWriter out = null;
		BufferedWriter out2 = null;

		allSellMoney = new Vector<>();
		String readStr = null;
		int MonthsM = 0;// �ٴ� �����
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((readStr = br.readLine()) != null) {
				String strArr[] = readStr.split(",");
				allSellMoney.add(strArr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������
		try {
			for (int i = 0; i < allSellMoney.size() - 1; i++) {
				for (int j = i + 1; j < allSellMoney.size(); j++) {

					System.out.println(allSellMoney.get(i)[1] + "\t" + allSellMoney.get(j)[1]);

					System.out.println(allSellMoney.get(allSellMoney.size() - 1)[1]+"######"+allSellMoney.get(j)[1]);
					if (allSellMoney.get(allSellMoney.size() - 1)[1].equals(allSellMoney.get(j)[1])) {
						// ������ ��
						String str = allSellMoney.get(i)[0] + "," + allSellMoney.get(i)[1] + ","
								+ allSellMoney.get(i)[2] + "," + allSellMoney.get(i)[3];
						out = new BufferedWriter(new FileWriter("month.txt"));// 1~30
						out.write(str + "\n");

					}
					
					if (allSellMoney.get(i)[1].equals(allSellMoney.get(j)[1])) {

						MonthsM += Integer.parseInt(allSellMoney.get(j)[3]);
						// else 3==4
						

					} else {
						System.out.println("==========");
						String str = allSellMoney.get(i)[0] + "," + allSellMoney.get(i)[1] + ","
								+ allSellMoney.get(i)[2];
						i = j;
						out2 = new BufferedWriter(new FileWriter("months.txt"));// �ٴ�
						out2.write(str + "," + String.valueOf(MonthsM) + "\n");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out2.close();//months
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	// �����.....��Ʈ��
	public DefaultCategoryDataset getDataSet(int selectFile) {
		divisionFile();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		str_V = new Vector<>();
		// ������ �Է� ( ��, ����, ī�װ� )�����Ǽ�,String,String
		// �׷��� ,.... ����� ������ �Է��ϸ�...
		switch (selectFile) {
		case 1:// year
			strFilePath = "months.txt";
			str[0] = "����";
			str[1] = "��";
			startIdx = 5;
			endIdx = 7;
			break;
		case 2:// year
			strFilePath = "month.txt";
			str[0] = "�Ѵ�";
			str[1] = "��";
			startIdx = 8;
			endIdx = 10;
			break;
		case 3:// Current
			strFilePath = "month.txt";
			str[0] = "�ֱ� ������";
			str[1] = "��";
			startIdx = 8;
			endIdx = 10;
			break;
		default:
			break;
		}

		try {
			File file = new File(strFilePath);// ���� ���� ��������
			BufferedReader br = new BufferedReader(new FileReader(file));

			String readStr = null;

			if (selectFile == 3) {
				while ((readStr = br.readLine()) != null) {
					String strArr[] = readStr.split(",");
					str_V.add(strArr);
				}

				for (int i = str_V.size() - 7; i < str_V.size(); i++) {
					int ���ⷮ = Integer.parseInt(str_V.get(i)[3]);
					dataset.addValue(���ⷮ, str[0], str_V.get(i)[2] + str[1]);
				}

			} else {
				while ((readStr = br.readLine()) != null) {

					String strArr[] = readStr.split(",");
					dataset.addValue(Integer.parseInt(strArr[3]), str[0], strArr[2] + str[1]);
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("!!");
			e.printStackTrace();
		} // ���Ͽ� �ִ� ������ ��������

		return dataset;
	}
}
// Study_java/JavaApp5_weak/src/com/kosta/j0322/ObjectWriteTest.java

/*
 * �ڹ�(JAVA) �� ��ȯ(String�� Date) String to Date
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