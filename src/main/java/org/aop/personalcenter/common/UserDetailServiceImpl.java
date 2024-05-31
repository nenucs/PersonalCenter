package org.aop.personalcenter.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.aop.personalcenter.common.mapper.UserMapper;
import org.aop.personalcenter.common.model.LoginUser;
import org.aop.personalcenter.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserId, username);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(user);
        return loginUser;
    }
}
