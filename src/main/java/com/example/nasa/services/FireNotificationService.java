package com.example.nasa.services;

import com.example.nasa.entities.FireNotification;

import java.util.List;

public interface FireNotificationService {

    List<FireNotification> getAllFireNotifications();

    FireNotification getFireNotificationById(Long id);

    FireNotification deleteFireNotificationById(Long id);

    FireNotification editFireNotificationById(Long id, FireNotification fireNotificationCommand);

    FireNotification saveFireNotification(FireNotification fireNotification);
}
