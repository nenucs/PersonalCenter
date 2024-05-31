package org.aop.personalcenter;

import org.aop.personalcenter.common.mapper.UserMapper;
import org.aop.personalcenter.common.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testUserMapperById() {
        User user = userMapper.queryUserById("lyz");
        System.out.println(user);
    }
}
