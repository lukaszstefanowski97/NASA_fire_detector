package com.example.nasa.services.impl;

import com.example.nasa.config.properties.SmsApiConfig;
import com.example.nasa.dto.UserDTO;
import com.example.nasa.entities.FireReport;
import com.example.nasa.services.NotificationService;
import com.example.nasa.services.UserService;
import com.example.nasa.utils.DistanceCalculator;
import com.example.nasa.utils.SmsApi;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final UserService userService;
    private final SmsApiConfig smsApiConfig;
    private final SmsApi smsApi;

    public void sendNotification(FireReport fireReport) {
        sendSmsToGateway(fireReport);
    }

    private void sendSmsToGateway(FireReport fireReport) {

        List<UserDTO> userDTOList = userService.getAllUsers().stream()
                .filter(userDTO -> {
                    Long distanceFromFireInMeters = DistanceCalculator.calculate(fireReport.getX(), fireReport.getY(), userDTO.getX(), userDTO.getY());
                    return userDTO.getNotificationRangeInMeters() > distanceFromFireInMeters;
                }).collect(Collectors.toList());

        String urlPost = smsApi.urlForFireLocationSms(userDTOList, fireReport.getX(), fireReport.getY());

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

        headers.add("Authorization", "Bearer " + smsApiConfig.getToken());

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request = new HttpEntity<String>("", headers);

        var response = restTemplate.postForObject(urlPost, request, Object.class);

    }

}
