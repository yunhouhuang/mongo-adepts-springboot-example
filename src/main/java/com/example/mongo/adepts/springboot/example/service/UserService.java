package com.example.mongo.adepts.springboot.example.service;


import com.example.mongo.adepts.springboot.example.model.document.User;

import java.util.List;

/**
 * <p>
 * Service模式
 * </p>
 *
 * @author yarnk
 * @date 2021/6/3
 */
public interface UserService {

    /**
     * 根据ID查询
     * @param userId 用户ID
     * @return User
     */
    User getById(Long userId);

    /**
     * 根据 其他条件查询
     * @param username 用户名
     * @return User
     */
    User getByUsername(String username);

    /**
     * 根据ID IN 查询
     * @param userIdList ID集合
     * @return 用户LIST
     */
    List<User> getInUserIdList(List<Long> userIdList);

    /**
     * 新增一个用户
     * @param user user
     * @return User
     */
    User addUser(User user);

    /**
     * 保存用户，注意：这里会直接保存所有字段，即使你的字段为null
     * @param user  user
     * @return 保存成功的User
     */
    User saveUser(User user);

    /**
     * 跟新指定字段
     * @param username 用户名
     * @param password 密码
     * @return result
     */
    Boolean updateUser( String username, String password);

    /**
     * 根据id删除用户（真实删除）
     * @param userId id
     * @return result
     */
    Boolean deleteUser(Long userId);
}
