package com.kosta.t0519;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
	// 등록을 해야함 web.xml에
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized");
		// 공유할 객체 저장
		ServletContext application = sce.getServletContext();
		application.setAttribute("book",new  Book());
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed");
	}
}