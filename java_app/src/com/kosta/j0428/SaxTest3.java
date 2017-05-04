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
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author kosta
 * @정리 이벤트 기반의 파서
 * 
 * @한번만 시작하는 것 locate, startDocument
 */
public class SaxTest3 extends DefaultHandler {// implement ContentHandler {
	SAXParserFactory factory;
	SAXParser parser;
	Document doc;
	boolean flag;
	boolean flagAuthor;
	String tempTitle;

	public SaxTest3() {
		factory = SAXParserFactory.newInstance();
		factory.setValidating(true);//DTD체크
		try {
			System.out.println("===book.xml에서 title만 뽑아 출력===\n================");
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
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("치면적 에러");
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("DTD 또는 Schema와 일치 하지 않음");
		e.printStackTrace();
	}

	public static void main(String[] args) {
		new SaxTest3();
	}// main
}
