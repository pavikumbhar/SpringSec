/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.springconfiguration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 *
 * @author PaviKumbhars
 */



public class ContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	private static final Logger logger = LoggerFactory.getLogger(ContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        logger.info("com.pavikumbhar.javaheart.ContextInitializer.initialize()");
        try {
            environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:env.properties"));
            String profile = environment.getProperty("spring.profiles.active");
            environment.setActiveProfiles(profile);
            logger.debug(" spring.profiles.active profile :" + profile);
            logger.debug("env.properties loaded :" + ContextInitializer.class.getName());
        } catch (IOException e) {
            // it's ok if the file is not there. we will just log that info.
        	logger.debug("didn't find env.properties in classpath so not loading it in the AppContextInitialized");
        }
    }

    
    
        
       

}

