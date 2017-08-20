/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.listener;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pravin Kumbhar
 */
public class SessionTimeoutListener implements HttpSessionListener {
	private static final Logger logger = LoggerFactory.getLogger(SessionTimeoutListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    	logger.debug("sessionCreated - add one session into counter");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        HttpSession session = httpSessionEvent.getSession();


    }

}
