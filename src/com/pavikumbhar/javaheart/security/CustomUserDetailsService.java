/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.security;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavikumbhar.javaheart.entity.Role;
import com.pavikumbhar.javaheart.entity.User;
import com.pavikumbhar.javaheart.service.UserService;

/**
 *
 * @author pravinkumbhar
 */
@Service("userDetailsService")
@Transactional
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    private static final int MAX_ATTEMPTS = 3;
    
    public CustomUserDetailsService() {
        super();
    }

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException   {

       // User user = new User();
        User user =userService.findByUsername(username);
        //user.setUsername("pravin");
       // user.setEnabled(false);
        try {
        	
        	if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + username);
        	}
        	
        	//checking for account lock flag
        	 Date now = new Date();
             Date accountlockTime = user.getAccountlockTime();
           
             if((user.isAccountNonLocked()==false) && (user.getLoginAttempt()==MAX_ATTEMPTS)){
				 int maxLockTime=2;//2 min
            
				 if (accountlockTime != null) {
                     if (((now.getTime() - accountlockTime.getTime()) / 36000) > maxLockTime) {
                    	 user.setAccountNonLocked(true);
                    	 user.setLoginAttempt(0);
                    	 user.setAccountlockTime(null);
                     }

                 }
            		
				}
             
            

            
               Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
            for (Role role : user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled() ,user.isAccountNonExpired() ,user.isCredentialsNonExpired(),user.isAccountNonLocked(),grantedAuthorities);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
   
    /*
    @Override
    public UserDetails loadUserByUsername( String username )
        throws UsernameNotFoundException, DataAccessException , CredentialsExpiredException ,BadCredentialsException ,
        LockedException , DisabledException , UsernameNotFoundException
    {
        User user = userService.findByUsername(username);
        System.out.println("User Found");

        if( user == null ){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException( username + " is not found." );
        }

        if( user.isEnabled() == false ){
         System.out.println("User not enabled");
           throw new DisabledException( "User not enabled" );
       }

        if( user.isLocked() == true ){
             System.out.println("User is Locked");
              throw new LockedException( "User is Locked" );
          }
        if( user.isPasswordExpired() == true ){
             System.out.println("Password Expired");
             throw new CredentialsExpiredException( "Password Expired" );
         }  

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled() ,user.isExpired() ,user.isPasswordExpired(),user.isLocked(),grantedAuthorities);
      }
*/
}
