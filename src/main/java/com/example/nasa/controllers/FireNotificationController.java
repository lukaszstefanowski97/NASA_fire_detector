package com.example.nasa.controllers;

import com.example.nasa.entities.FireNotification;
import com.example.nasa.services.FireNotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fireNotifications")
public class FireNotificationController {

    FireNotificationService fireNotificationService;

    @GetMapping("")
    public ResponseEntity<List<FireNotification>> getAllFireNotifications() {
        List<FireNotification> fireNotificationList = fireNotificationService.getAllFireNotifications();

        return fireNotificationList.isEmpty() ? new ResponseEntity<>(fireNotificationList, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(fireNotificationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FireNotification> getFireNotificationById(@PathVariable Long id) {
        FireNotification fireNotification = fireNotificationService.getFireNotificationById(id);

        return fireNotification != null ? new ResponseEntity<>(fireNotification, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<FireNotification> addFireNotification(@RequestBody FireNotification fireNotification) {
        fireNotificationService.saveFireNotification(fireNotification);

        return new ResponseEntity<>(fireNotification, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FireNotification> editFireNotificationById(@PathVariable Long id,
                                                                     @RequestBody FireNotification fireNotification) {

        FireNotification fireNotificationEdit = fireNotificationService.editFireNotificationById(id, fireNotification);

        return fireNotificationEdit != null ? new ResponseEntity<>(fireNotificationEdit, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FireNotification> deleteFireNotificationById(@PathVariable Long id) {
        FireNotification removedFireNotification = fireNotificationService.deleteFireNotificationById(id);

        return removedFireNotification != null ? new ResponseEntity<>(removedFireNotification, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
