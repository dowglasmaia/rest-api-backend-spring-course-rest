package com.maia.course.security;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtManager {

	public String createToken(String email, List<String> roles) {		
		Calendar calendar = Calendar.getInstance(); // Data Autal
		calendar.add(Calendar.DAY_OF_MONTH, SecurityConstants.JWT_EXP_DAYS);
		
		String jwt = Jwts.builder()
					.setSubject(email)
					.setExpiration(calendar.getTime())
					.claim(SecurityConstants.JWT_ROLE_KEY, roles)
					.signWith(SignatureAlgorithm.HS512, SecurityConstants.API_KEY.getBytes())
					.compact();		
		return jwt;
	}
	
	
	// validando RETORNA O PLAYLOAD	
	public Claims parseToken(String jtw) throws JwtException {
		Claims claims = Jwts.parser()
				.setSigningKey(SecurityConstants.API_KEY.getBytes())
				.parseClaimsJws(jtw)
				.getBody();		
		return claims;
	}
	
	
		
}
