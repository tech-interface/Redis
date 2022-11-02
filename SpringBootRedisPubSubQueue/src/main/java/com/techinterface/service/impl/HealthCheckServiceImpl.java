package com.techinterface.service.impl;

import com.techinterface.service.HealthCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    Logger logger = LoggerFactory.getLogger(HealthCheckServiceImpl.class);
    @Override
    public String getHealthCheckStatus() {
        logger.info("HealthCheckServiceImpl ######## getHealthCheckStatus");
        return "UP: Redis Example Service ";
    }
}
