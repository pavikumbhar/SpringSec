/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.springconfiguration;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author pravinkumbhar
 */
@Configuration
@ComponentScan(basePackages = {"com.pavikumbhar.javaheart"} ,
              excludeFilters = {  @ComponentScan.Filter(org.springframework.stereotype.Controller.class),
                                  @ComponentScan.Filter(org.springframework.web.servlet.config.annotation.EnableWebMvc.class)
                               })
 @EnableTransactionManagement 
@PropertySources(value = { @PropertySource(value = "classpath:persistence.properties")})
public class AppConfig {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	
    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;
    
    
    @PostConstruct
    public void initApp() {
        System.out.println("Looking for Spring profiles...");
        if (environment.getActiveProfiles().length == 0) {
            System.out.println("No Spring profile configured, running with default configuration.");
        } else {
            for (String profile : environment.getActiveProfiles()) {
            	logger.debug("Detected Spring profile: {}" + profile);
            	logger.debug("Developed By #######################[Pavi Kumbhar] #######################");
            }
        }
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[]{"com.pavikumbhar.javaheart.entity"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
