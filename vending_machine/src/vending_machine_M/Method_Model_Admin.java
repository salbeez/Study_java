package vending_machine_M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import org.jfree.data.category.DefaultCategoryDataset;

import vending_machine_V.Vegitable;

public class Method_Model_Admin {
	private static final long serialVersionUID = 1L;

	FileInputStream fis;
	String strFilePath, str[] = new String[2];
	int startIdx, endIdx;

	Vector<String[]> str_V;
	Vector<String[]> allSellMoney;

	Vector<Vegitable> framItems;// �� �������� ����
	Vector<Vegitable> sellItems;// �Ǹ��� �������� ������

	public Method_Model_Admin() {
		divisionFile();
	}

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
		BufferedWriter br = null;
		String str = null;
		try {

			br = new BufferedWriter(new FileWriter("nowItem.txt"));

			for (int j = 0; j < sellItems.size(); j++) {
				Vegitable p = sellItems.get(j);
				if (p != null) {
					str = p.getName() + "," + p.getPrice() + "," + p.getRemains() + "," + p.getFarmer() + ","
							+ p.getPath() + "\n";
					br.write(str);
				} else {
					str = "0,0,0,0,0\n";
					br.write(str);
				}
				System.out.println(str);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

		BufferedReader br = null;
		BufferedWriter out = null;
		BufferedWriter out2 = null;

		allSellMoney = new Vector<>();
		String readStr = null;
		int MonthsM = 0;// �ٴ� �����
		try {
			br = new BufferedReader(new FileReader(file));
			out = new BufferedWriter(new FileWriter("month.txt"));// 1~30
			out2 = new BufferedWriter(new FileWriter("months.txt"));// �ٴ�

			while ((readStr = br.readLine()) != null) {// ���� �迭�� �ְ�
				String strArr[] = readStr.split(",");
				allSellMoney.add(strArr);
			}

			// ������
			for (int i = 0; i < 12; i++) {// 1���� 12��
				for (int j = i + 1; j < allSellMoney.size(); j++) {

					System.out.println(allSellMoney.get(i)[1] + "\t" + allSellMoney.get(j)[1]);

					if (allSellMoney.get(i)[1].equals(allSellMoney.get(j)[1])) {

						MonthsM += Integer.parseInt(allSellMoney.get(j)[3]);
						System.out.println(MonthsM + "\t\t" + allSellMoney.get(j)[0] + allSellMoney.get(j)[1]
								+ allSellMoney.get(j)[2]);
						// else 3==4

					} else {
						System.out.println("==========");

						String str = allSellMoney.get(i)[0] + "," + allSellMoney.get(i)[1] + ","
								+ allSellMoney.get(i)[2];
						System.out.println("\t\t\t\t" + i + "\t" + j);
						i = j;
						out2.write(str + "," + String.valueOf(MonthsM) + "\n");
						MonthsM = 0;
					}

					System.out
							.println(allSellMoney.get(allSellMoney.size() - 1)[1] + "######" + allSellMoney.get(j)[1]);
					if (allSellMoney.get(allSellMoney.size() - 1)[1].equals(allSellMoney.get(j)[1])) {
						// ������ ��
						System.out.println("������ ��");
						String str = allSellMoney.get(j)[0] + "," + allSellMoney.get(j)[1] + ","
								+ allSellMoney.get(j)[2] + "," + allSellMoney.get(j)[3];
						System.out.println(str);
						out.write(str + "\n");
					} // ������ ��
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				out2.close();// months
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	// �����.....��Ʈ��
	public DefaultCategoryDataset getDataSet(int selectFile) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		str_V = new Vector<>();
		// ������ �Է� ( ��, ����, ī�װ� )�����Ǽ�,String,String
		// �׷��� ,.... ����� ������ �Է��ϸ�...
		switch (selectFile) {
		case 1:// �ٴ�
			strFilePath = "months.txt";
			str[0] = "����";
			str[1] = "��";
			startIdx = 5;
			endIdx = 7;
			break;
		case 2:// �Ѵ޵���
			strFilePath = "month.txt";
			str[0] = "�Ѵ�";
			str[1] = "��";
			startIdx = 8;
			endIdx = 10;
			break;
		case 3:// �ֱ� ������
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
			String fuck = null;// ��,��
			if (selectFile == 3) {
				while ((readStr = br.readLine()) != null) {
					String strArr[] = readStr.split(",");
					str_V.add(strArr);
				}
				int startIdx = 0;
				if ((str_V.size() - 7) > 0) {
					startIdx = str_V.size() - 7;
				}
				for (int i = startIdx; i < str_V.size(); i++) {
					int revenue = Integer.parseInt(str_V.get(i)[3]);
					dataset.addValue(revenue, str[0], str_V.get(i)[2] + str[1]);
				}

			} else {
				while ((readStr = br.readLine()) != null) {
					String strArr[] = readStr.split(",");
					if (selectFile == 2) {
						fuck = strArr[2];
					} else {
						fuck = strArr[1];
					}
					dataset.addValue(Integer.parseInt(strArr[3]), str[0], fuck + str[1]);
				}
			}
			br.close();
		} catch (Exception e) {
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