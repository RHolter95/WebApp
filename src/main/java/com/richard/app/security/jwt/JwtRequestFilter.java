package com.richard.app.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.richard.app.security.MyUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private MyUserDetailsService userDetailService;
	
	@Autowired
	CustomLogoutSuccessfulJwt customAuthenticationSuccessfulJwt;
	
	@Autowired
	private JwtUtil jwtUtil;    
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
		throws ServletException, IOException{
		
	    //StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
	    //String requestURLString = requestURL.toString(); GETS CURRENT URL
		
		final String authorizationHeader = request.getHeader("Authorization");
		String username = null;
		String jwt = null;
		boolean jwtCookie = false;
		
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
		 for (Cookie cookie : cookies) {
			 
			 //If we have a JWT make sure its not null
		   if (cookie.getName().equals("JWT")) {
			   jwtCookie = true;
			   jwt = cookie.getValue();
			   
			   try {
				   username = jwtUtil.extractUsername(jwt);
				} catch (ExpiredJwtException e) {
						System.out.println("Expired Token");
				}
		    }
		  }
		}
				
			if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ") && jwtCookie == false) {
				jwt = authorizationHeader.substring(7);
				username = jwtUtil.extractUsername(jwt);
			}
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
				if(jwtUtil.validateToken(jwt, userDetails)){
						UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken
								(userDetails, null, userDetails.getAuthorities());
						usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
						
						//Redirects to User or Admin based on JWT IF at home page
						//Redirect(requestURLString, userDetails, request, response);
				}
			}		
		chain.doFilter(request, response);
	}

	
	
	/*COMMENTED OUT BECAUSE EVERYONE SHOULD ACCESS HOME PAGE
	public void Redirect(String requestURL, UserDetails userDetails, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String targetUrl = null;
		//If User/Admin is logged in, take them to their appropriate panels
		if(requestURL.toString().equals("http://localhost:8080/") || requestURL.toString().equals("http://localhost:8080")) {
		//Redirect user to appropriate destination for ROLE
	    if(userDetails.getAuthorities().toString().contains("ROLE_ADMIN")) {
	    	
	    	  targetUrl = "/admin";
	    }else {
	    	  targetUrl = "/user";
	    }
	    redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	}
	*/
}
