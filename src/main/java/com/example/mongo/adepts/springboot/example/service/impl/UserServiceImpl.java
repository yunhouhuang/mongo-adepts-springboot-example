package com.example.mongo.adepts.springboot.example.service.impl;

import com.coeuy.osp.mongo.adepts.model.query.QueryWrapper;
import com.coeuy.osp.mongo.adepts.service.MongoService;
import com.example.mongo.adepts.springboot.example.model.document.User;
import com.example.mongo.adepts.springboot.example.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Service 继承模式
 * </p>
 *
 * @author yarnk
 * @date 2021/6/3
 */
@Service
public class UserServiceImpl extends MongoService<User> implements UserService {

    @Override
    public User getById(Long userId) {
        return getOne(new QueryWrapper().eq("userId", userId));
    }

    @Override
    public User getByUsername(String username) {
        return getOne(new QueryWrapper().eq("username", username));
    }

    @Override
    public List<User> getInUserIdList(List<Long> userIdList){
        return list(new QueryWrapper().in("userId",userIdList));
    }


    @Override
    public User addUser(User user){
        return insert(user);
    }

    @Override
    public User saveUser(User user){
        Long id = user.getUserId();
        User byId = getById(id);
        BeanUtils.copyProperties(user,byId);
        return save(byId);
    }


    @Override
    public Boolean updateUser(String username, String password){
        QueryWrapper queryWrapper = new QueryWrapper().eq("username",username);
        queryWrapper.update("username",username).update("password",password);
        return update(queryWrapper);
    }

    @Override
    public Boolean deleteUser(Long userId){
        QueryWrapper queryWrapper = new QueryWrapper().eq("userId",userId);
        return delete(queryWrapper);
    }
}
