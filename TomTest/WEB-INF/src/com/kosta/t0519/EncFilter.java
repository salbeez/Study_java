package com.kosta.t0519;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncFilter implements Filter {

	private String encType;

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init");
		// config ---> Web.xml을 읽기
		encType = config.getInitParameter("encType");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFileter");
		req.setCharacterEncoding(encType);
		chain.doFilter(req, res);// 다음 필터 혹은 요청 페이지 연결

	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
