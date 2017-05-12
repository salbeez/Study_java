package com.kosta.t0512;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author kosta
 * @역할: 커스텀 태그를 만났을떄 실행할 코드를 기술.
 */
public class MyTagHandler extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		// 브라우저 출력 객체
		JspWriter out = pageContext.getOut();
		try {
			for (int i = 0; i < 10; i++) {
				if (i % 2 == 0) {
					out.println("<font color=blue>안녕, 커스텀 태그</font><br>");
				} else {
					out.println("안녕, 커스텀 태그<br>");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
