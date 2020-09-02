package com.zayan.www.config.secure;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secretKey;

    @Value("${jwt.token.expiration}")
    private Integer defaultExpiration;

    @Value("${jwt.token.isuser}")
    private String isuser;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createTokenWithExpiration(Map<String, Object> data, Date expiration){
        Claims claims = Jwts.claims().setSubject(data.get("userId").toString());
        if (Objects.nonNull(data)) {
            claims.put("user", data);
        }
        Date now = new Date();
        if (Objects.isNull(expiration)){
            expiration = new Date(now.getTime() + defaultExpiration);
        }
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setNotBefore(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,secretKey)
                .setIssuer(isuser)
                .compact();
    }
}
