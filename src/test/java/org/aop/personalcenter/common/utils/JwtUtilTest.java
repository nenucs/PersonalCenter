package org.aop.personalcenter.common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    @Test
    void createJWT1() {
        String code = JwtUtil.createJWT("111111111123");
        System.out.println(code);
    }

    @Test
    void testCreateJWT2() {
        String code = JwtUtil.createJWT("111111111123");
        assertEquals("111111111123", JwtUtil.getClaims(code).getSubject());
    }
}