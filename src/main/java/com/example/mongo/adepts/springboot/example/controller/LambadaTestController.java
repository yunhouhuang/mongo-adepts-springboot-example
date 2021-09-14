package com.example.mongo.adepts.springboot.example.controller;

import com.coeuy.osp.mongo.adepts.model.query.Adepts;
import com.coeuy.osp.mongo.adepts.model.query.LambdaQueryAdepts;
import com.coeuy.osp.mongo.adepts.model.query.QueryWrapper;
import com.coeuy.osp.mongo.adepts.service.MongoAdepts;
import com.example.mongo.adepts.springboot.example.model.document.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Explain
 * </p>
 *
 * @author yarnk
 * @date 2021/9/9
 */
@RestController
@RequiredArgsConstructor
public class LambadaTestController {

    private final MongoAdepts mongoAdepts;

    @GetMapping("lambada/{username}")
    public String lamb(@PathVariable String username){
        User superman = mongoAdepts.getOne(Adepts.<User>lambdaQuery().eq(User::getUsername, username), User.class);
        return superman.toString();
    }
}
