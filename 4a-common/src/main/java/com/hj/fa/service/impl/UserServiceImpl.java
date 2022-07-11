package com.hj.fa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hj.fa.dao.mapper.*;
import com.hj.fa.model.*;
import com.hj.fa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PrivilegesMapper privilegesMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserToRoleMapper userToRoleMapper;

    @Autowired
    private RoleToPrivilegesMapper roleToPrivilegesMapper;

    @Override
    public List<Privileges> getUserPrivileges(String clientId, String username) {
        Role role = getRoleByUserName(clientId, username);
        return getUserPrivileges(role);
    }

    @Override
    public List<Privileges> getUserPrivileges(User user) {
        Role role = getRole(user);
        return getUserPrivileges(role);
    }

    @Override
    public List<Privileges> getUserPrivileges(Role role) {
        LambdaQueryWrapper<RoleToPrivileges> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleToPrivileges::getRoleId, role.getRoleId());
        List<RoleToPrivileges> roleToPrivileges = roleToPrivilegesMapper.selectList(queryWrapper);
        return privilegesMapper.selectBatchIds(roleToPrivileges.stream().map(RoleToPrivileges::getPrivilegeId).collect(Collectors.toList()));
    }

    @Override
    public User getUserByUserName(String clientId, String username) {
        return userMapper.loadUserByUsername(clientId, username);
    }

    @Override
    public Role getRoleByUserName(String clientId, String username) {
        User user = getUserByUserName(clientId, username);
        return getRole(user);
    }

    @Override
    public Role getRole(User user) {
        LambdaQueryWrapper<UserToRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserToRole::getUserId, user.getUserId());
        UserToRole userToRole = userToRoleMapper.selectOne(queryWrapper);
        return roleMapper.selectById(userToRole.getRoleId());
    }
}
