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
 * @문제 book.xml을 읽어서 책 제목들을 화면에 출력
 * @문제2 외국 할아버지가 저자인 책목록을 출력하시오.
 * @한번만 시작하는 것 locate, startDocument
 */

public class SaxTest2  extends DefaultHandler{//implements ContentHandler{
	//SAX: 이벤트기반의 파서
	
	SAXParserFactory factory;
	SAXParser parser;
	
	boolean titleFlag;
	boolean authorFlag;
	String tempTitle;//책제목을 임시 저장
	/*
	   미션: books.xml문서내의 책제목들을 화면에 출력하시오.
	    결과)
	        <책목록>
	         JavaProgramming
	         OracleSQL
	         JavaScript
	         XMLBible
	         
	  미션2: 저자 홍길동의 책목록을 출력하시오.     
	 */
	
	public SaxTest2() {
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			System.out.println("<책목록>");
			parser.parse("j0428/book.xml", this);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//생성자
	
	
	
	@Override
    public void startElement(String uri, String localName, String qName, 
    		                  Attributes attributes) throws SAXException {
		//qName: 태그명
		
		if(qName.equals("title")){
			titleFlag=true;
		}else if(qName.equals("author")){
			authorFlag=true;
		}
	}//startElement
	
	@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
		titleFlag=false;
		authorFlag=false;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
	   String str = new String(ch,start,length);
	   if(titleFlag){//<title>태그내의 text
		   tempTitle = str;//임시저장
		   //System.out.println(str);		   
	   }
	   
	   if(authorFlag){//현재 text가 author의 내용일때
		   if(str.equals("외국 할아버지")){
			   System.out.println(tempTitle);
		   }
	   }
	}//characters
	
	
	public static void main(String[] args) {
		new SaxTest2();
	}

	
}

