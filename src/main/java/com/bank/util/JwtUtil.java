package com.bank.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.bank.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private String SECRET_KEY = "tYrQ@058!";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token,
			Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token)
				.getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, user.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		Calendar issuedCalendar = Calendar.getInstance();
		Calendar expiredCalendar = Calendar.getInstance();
		expiredCalendar.setTime(issuedCalendar.getTime());
		expiredCalendar.add(Calendar.HOUR, 2);

		return Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(issuedCalendar.getTime())
				.setExpiration(expiredCalendar.getTime())
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername())
				&& !isTokenExpired(token));
	}
}