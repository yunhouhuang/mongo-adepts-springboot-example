package com.example.mongo.adepts.springboot.example.model.document;

import lombok.Data;

/**
 * <p>
 *  用户地址信息
 * </p>
 *
 * @author yarnk
 * @date 2021/6/3
 */
@Data
public class UserAddress {

    private String mobile;

    private String name;

    private String address;

}
