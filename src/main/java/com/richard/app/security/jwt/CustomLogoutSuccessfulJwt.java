package com.richard.app.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;

@Service //This entire class could be an endpoint with  "LogoutSuccessURL("/logoutsuccess")" Uniformity*
public class CustomLogoutSuccessfulJwt implements LogoutSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private String targetUrl = "/";
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		Cookie cookie = new Cookie("JWT", null);
		//Cookie will be deleted immediately after logout
		cookie.setMaxAge(0);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
	    response.addCookie(cookie);
		
		 redirectStrategy.sendRedirect(request, response, targetUrl);	
	}
	
}
