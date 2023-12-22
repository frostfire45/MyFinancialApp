package com.frostfire.myfinancialapp;


import com.frostfire.myfinancialapp.config.HibernateConfig;
import com.frostfire.myfinancialapp.config.MvcConfiguration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class FinancialWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
        implements WebApplicationInitializer {
/*
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		//webContext.register(MvcConfiguration.class);
		webContext.setServletContext(servletContext);
		
		//ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
		//		new DispatcherServlet(webContext));
		
		//servlet.setLoadOnStartup(1);
		//Serving it. 
		//servlet.addMapping("/");
	}
*/
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HibernateConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MvcConfiguration.class};
	}
}
