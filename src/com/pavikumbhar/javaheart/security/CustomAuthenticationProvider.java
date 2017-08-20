package com.pavikumbhar.javaheart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pavikumbhar.javaheart.entity.User;
import com.pavikumbhar.javaheart.service.UserService;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
	@Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	 final String username = authentication.getName();
    	 User user = userService.findByUsername(username);
    	 final String password = authentication.getCredentials().toString();
        if ((user == null)) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
        
        if ((password == null)) {
            throw new BadCredentialsException("Invalid Password");
        }
       
        final Authentication result = super.authenticate(authentication);
        return new UsernamePasswordAuthenticationToken(user, result.getCredentials(), result.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
