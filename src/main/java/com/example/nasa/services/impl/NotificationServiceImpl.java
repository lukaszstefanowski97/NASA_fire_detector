package com.example.nasa.services.impl;

import com.example.nasa.entities.FireReport;
import com.example.nasa.services.NotificationService;
import com.example.nasa.services.UserService;
import com.example.nasa.utils.DistanceCalculator;
import com.example.nasa.utils.SmsApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final UserService userService;

    public void sendNotification(FireReport fireReport){
        sendSmsToGateway(fireReport);
    }

    private void sendSmsToGateway(FireReport fireReport){
        SmsApi smsApi = new SmsApi();

        userService.getAllUsers().stream()
                .map(userDTO -> {
                    DistanceCalculator.calculate(fireReport.getY(),fireReport.getX(),userDTO.get)
                })





    }

    private Boolean is

}
