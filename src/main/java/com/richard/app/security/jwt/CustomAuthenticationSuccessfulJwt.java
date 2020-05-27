package com.richard.app.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.richard.app.security.MyUserDetailsService;

@Service
public class CustomAuthenticationSuccessfulJwt implements AuthenticationSuccessHandler {

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
				
		//myAuthenticationSuccessHandler -> gets Userdetails from principal auth
		// -> creates a Token + cookie of JWT -> filter grabs cookie and auths
						
				UserDetails userDetails = myUserDetailsService.loadUserByUsername(authentication.getName());
				
				final String jwt = jwtTokenUtil.generateToken(userDetails);  
				String targetUrl = null;

			    //add NEW cookie to response
				Cookie cookie = new Cookie("JWT", jwt);
				cookie.setSecure(true);
				cookie.setHttpOnly(true);
			    response.addCookie(cookie);
			    
			    //Redirect user to appropriate destination for ROLE
			    if(userDetails.getAuthorities().toString().contains("ROLE_ADMIN")) {
			    	  targetUrl = "/admin";
			    }else {
			    	  targetUrl = "/user";
			    }
			   
			    redirectStrategy.sendRedirect(request, response, targetUrl);		
	}

}
