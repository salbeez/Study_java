package com.kosta.j0427;

import java.io.IOException;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author kosta
 * @문제 콘솔화면에 "금천구 가산동 15시 기온은 22도 입니다."
 * @문제 최저기온은 몇도 최고 기온은 몇도 입니다.
 */
public class weatherPasing {
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;

	public weatherPasing() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			doc = builder.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000");
			Element root = doc.getDocumentElement();

			String temp = null, hour = null, tmx = null, tmn = null;
			NodeList datalist = root.getElementsByTagName("data");

			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int date = cal.get(Calendar.DATE) + 1;

			for (int i = 0; i < datalist.getLength(); i++) {
				String seq = datalist.item(i).getAttributes().item(0).getNodeValue();// 속성값
																						// 비교용
				System.out.println(seq);

				if (seq.equals("7") || seq.equals("15")) {// 15시관련
					NodeList node = datalist.item(i).getChildNodes();
					temp = node.item(5).getFirstChild().getNodeValue();
					hour = node.item(1).getFirstChild().getNodeValue();
					tmx = node.item(7).getFirstChild().getNodeValue();
					tmn = node.item(9).getFirstChild().getNodeValue();
					System.out.println("금천구 가산동 " + hour + "시 " + "기온은 " + temp + "도 입니다.");
					System.out.println("최저기온은 " + tmn + "도 " + "최고기온은 " + tmx + "도 입니다.");
				}
			}

			NodeList hourlist = doc.getElementsByTagName("hour");
			for (int i = 0; i < hourlist.getLength(); i++) {
				if (hourlist.item(i).getFirstChild().getNodeValue().equals("15")) {
					Node tempN = hourlist.item(i).getNextSibling().getNextSibling().getNextSibling().getNextSibling();
					System.out.println(tempN.getFirstChild().getNodeValue());
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new weatherPasing();
	}
}
