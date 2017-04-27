package com.kosta.j0427;

import java.io.IOException;

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
 * @문제 books.xml을 DOM Pasing을 하여 모든 북의 Title을 출력하시오
 * @문제2 book.xml의 모든 책 정보를 출력
 * @결과화면 Java프로그래밍 @단,
 */
public class EX_DOMTest2 {
	DocumentBuilderFactory factory; // 공장
	DocumentBuilder builder; // 일꾼

	Document doc;

	public EX_DOMTest2() {
		factory = DocumentBuilderFactory.newInstance(); // 생성
		factory.setIgnoringElementContentWhitespace(true);
		try {
			builder = factory.newDocumentBuilder();
			// 재료(XML문서) 전달
			doc = builder.parse("j0426/book3.xml");// text한 xml분석 --->메모리 로딩
			System.out.println("DOM 파싱 성공");

			// ===============DOM Programming 시작===============================
			Element root = doc.getDocumentElement();
			System.out.println("루드 엘리먼트 명 : " + root.getTagName());
			// 루트의 자식 구하라
			Node child = root.getFirstChild();
			System.out.println(child.getNodeValue());

			/*
			 * System.out.println("##" +
			 * doc.getChildNodes().item(0).getChildNodes().item(0).getChildNodes
			 * ().item(0) .getChildNodes().item(0).getNodeValue());
			 * 
			 * System.out.println(root.getElementsByTagName("title").item(2).
			 * getChildNodes().item(0).getNodeValue());
			 * 
			 * System.out.println(root.getFirstChild().getNextSibling().
			 * getFirstChild().getNextSibling().getFirstChild().getNodeValue());
			 */
			System.out.println("======모든 Title 내용을 출력======");
			for (int i = 0; i < root.getElementsByTagName("title").getLength(); i++) {
				System.out.println(root.getElementsByTagName("title").item(i).getFirstChild().getNodeValue());
			}
			System.out.println("===모든 책 정보 ===");
			NodeList authorList = doc.getElementsByTagName("author");
			NodeList pricerList = doc.getElementsByTagName("price");
			NodeList titleList = doc.getElementsByTagName("title");

			for (int i = 0; i < root.getChildNodes().getLength()-1; i++) {
					String a = authorList.item(i).getFirstChild().getNodeValue();
					String p = pricerList.item(i).getFirstChild().getNodeValue();
					String t = titleList.item(i).getFirstChild().getNodeValue();
					System.out.println(a + " " + p + " " + t);
			}
			System.out.println("===특정 작가의 책 정보 ===");
			 authorList = doc.getElementsByTagName("author");
			 for (int i = 0; i < authorList.getLength(); i++) {
					String a = authorList.item(i).getFirstChild().getNodeValue();
					String p = pricerList.item(i).getFirstChild().getNodeValue();
					String t = titleList.item(i).getFirstChild().getNodeValue();
					if(a.equals("외국 할아버지")){
					System.out.println(a + " " + p + " " + t);
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
		new EX_DOMTest2();
	}
}