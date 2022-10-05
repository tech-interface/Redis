package com.techinterface.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;


@RedisHash
@Builder
@AllArgsConstructor
@Getter
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @Indexed
    private int productId;

    private String name;

    private String code;



}
