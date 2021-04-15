package com.example.SimpleTaksPraksa.service;

import com.example.SimpleTaksPraksa.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret = "secretKey";

    public String generateJWT(User user){
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, user);
    }

    public String doGenerateToken(Map<String, Object> claims, User user){
        return Jwts.builder().setClaims(claims).setId(user.getId().toString()).setSubject("USER").setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
}
