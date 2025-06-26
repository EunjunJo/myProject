package com.example.demo.global.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간
    private final String SECRET_KEY = "YourSecretKeyMustBeLongEnoughForHS256ToworkProperly!";
    
    // 블랙리스트 (실제 프로덕션에서는 Redis 사용 권장)
    private final Set<String> blacklistedTokens = ConcurrentHashMap.newKeySet();

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(getSignKey(), SignatureAlgorithm.HS256)
            .compact();
    }
    
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }
    
    public boolean validateToken(String token) {
        try {
            // 블랙리스트 체크
            if (blacklistedTokens.contains(token)) {
                return false;
            }
            
            Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token);
            return true;
        }
        catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
    
    // 토큰을 블랙리스트에 추가
    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }
    
    // 블랙리스트에서 토큰 제거 (선택사항)
    public void removeFromBlacklist(String token) {
        blacklistedTokens.remove(token);
    }
}