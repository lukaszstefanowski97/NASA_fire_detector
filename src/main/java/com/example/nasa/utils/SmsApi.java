package com.example.nasa.utils;

import com.example.nasa.config.properties.SmsApiConfig;
import com.example.nasa.dto.UserDTO;
import com.example.nasa.entities.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class SmsApi {

    private SmsApiConfig smsApiConfig;

    public String urlForFireLocationSms(List<UserDTO> userListInRange, Double fireLat, Double fireLong) {

        StringBuilder responseBuilder = new StringBuilder();

        responseBuilder.append(smsApiConfig.getUrl()).append("?");
        responseBuilder.append("from=").append(smsApiConfig.getUserField()).append("&");
        responseBuilder.append("to=");
        responseBuilder.append(userListInRange.stream()
                .map(user -> {
                    if (user.getCellPhoneNumber().contains("+")) {
                        return user.getCellPhoneNumber().substring(1);
                    }
                    return user.getCellPhoneNumber();
                }).collect(Collectors.joining(",")));
        responseBuilder.append("&");
        responseBuilder.append("message=").append("Fire is on location: ");
        responseBuilder.append("http://www.google.com/maps/place/").append(fireLat).append(",").append(fireLong);
        responseBuilder.append("&");
        responseBuilder.append("format=json");
        String response = responseBuilder.toString();

        log.info("SMS response: " + response);
        return response;
    }

}
