package com.kosta.j0428;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author kosta
 * @정리 이벤트 기반의 파서
 * @문제 book.xml을 읽어서 화면 콘솔에 내용 출력
 * @한번만 시작하는 것  locate, startDocument
 */
public class SaxTest extends DefaultHandler {// implement ContentHandler {
	SAXParserFactory factory;
	SAXParser parser;
	Document doc;

	public SaxTest() {
		factory = SAXParserFactory.newInstance();
		try {
			parser = factory.newSAXParser();
			parser.parse("j0428/book.xml", this);
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
	}// constr
@Override
	public void startDocument() throws SAXException {
		System.out.println("<?xml version="+1.0+" encoding="+"UTF-8"+"?>");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<" + qName + " ");
		for (int i = 0; i < attributes.getLength(); i++) {
			String attName = attributes.getQName(i);
			String attVal = attributes.getValue(i);
			System.out.print(attName + "='" + attVal + "' ");
		}
		System.out.print(">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</" + qName + ">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch, start, length));
	}

	public static void main(String[] args) {
		new SaxTest();
	}// main
}
