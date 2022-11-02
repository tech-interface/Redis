package com.techinterface.service.impl;

import com.techinterface.controller.PubSubController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class ReadMessage implements MessageListener {

    Logger logger = LoggerFactory.getLogger(ReadMessage.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        logger.info("###### Message Received from topic is ####  "+message);
    }
}
