package com.hj.fa.service;

import com.hj.fa.model.Privileges;
import com.hj.fa.model.Role;
import com.hj.fa.model.User;

import java.util.List;

public interface IUserService {

    /**
     * 获取用户权限
     *
     * @param username
     * @return
     */
    List<Privileges> getUserPrivileges(String clientId, String username);

    /**
     * 获取用户权限
     * @param user
     * @return
     */
    List<Privileges> getUserPrivileges(User user);

    /**
     * 获取用户权限
     * @param role
     * @return
     */
    List<Privileges> getUserPrivileges(Role role);

    /**
     * 获取用户
     *
     * @param username
     * @return
     */
    User getUserByUserName(String clientId, String username);

    /**
     * 获取角色
     * @param clientId
     * @param username
     * @return
     */
    Role getRoleByUserName(String clientId, String username);

    /**
     * 获取角色
     * @param user
     * @return
     */
    Role getRole(User user);

}
