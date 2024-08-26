package com.kraft.event.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${secret.key}")
    private String SECRET_KEY;
    @Value("${access.token.expiration}")
    private Long accessTokenExpiration;
    @Value("${refresh.token.expiration}")
    private Long refreshTokenExpiration;



//    extract claims of user section

    public String extractUserName(String jwt){
        return extractClaim(jwt,Claims::getSubject);
    }

    private <T>T extractClaim(String token, Function<Claims,T> claimsResolver){
        final var claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigingKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigingKey(){
        var keyByte = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }



//    token generation section

    public String generateAccessToken(Map<String ,Object>claims,UserDetails userDetails){
        return buildToken(claims,userDetails,accessTokenExpiration);
    }

    public String generateAccessToken(UserDetails userDetails){
        return generateAccessToken(new HashMap<>(),userDetails);
    }

    public String generateRefreshToken(Map<String ,Object>claims,UserDetails userDetails){
        return buildToken(claims,userDetails,refreshTokenExpiration);
    }

    public String generateRefreshToken(UserDetails userDetails){
        return generateRefreshToken(new HashMap<>(),userDetails);
    }

    private String buildToken(Map<String ,Object> claims, UserDetails userDetails,Long expiration){
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigingKey())
                .compact();
    }


//    token validation section

    public boolean validateToken(String token, UserDetails userDetails){
        var userName = extractUserName(token);
        return (userDetails.getUsername().equals(userName)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

}
