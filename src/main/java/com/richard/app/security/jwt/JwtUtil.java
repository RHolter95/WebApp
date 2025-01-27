package com.richard.app.security.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String SECRET_KEY = "secret";
	public int EXPIRATIONTIME = 1000 * 60 * 60 * 10;
	
	public String extractUsername(String token) {
		return exctractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return exctractClaim(token, Claims::getExpiration);
	}
	
	public <T> T exctractClaim(String token, Function<Claims, T> ClaimsResolver) {
		final Claims claims = extractAllClaims(token);
		return ClaimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims,userDetails.getUsername());	
	}
	
	 private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	 }
	 
	 public boolean validateToken(String token, UserDetails userDetails) {
		 final String username = extractUsername(token);
		 return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	 }
	 
	
	
	
}
