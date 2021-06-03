package com.example.mongo.adepts.springboot.example.model.document;

import com.example.mongo.adepts.springboot.example.model.base.BaseDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>
 * Explain
 * </p>
 *
 * @author yarnk
 * @date 2021/6/3
 */
@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDocument {

    @Id
    private Long userId;

    /**
     * 唯一索引
     */
    @Indexed(unique = true)
    private String username;

    private String password;

    private UserAddress address;

}
