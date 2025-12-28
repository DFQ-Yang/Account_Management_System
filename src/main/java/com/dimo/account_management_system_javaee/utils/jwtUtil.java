package com.dimo.account_management_system_javaee.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class jwtUtil {
    private static final SecretKey key = Keys.hmacShaKeyFor("This_is_Dimo's_personal_key_with_more_than_32_bits".getBytes(StandardCharsets.UTF_8));
    private static final Long Expire = 3000L;

    //??Jwt??
    public static String buildJwt(Map<String,Object> claim){
        String jwt = Jwts.builder()
                .setClaims(claim)
                .signWith(key)
                .setExpiration(Date.from(Instant.now().plusMillis(Expire)))
                .compact();

        return jwt;
    }

    //??Jwt??
    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();

        return claims;
    }
}
