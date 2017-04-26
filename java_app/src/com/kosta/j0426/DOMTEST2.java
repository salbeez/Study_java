package com.kosta.j0426;

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
 * alt + shift + j
 * 
 * @author kosta
 * @내용 전체 문서 데이터 불러오기
 * @참조파일 book.xml
 */
public class DOMTEST2 {
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;

	public DOMTEST2() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse("j0426/book.xml");// 가져오는데

			Element root = doc.getDocumentElement();
			processNode(doc);
		//	processNode(root);
		//	System.out.println("\n" + doc.getLastChild().getNodeValue());
		//	System.out.println(doc.getChildNodes().item(1).getNodeValue());

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

	private void processNode(Node e) {

		switch (e.getNodeType()) {// 1~12
		case Node.ELEMENT_NODE:
			NodeList list = e.getChildNodes();
			String tagName = e.getNodeName();
			System.out.print("<" + tagName + ">");
			for (int i = 0; i < list.getLength(); i++) {
				// Node n = list.item(i); System.out.println(n.getNodeName());
				processNode(list.item(i));
			}
			System.out.print("</" + tagName + ">");
			break;

		case Node.TEXT_NODE:
			String content = e.getNodeValue();
			System.out.print(content);
			break;

		case Node.COMMENT_NODE:
			String content2 = e.getNodeValue();
			System.out.print("<!--" + content2 + "-->");
			break;
		
		case Node.DOCUMENT_NODE:
			NodeList list2 = e.getChildNodes();
			for (int i = 0; i < list2.getLength(); i++) {
				processNode(list2.item(i));
			}
			break;
		default:
			break;
		}
		// System.out.println(" 자식의 길이 : " + e.getChildNodes().getLength());
	}

	public static void main(String[] args) {
		new DOMTEST2();
	}
}
