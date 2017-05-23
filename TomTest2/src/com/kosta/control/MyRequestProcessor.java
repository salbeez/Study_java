package com.kosta.control;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;
import org.apache.struts.tiles.TilesRequestProcessor;

public class MyRequestProcessor extends TilesRequestProcessor {
	@Override
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
		try { 
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.processPreprocess(request, response);
	}
}
