package com.kushal.blogappapis.Security;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenHelper {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private String secret = "jwtTokenKey";

//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    private String getClaimFromToken(String token, Object getSubject) {
//    }
}
