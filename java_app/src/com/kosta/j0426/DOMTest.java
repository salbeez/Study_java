package com.kosta.j0426;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMTest {
	DocumentBuilderFactory factory; // 공장
	DocumentBuilder builder; // 일꾼

	Document doc;
	public DOMTest() {
		factory = DocumentBuilderFactory.newInstance(); // 생성
		try {
			builder = factory.newDocumentBuilder();
			//재료(XML문서) 전달
			doc = builder.parse("j0426/TEST.xml");//text한 xml분석 --->메모리 로딩
			System.out.println("DOM 파싱 성공");
			
			//===============DOM Programming 시작===============================
			Element root = doc.getDocumentElement();
			System.out.println("루드 엘리먼트 명 : " +root.getTagName());
			
			//루트의 자식 구하기
			Node child = root.getFirstChild();
			System.out.println(child.getNodeValue());
			
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
		new DOMTest();
	}
}
