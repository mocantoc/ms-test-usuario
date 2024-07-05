package com.test.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private static final String ACCEPT_TOKEN_SECRET = "sdvjkbasdlivdsavlibsd";
    private static final Long ACCEPT_TOKEN_VALIDITY_SECOND= 2_595_000L;


    public static String createToken (String nombre , String email){

        long expirationTime = ACCEPT_TOKEN_VALIDITY_SECOND * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);


        return Jwts.builder()
                .subject(email)
                .claims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCEPT_TOKEN_SECRET.getBytes()))
                .compact();

    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token)
    {
        try{
            Claims claims = Jwts.parser().setSigningKey(ACCEPT_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null , Collections.emptyList());
        }catch (JwtException e){
            return null;
        }

    }
}

