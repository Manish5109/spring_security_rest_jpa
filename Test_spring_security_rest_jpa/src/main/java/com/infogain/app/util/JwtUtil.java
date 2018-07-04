/*******************************************************************************
 * Copyright (c) 2018 Infogain.
 *******************************************************************************/
package com.infogain.app.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.infogain.app.security.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Manish Kumar
 * @since Jul 3, 2018
 */
@Service
public class JwtUtil {

	/**
	 * Generate the JWT token from user.
	 * 
	 * @param user
	 * @return
	 */
	public String genToken(User user) {
		String role = null;
		for (GrantedAuthority authority : user.getAuthorities()) {
			role = authority.getAuthority();
		}

		String token = Jwts.builder().setSubject(user.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.claim("role", role).signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET).compact();
		return token;
	}

	/**
	 * Parse the JWT token
	 * 
	 * @param token
	 * @return
	 */
	public User parseToken(final String token) {
		Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
				.parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody();

		String role = (String) claims.get("role");
		String username = claims.getSubject();

		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);

		User user = new User(username, username, authorities);
		return user;
	}

}
