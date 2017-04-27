package com.kosta.j0427;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * @author kosta
 * @설명 Node의 조작메소드 사용.
 * @설명2 특정 XML문서를 참조하지 않고 메모리상에 DOM트리 생성
 * @설명3 DOM Tree(메모리) --->파일 저장
 * @1 Root 추가
 * @2 
 * @3
 * @4
 * @5
 */
public class DOMTEST7 {//

	DocumentBuilderFactory factory; // 공장
	DocumentBuilder builder;
	Document doc;
	FileOutputStream fo;
	
	public DOMTEST7() {

			try {
				factory = DocumentBuilderFactory.newInstance();//생성
				builder = factory.newDocumentBuilder();
				doc =builder.newDocument();
				fo = new FileOutputStream("j0427/element.xml");
				Element root=  doc.createElement("ROOT");
				Element a = doc.createElement("A");
				Element b = doc.createElement("B");
				Element c = doc.createElement("C");
				Element d = doc.createElement("D");
				//추가 : 부모노드.appendChild(자식노드)
				doc.appendChild(root);
				
				//1번작업 :추가
				Text t1 = doc.createTextNode("Hello");
				Text t2 = doc.createTextNode("Good_Bye");
				Text t3 = doc.createTextNode("Good_Day");
				
				a.appendChild(c);
					c.appendChild(t1);
				b.appendChild(t2);
				d.appendChild(t3);
				
				root.appendChild(a);
				root.appendChild(b);
				root.appendChild(d);
				
				//2번 작업 :추가(끼워넣기)
				//부모노드.insertBefore(새로운노드,참조노드)
				root.insertBefore(d, b);
				
				//3번 작업 :삭제
					//root.removeChild(b);
				//만약, b태그를 삭제하고 싶은데 부모를 모른다면. 먼저 부모노드 찾고 삭제
				b.getParentNode().removeChild(b);
				
				//4번작업 :대체
				Element e = doc.createElement("E");
				root.replaceChild(e, d);
				
				//5번작업 :복제, 복제할 노드.cloneNode(트리레벨 상태); true:하위 레벨까지 복제,false:해당 노드만 복제
				 Node newRoot = root.cloneNode(true);
				 root.appendChild(newRoot);
				
				 //6
				Attr a2= doc.createAttribute("a");
				a2.setValue("10");
				a.setAttributeNode(a2);
				
				processNode(doc);
				fo.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
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
				System.out.println(e.getAttributes().getNamedItem("a"));
					fo.write(("<"+tagName+">").getBytes());
				System.out.print("<" + tagName+ ">");
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
			case Node.ATTRIBUTE_NODE:
				Node attName = e.getAttributes().item(0);
				System.out.println("==="+attName.getNodeType());
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
	
	public static void main(String[] args) {
		new DOMTEST7();
	}
	
}
