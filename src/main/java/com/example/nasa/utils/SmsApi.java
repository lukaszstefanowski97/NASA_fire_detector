package com.example.nasa.utils;

import com.example.nasa.config.properties.SmsApiConfig;
import com.example.nasa.dto.UserDTO;
import com.example.nasa.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        responseBuilder.append("GOOGLE fire LOCATION: lat:").append(fireLat).append(" long: ").append(fireLong); //FIXME add google fire link
        responseBuilder.append("&");
        responseBuilder.append("format=json");

        return responseBuilder.toString();
    }

}
