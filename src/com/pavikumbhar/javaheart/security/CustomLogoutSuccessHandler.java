/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author pravinkumbhar
 */
@Component("logoutSuccessHandler")
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("user");
        }

        /**
         * *******Added******
         */
        request.getSession().invalidate();
        response.setStatus(HttpServletResponse.SC_OK);
        //redirect to login
        response.sendRedirect("login");
        List<SessionInformation> userSessions = sessionRegistry.getAllSessions(session, true);

        for (SessionInformation sessionInformation : userSessions) {
            sessionRegistry.removeSessionInformation(sessionInformation.getSessionId());
        }

        /**
         * *******Added Extra******
         */
    }

}
