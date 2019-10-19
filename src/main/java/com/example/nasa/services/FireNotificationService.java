package com.example.nasa.services;

import com.example.nasa.dto.FireNotificationDTO;
import com.example.nasa.entities.FireNotification;

import java.util.List;

public interface FireNotificationService {

    List<FireNotification> getAllFireNotifications();

    FireNotification getFireNotificationById(Long id);

    FireNotification deleteFireNotificationById(Long id);

    FireNotificationDTO editFireNotificationById(Long id, FireNotificationDTO fireNotificationCommand);

    FireNotification saveFireNotification(FireNotification fireNotification);

    FireNotification changeFireNotificationStatus(Long id, Boolean status);
}
