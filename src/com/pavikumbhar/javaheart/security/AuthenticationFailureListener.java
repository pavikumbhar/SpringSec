/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.security;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.pavikumbhar.javaheart.entity.User;
import com.pavikumbhar.javaheart.service.UserService;

/**
 *
 * @author pravinkumbhar
 */
@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

	@Autowired
	private UserService userService;

	private static final int MAX_ATTEMPTS = 3;

	@Override
	public void onApplicationEvent(final AuthenticationFailureBadCredentialsEvent e) {
		final WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();

		if (auth != null) {
			String userName = null;
			Object principal = e.getAuthentication().getPrincipal();

			if (principal instanceof UserDetails) {
				userName = ((UserDetails) principal).getUsername();
			} else {
				userName = principal.toString();
			}

			User user = userService.findByUsername(userName);
			if (user != null) {

				if (user.getLoginAttempt() < MAX_ATTEMPTS) {
					user.setLoginAttempt(user.getLoginAttempt() + 1);
					userService.update(user);
				}
				
				if((user.isAccountNonLocked()==true) && (user.getLoginAttempt()==MAX_ATTEMPTS)){
					user.setAccountNonLocked(false);
					user.setAccountlockTime(Calendar.getInstance().getTime());
					userService.update(user);
					
				}

			}

			System.out.println("[][][][][][]com.pavikumbhar.javaheart.security.AuthenticationFailureListener.onApplicationEvent()"
							+ userName);
			System.out.println("Authentication Increament");

		}
	}

}
