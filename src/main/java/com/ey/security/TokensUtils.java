package com.ey.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokensUtils {

    //llevar a properties
    private final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";

    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(String name, String email){

        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> mapValues = new HashMap<>();
        mapValues.put("name", name);

        return Jwts.builder().setSubject(email).setExpiration(expirationDate).addClaims(mapValues)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims obj = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build().parseClaimsJws(token)
                    .getBody();

            String email = obj.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());

        } catch (JwtException e) {
            return null;
        }
    }

    public static String getEncryptedPassword(String pwd){

        return new BCryptPasswordEncoder().encode(pwd);
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode("key-to-token");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
