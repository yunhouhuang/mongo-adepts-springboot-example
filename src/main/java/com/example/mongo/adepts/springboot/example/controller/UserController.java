package com.example.mongo.adepts.springboot.example.controller;

import com.coeuy.osp.mongo.adepts.model.query.QueryAdepts;
import com.coeuy.osp.mongo.adepts.service.MongoAdepts;
import com.example.mongo.adepts.springboot.example.model.document.User;
import com.example.mongo.adepts.springboot.example.model.document.UserAddress;
import com.example.mongo.adepts.springboot.example.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户API 这里直接在Controller演示
 * </p>
 *
 * @author yarnk
 * @date 2021/6/3
 */
@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    /**
     * 构造函数注入
     */
    private final MongoAdepts mongoAdepts;

    private final UserService userService;

//    @Resource
//    private MongoAdepts mongoAdepts;

    @GetMapping
    public void getById(@RequestParam Long userId){
        User user = mongoAdepts.getById(userId, User.class);
        log.info("getById {}",user);
    }

    @GetMapping("keyword")
    public void likeKeyword(@RequestParam String username){
        QueryAdepts like = new QueryAdepts().like("username", username);
        List<User> user = mongoAdepts.list(like, User.class);
        log.info("like {}",user);
    }

    @PutMapping
    public void save(@RequestBody User user){
        User save = mongoAdepts.save(user);
        log.info("save {}",save);
    }

    @PutMapping("update")
    public void update(){
        String username = "Yarnk";
        String password = "sadasdasfsaddf";
        QueryAdepts queryAdepts = new QueryAdepts().eq("username","Yarnk");
        queryAdepts.update("username",username).update("password",password);
        boolean up =  mongoAdepts.update(queryAdepts,User.class);
        log.info("update {}",up);
    }

    @PutMapping("address")
    public void  addAddress(@RequestBody UserAddress address){
        // 真实用户id根据实际情况获取
        Long userId = 1L;
        // 这里会忘子文档中新增
        QueryAdepts eq = new QueryAdepts().push("address", address).eq("userId", userId);
        mongoAdepts.update(eq,User.class);
    }

    @DeleteMapping("address")
    public void  delAddress(){
        // 真实用户id根据实际情况获取
        Long userId = 1L;
        UserAddress userAddress = new UserAddress();
        // 这里会删除 address.mobile = "123" 的子文档
        userAddress.setMobile("123");
        QueryAdepts eq = new QueryAdepts().pull("address", userAddress).eq("userId", userId);
        mongoAdepts.update(eq,User.class);
    }


    @GetMapping("service/add")
    public void serviceAdd(){
        User byId = userService.getById(1L);
        log.info("byid: {}",byId);
        User user = new User();
        user.setUserId(System.currentTimeMillis());
        user.setUsername("Yarnk");
        User user1 = userService.addUser(user);
        log.info("save: {}",user1);

    }

    @GetMapping("service/update")
    public void serviceUpdate(){
        boolean a  = userService.updateUser("Yarnk","1231231");
        User yarnk = userService.getByUsername("Yarnk");
        log.info("update: {} result: {}",a,yarnk);

    }




}
