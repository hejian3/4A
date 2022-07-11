package com.hj.fa.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hj.fa.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User loadUserByUsername(@Param("clientId") String clientId, @Param("username") String username);

}
