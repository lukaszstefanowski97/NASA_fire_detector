package com.example.nasa.config;

import com.example.nasa.config.properties.SmsApiConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        SmsApiConfig.class
})
public class Config {

}
