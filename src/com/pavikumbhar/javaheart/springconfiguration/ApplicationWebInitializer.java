package com.pavikumbhar.javaheart.springconfiguration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.pavikumbhar.javaheart.filter.CorsFilter;
import com.pavikumbhar.javaheart.listener.ApplicationVersionListener;
import com.pavikumbhar.javaheart.listener.SessionTimeoutListener;

/**
 *
 * @author Pravin Kumbhar
 */
@Order(1)
public class ApplicationWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationWebInitializer.class);
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class,AppSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{
                          // new DelegatingFilterProxy("springSecurityFilterChain") ,
                           new CorsFilter(),characterEncodingFilter,
                        
                          };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	logger.debug("***** Initializing Application for " + servletContext.getServerInfo() + " *****");
        super.onStartup(servletContext);
        servletContext.addListener(new ApplicationVersionListener());
        servletContext.addListener(new SessionTimeoutListener());
        //servletContext.setInitParameter("spring.profiles.active", "prod");
       //Dynamic profile 
       servletContext.setInitParameter("contextInitializerClasses", ContextInitializer.class.getName());
      
       
       
    }
    
    //weblogic
     @Override
     protected void customizeRegistration(ServletRegistration.Dynamic registration) {
       registration.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
       
       
    }
     
     

}
