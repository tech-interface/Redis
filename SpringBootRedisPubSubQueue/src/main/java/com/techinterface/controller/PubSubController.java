package com.techinterface.controller;


import com.techinterface.exception.SequenceException;
import com.techinterface.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class PubSubController {
    Logger logger = LoggerFactory.getLogger(PubSubController.class);


    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ChannelTopic channelTopic;

    @PostMapping("/publish")
    public String saveProduct(@RequestBody String message)  {
        redisTemplate.convertAndSend(channelTopic.getTopic(),message);
        return "Message published to queue/topic successfully ";
    }
}
