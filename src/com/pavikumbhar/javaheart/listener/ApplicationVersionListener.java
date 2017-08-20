/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pavikumbhar.javaheart.version.ApplicationVersion;

/**
 *
 * @author Pravin Kumbhar
 */
public class ApplicationVersionListener implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationVersionListener.class);
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    	logger.debug("Stopped-" + ApplicationVersion.getversion());
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
    	logger.debug("Started-" + ApplicationVersion.getversion());
    }

}
