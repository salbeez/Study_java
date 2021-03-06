package com.kosta.j0427;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * @author kosta
 * @문제 books.xml을 DOM Pasing을 하여 첫번쨰 book의 타이틀을 출력하시오
 * @결과화면 Java프로그래밍 @단,
 */
public class EX_DOMTest3 {
	DocumentBuilderFactory factory; // 공장
	DocumentBuilder builder; // 일꾼

	Document doc;

	public EX_DOMTest3() {
		factory = DocumentBuilderFactory.newInstance(); // 생성
		factory.setIgnoringElementContentWhitespace(true);
		try {
			builder = factory.newDocumentBuilder();
			// 재료(XML문서) 전달
			doc = builder.parse("j0426/book.xml");// text한 xml분석 --->메모리 로딩
			System.out.println("DOM 파싱 성공");

			// ===============DOM Programming 시작===============================
			Element root = doc.getDocumentElement();
			System.out.println("루드 엘리먼트 명 : " + root.getTagName());
			// 루트의 자식 구하라
			Node child = root.getFirstChild();
			System.out.println(child.getNodeValue());

			System.out.println("##" + doc.getChildNodes().item(0).getChildNodes().item(1).getChildNodes().item(1)
					.getChildNodes().item(0).getNodeValue());
			
			System.out.println(root.getElementsByTagName("title").item(2).getChildNodes().item(0).getNodeValue());
			
			System.out.println(root.getFirstChild().getNextSibling().getFirstChild().getNextSibling().getFirstChild().getNodeValue());

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
		new EX_DOMTest3();
	}
}
