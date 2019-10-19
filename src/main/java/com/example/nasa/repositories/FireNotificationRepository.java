package com.example.nasa.repositories;

import com.example.nasa.entities.FireNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireNotificationRepository extends JpaRepository<FireNotification, Long> {
}
