package com.pavikumbhar.javaheart.security.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class ProfilingMethodInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ProfilingMethodInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        final StopWatch stopWatch = new StopWatch(invocation.getMethod().toGenericString());
        stopWatch.start("invocation.proceed()");
        try {
        	String methodName = invocation.getMethod().getAnnotation(RequestMapping.class).path()[0].substring(1).toUpperCase();
        	String requestMethod = invocation.getMethod().getAnnotation(RequestMapping.class).method()[0].name();
        	String permissionName = "PERMISSION_"+methodName+"_"+requestMethod;
        	for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
				if(authority.getAuthority().equals(permissionName)){
					return invocation.proceed();					
				}
			}
        	return null;					
        } finally {
            stopWatch.stop();
        }
    }
} 