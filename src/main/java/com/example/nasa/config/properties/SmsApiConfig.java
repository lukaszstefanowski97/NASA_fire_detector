package com.example.nasa.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "sms")
public class SmsApiConfig {
    private String token;
    private String url;
    private String userField;
}
