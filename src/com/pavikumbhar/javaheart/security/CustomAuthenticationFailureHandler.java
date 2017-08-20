/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.security;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

/**
 *
 * @author pravinkumbhar
 */
@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	 private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MessageSource messages;

    @Autowired
    private LocaleResolver localeResolver;
    
    

    @Override
    public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        setDefaultFailureUrl("/login?error=true");
        super.onAuthenticationFailure(request, response, exception);
        
        String userName = request.getParameter("username");
        System.out.println("[AuthenticationFailure]:" + " [Username]:" + userName + " [Error message]:" + exception.getMessage());
    /*
        if (exception instanceof BadCredentialsException) {
        	setDefaultFailureUrl("/login?error=true");
        } else if (exception instanceof CredentialsExpiredException) {
        	setDefaultFailureUrl("/changecredential?error=true");
        } else if (exception instanceof DisabledException) {
        	setDefaultFailureUrl("/changecredentials?error=true");
        } else if (exception instanceof LockedException) {
        	setDefaultFailureUrl("/login?error=true");
        }
*/
        final Locale locale = localeResolver.resolveLocale(request);
        
        

       String errorMessage = messages.getMessage("message.badCredentials", null, locale);
       logger.debug("errorMessage  " + errorMessage);
       logger.debug("exception [] " + exception.getClass().getName());
       logger.debug("exception.getMessage() []  " + exception.getMessage());
       logger.debug("exception []  " + (exception instanceof org.springframework.security.core.userdetails.UsernameNotFoundException));

          
        if (exception.getMessage() != null) {
            if (exception.getMessage().equalsIgnoreCase("User account is locked")) {
                errorMessage = messages.getMessage("auth.message.disabled", null, locale);
                errorMessage="User account is locked";
            } else if (exception.getMessage().equalsIgnoreCase("User account has expired")) {
                errorMessage = messages.getMessage("auth.message.expired", null, locale);
            } else if (exception.getMessage().equalsIgnoreCase("User credentials have expired")) {
                
                errorMessage = messages.getMessage("auth.message.blocked", null, locale);
            } else if (exception.getMessage().equalsIgnoreCase("Bad credentials")) {
                errorMessage = messages.getMessage("auth.message.expired", null, locale);
               errorMessage=" Bad credentials";
            }else if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
                errorMessage = messages.getMessage("auth.message.disabled", null, locale);
            }
            
        }
        
         request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
    }
    
   
}
