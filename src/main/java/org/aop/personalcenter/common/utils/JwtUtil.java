package org.aop.personalcenter.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    // 1 hour
    public static final Long JWT_TTL = 60 * 60 * 1000L;

    public static final String JWT_KEY = "PersonalCenter";

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String createJWT(String subject, Long ttl) {
        JwtBuilder jwtBuilder = getJwtBuilder(subject, ttl);
        return jwtBuilder.compact();
    }

    public static String createJWT(String subject) {
        JwtBuilder jwtBuilder = getJwtBuilder(subject, null);
        return jwtBuilder.compact();
    }

    /**
     * 生成加密后的密钥
     *
     * @return 密钥
     */
    public static SecretKey getSecretKey() {
        byte[] encodeKey = Base64.getDecoder().decode(JWT_KEY);
        return new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttl) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = getSecretKey();

        long now = System.currentTimeMillis();
        Date nowDate = new Date(now);

        if (ttl == null) {
            ttl = JWT_TTL;
        }
        long exp = now + ttl;
        Date expDate = new Date(exp);
        return Jwts.builder()
                .setId(getUUID())
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .setExpiration(expDate)
                .signWith(signatureAlgorithm, secretKey)
                .setSubject(subject);
    }

    public static Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }
}
