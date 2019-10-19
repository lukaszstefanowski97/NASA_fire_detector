package com.example.nasa.services;

import com.example.nasa.entities.FireReport;

public interface NotificationService {

    public void sendNotification(FireReport fireReport);
}
