package com.student.sms.backend.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claim = new HashMap<>();
        return createToken(claim,userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claim, String email) {

        return Jwts.builder()
                .setClaims(claim)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60*10)) // 10 hrs expiration
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();


    }
}
