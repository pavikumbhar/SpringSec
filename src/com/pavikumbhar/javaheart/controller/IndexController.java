/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pravinkumbhar
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	  @RequestMapping(value = "in",method = RequestMethod.GET)
	     public String in(ModelMap modelMap ) {
	    	
	         return "in";
	     }

    @RequestMapping
    public String index(ModelMap modelMap) {

        return "index";
    }

    
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(ModelMap modelMap,HttpServletRequest request) {
    	String referrer = request.getHeader("Referer");
    	logger.info("Referrer",referrer);
    	
	    if(referrer!=null){
	        request.getSession().setAttribute("url_prior_login", referrer);
	    }
        return "login";
    }
    
     @RequestMapping(value = "login",method = RequestMethod.POST)
    public String loginRequest(ModelMap modelMap,HttpServletRequest request) {
    	 

        return "login";
    }
     
     @RequestMapping(value = "homepage",method = RequestMethod.GET)
     public String home(ModelMap modelMap, @RequestParam String user ) {
    	 modelMap.addAttribute("user", user);
    	 System.out.println(user);
         return "home";
     }
     
     
     @RequestMapping(value="/logout", method = RequestMethod.GET)
     public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         if (auth != null){    
             new SecurityContextLogoutHandler().logout(request, response, auth);
         }
         return "redirect:login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
     }
    
}
