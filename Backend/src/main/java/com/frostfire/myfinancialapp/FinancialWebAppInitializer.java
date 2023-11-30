package com.frostfire.myfinancialapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.frostfire.myfinancialapp.Services.SqliteService;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.frostfire.myfinancialapp.serverletconfig.MvcConfiguration;

public class FinancialWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(MvcConfiguration.class);
		webContext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(webContext));
		
		servlet.setLoadOnStartup(1);
		//Serving it. 
		servlet.addMapping("/");
		SqliteService.connect();
	}
}
