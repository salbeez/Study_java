package com.kosta.j0426;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * alt + shift + j
 * 
 * @author kosta
 * @내용 파일 문서 데이터 불러오기 
 * @내용 books.xml --->파일 출력(books2.xml)
 * @참조파일 book.xml
 */
public class DOMTEST3 {
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;
	
	FileOutputStream fo;
	public DOMTEST3() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse("j0426/book.xml");// 가져오는데
			fo = new FileOutputStream("j0426/book2.xml");

			Element root = doc.getDocumentElement();
			processNode(doc);
			fo.close();

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

		try {
			switch (e.getNodeType()) {// 1~12
			case Node.ELEMENT_NODE:
				NodeList list = e.getChildNodes();
				String tagName = e.getNodeName();
					fo.write(("<"+tagName+getAtt(e)+">").getBytes());
				
				System.out.print("<" + tagName +getAtt(e)+ ">");
				for (int i = 0; i < list.getLength(); i++) {
					processNode(list.item(i));
				}
				fo.write(("</"+tagName+">").getBytes());
				System.out.print("</" + tagName + ">");
				break;

			case Node.TEXT_NODE:
				String content = e.getNodeValue();
				fo.write(content.getBytes());
				System.out.print(content);
				break;

			case Node.COMMENT_NODE:
				String content2 = e.getNodeValue();
				fo.write(("<!--" + content2 + "-->").getBytes());
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
		} catch (DOMException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println(" 자식의 길이 : " + e.getChildNodes().getLength());
	}
	public String getAtt(Node e){
		String str="";
		for (int i = 0; i < e.getAttributes().getLength(); i++) {
			Node attName = e.getAttributes().item(i);		
			str +=" "+e.getAttributes().getNamedItem(attName.getNodeName());
		}
		return str;
	}
	public static void main(String[] args) {
		new DOMTEST3();
	}
}
