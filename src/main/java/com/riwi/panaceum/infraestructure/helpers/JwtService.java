package com.riwi.panaceum.infraestructure.helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.riwi.panaceum.domain.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
    private static final String SECRET_KEY = "";

    public SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getToken(Map<String, Object> claims, User user){
        return Jwts.builder()
                .claims(claims)
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(this.getKey())
                .compact();
    }

    public String getToken(User user){
        Map<String, Object> claims = new HashMap<>();

        claims.put("id", user.getId());
        claims.put("role", user.getRole().name());

        return this.getToken(claims, user);
    }

    public Claims getAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(this.getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = this.getAllClaims(token);

        return claimsResolver.apply(claims);
    }

    public String getUsernameFromToken(String token){
        return this.getClaim(token, Claims::getSubject);
    }

    public Date getExpiration(String token){
        return this.getClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token){
        return this.getExpiration(token).before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        String userEmail = this.getUsernameFromToken(token);

        return (userEmail.equals(userDetails.getUsername()) && !this.isTokenExpired(token));
    }
}

