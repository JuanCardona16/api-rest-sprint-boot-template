package template.API_REST.modules.authentication.helpers.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtConfig {

    // JWT constants
    @Value("${JWT_SECRET}")
    private String TOKEN_SECRET;
    private static final long EXPIRATION_TIME = 900_000; // 15 minutos

    static SecretKey key;

    @PostConstruct
    public void init() {
        if (TOKEN_SECRET == null || TOKEN_SECRET.length() < 32) {
            throw new IllegalStateException("El secreto JWT debe tener al menos 256 bits");
        }

        // Decodificar la clave base64
        byte[] keyBytes = Base64.getDecoder().decode(TOKEN_SECRET);

        if (keyBytes.length < 32) {
            throw new IllegalStateException("El secreto JWT debe tener al menos 256 bits");
        }

        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public Claims verifyToken(String token) throws SignatureException {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
