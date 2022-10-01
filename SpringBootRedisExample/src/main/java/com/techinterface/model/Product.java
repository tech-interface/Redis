package com.techinterface.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@RedisHash
@Builder
@AllArgsConstructor
@Getter
public class Product {

    @Id
    private int id;

    @Indexed
    private int productId;

    private String name;

    private String code;



}
