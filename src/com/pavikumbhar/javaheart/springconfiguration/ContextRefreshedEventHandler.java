/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.springconfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author pavikumbhar
 */

@Component
public class ContextRefreshedEventHandler implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(ContextRefreshedEventHandler.class);
     @Autowired
    private Environment environment;

   
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        
         String applicationName = contextRefreshedEvent.getApplicationContext().getApplicationName();
         String version = environment.getProperty("application.version");
         logger.debug("[################ [Started-"+applicationName +" " +version+" version] ###########]" );
       
    }

   
  
    
}
