package com.monojue.assignment.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.context.support.GenericXmlApplicationContext;

@WebListener
public class SpringContainerManager implements ServletContextListener {
	
	public static final String SPRING_CONTEXT = "spring.context";
	private GenericXmlApplicationContext springContext;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Start IOC container
		System.out.println("Start IOC container");
		springContext = new GenericXmlApplicationContext("classpath:application.xml");
		sce.getServletContext().setAttribute(SPRING_CONTEXT, springContext);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Close IOC container
		System.out.println("Close IOC container");
		if(springContext != null) springContext.close();
	}

}
