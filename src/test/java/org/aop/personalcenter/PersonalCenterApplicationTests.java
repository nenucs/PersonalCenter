package org.aop.personalcenter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class PersonalCenterApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(UUID.randomUUID().toString().length());
    }

}
