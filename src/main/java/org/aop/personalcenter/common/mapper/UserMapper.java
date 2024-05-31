package org.aop.personalcenter.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.aop.personalcenter.common.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User queryUserById(@Param(value = "userId") String userId);
}
