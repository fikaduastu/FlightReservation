package edu.miu.cs.cs544.util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class JwtUtil {

    public static final String JWT_SECRET = "ARnoCmsxIV7mtocGRE3rSOvuo0L1iSnaJI7tbTANJ0r8CFwuLyaE9t_MBkAuAmNIefALGpG0n8ErMeNanjTNATIgv3j9ssqsOycLwj-sdAt";
    public String generateToken(Authentication authentication) {
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        String token = Jwts.builder().signWith(Keys.hmacShaKeyFor(JWT_SECRET.
                        getBytes()), SignatureAlgorithm.HS512)
                .setHeaderParam("type", "JWT")
                .setIssuer("secure-api")
                .setAudience("secure-app")
                .setSubject(authentication.getName())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 60 * 24 * 7))
                .claim("role", roles).compact();
        return "Bearer " + token;
    }
}