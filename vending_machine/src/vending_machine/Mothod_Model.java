package vending_machine;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.Vector;

import org.jfree.data.category.DefaultCategoryDataset;

public class Mothod_Model {
	FileInputStream fis;
	String strFilePath, str[] = new String[2];
	int startIdx, endIdx;

	Vector<Revenue_Year> v;
	Vector<Vegitable> framItems;// �� �������� ����

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
				System.out.println(
						"ä���̸� :" + p_read.getName() + " ���� : " + p_read.getPrice() + " ������ : " + p_read.farmer);
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
		String strArr[] = str.split(",");
		return strArr;
	}
	public void exchangeWirte(){}
	// �����.....��Ʈ��
	public DefaultCategoryDataset getDataSet(int selectFile) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		v = new Vector<>();
		// ������ �Է� ( ��, ����, ī�װ� )�����Ǽ�,String,String
		// �׷��� ,.... ����� ������ �Է��ϸ�...
		switch (selectFile) {
		case 1:// year
			strFilePath = "a.ser";
			str[0] = "����";
			str[1] = "��";
			startIdx = 5;
			endIdx = 7;
			break;
		case 2:// year
			strFilePath = "month.ser";
			str[0] = "�Ѵ�";
			str[1] = "��";
			startIdx = 8;
			endIdx = 10;
			break;
		case 3:// year
			strFilePath = "month.ser";
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
			fis = new FileInputStream(file);

			ObjectInputStream ois = new ObjectInputStream(fis);// ������Ʈ ���·� �����´�
			int count = 0;
			System.out.println(ois.available());

			if (selectFile == 3) {
				while ((count = fis.available()) > 0) {
					Revenue_Year p_read = (Revenue_Year) ois.readObject();
					v.add(p_read);
				}

				for (int i = v.size() - 7; i < v.size(); i++) {
					dataset.addValue(v.get(i).getRevenue(), str[0],
							v.get(i).getCalendar().substring(startIdx, endIdx) + str[1]);
				}

			} else {
				while ((count = fis.available()) > 0) {
					Revenue_Year p_read = (Revenue_Year) ois.readObject();
					dataset.addValue(p_read.getRevenue(), str[0],
							p_read.getCalendar().substring(startIdx, endIdx) + str[1]);
				}
			}

			fis.close();
			ois.close();

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