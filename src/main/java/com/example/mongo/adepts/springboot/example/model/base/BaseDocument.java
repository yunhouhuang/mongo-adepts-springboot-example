package com.example.mongo.adepts.springboot.example.model.base;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 文档基础类
 * </p>
 *
 * @author yarnk
 * @date 2021/6/3
 */
@Data
public class BaseDocument {

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private Boolean deleted;
}
