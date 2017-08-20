/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.security;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.pavikumbhar.javaheart.service.UserService;



/**
 *
 * @author pravinkumbhar
 */
@Component("authenticationSuccessHandler")
public class CustomSimpleUrlAuthenticationSuccessHandler   implements AuthenticationSuccessHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    ActiveUserStore activeUserStore;
    
    @Autowired
    private UserService userService;

 


    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        handle(request, response, authentication);
        final HttpSession session = request.getSession(false);
        if (session != null) {
            //session.setMaxInactiveInterval(30 * 60);
        	session.setMaxInactiveInterval(2 * 60);
           LoggedUser user = new LoggedUser(authentication.getName(), activeUserStore);
            session.setAttribute("user", user);
        }
        clearAuthenticationAttributes(request);
    }

    protected void handle(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        final String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(final Authentication authentication) {
        boolean isUser = true;
        boolean isAdmin = false;
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        /*
        for (final GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("READ_PRIVILEGE")) {
                isUser = true;
            } else if (grantedAuthority.getAuthority().equals("WRITE_PRIVILEGE")) {
                isAdmin = true;
                isUser = false;
                break;
            }
        }
        */
        if(isPasswordExpired(authentication.getName())){
        	 return "/changePassword.html";
        }
        else if (isUser) {
            return "/homepage?user=" + authentication.getName();
        } else if (isAdmin) {
            return "/console.html";
        } else {
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
    
    
    public boolean isPasswordExpired(String username){
    	  
    	 boolean passwordExpired=false;
    	  int minimumPasswordAge =30;//Days
          Date today;
		  Date passwordModifiedDate = userService.findByUsername(username).getPasswordModifiedDate();
		  today = Calendar.getInstance().getTime();
		  logger.debug(" passwordModifiedDate =" + passwordModifiedDate + "  -- today =" + today);
		  logger.debug(" Minimum Password Age == " + minimumPasswordAge + " << Difference >>>> " + ((today.getTime() - passwordModifiedDate.getTime()) / (1000 * 60 * 60 * 24)));
          long DATE_DIFFER = (today.getTime() - passwordModifiedDate.getTime()) / (1000 * 60 * 60 * 24);

          if (DATE_DIFFER >= minimumPasswordAge){
        	  
        	  passwordExpired=true;
          }
		return passwordExpired;
    }
}
