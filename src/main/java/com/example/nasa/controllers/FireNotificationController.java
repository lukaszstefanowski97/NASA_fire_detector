package com.example.nasa.controllers;

import com.example.nasa.dto.FireNotificationDTO;
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

    private final FireNotificationService fireNotificationService;

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
    public ResponseEntity<FireNotificationDTO> addFireNotification(@RequestBody FireNotificationDTO fireNotificationCommand) {
        fireNotificationService.saveFireNotification(new FireNotification(fireNotificationCommand.getX(),
                fireNotificationCommand.getY(), fireNotificationCommand.getStartDate(),
                fireNotificationCommand.getFireNotificationApproveCounter(), fireNotificationCommand.getFireTeam(),
                fireNotificationCommand.getIsFire(), fireNotificationCommand.getParticipatedUsersId(),
                fireNotificationCommand.getDescription(),
                fireNotificationCommand.getFireDepartamentDescription(), fireNotificationCommand.getArePeople(),
                fireNotificationCommand.getIsWood(), fireNotificationCommand.getIsBuilding(),
                fireNotificationCommand.getIsElectricity(), fireNotificationCommand.getIsHazardousMaterial()));

        return new ResponseEntity<>(fireNotificationCommand, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FireNotificationDTO> editFireNotificationById(@PathVariable Long id,
                                                                     @RequestBody FireNotificationDTO fireNotificationCommand) {

        FireNotificationDTO fireNotificationEdit = fireNotificationService.editFireNotificationById(id,
                fireNotificationCommand);

        return fireNotificationEdit != null ? new ResponseEntity<>(fireNotificationEdit, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FireNotification> deleteFireNotificationById(@PathVariable Long id) {
        FireNotification removedFireNotification = fireNotificationService.deleteFireNotificationById(id);

        return removedFireNotification != null ? new ResponseEntity<>(removedFireNotification, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}")
    public ResponseEntity<FireNotification> changeFireNotificationStatus(@PathVariable Long id, @RequestBody Boolean status){
        FireNotification editedFireNotification = fireNotificationService.changeFireNotificationStatus(id, status);

        return editedFireNotification != null ? new ResponseEntity<>(editedFireNotification, HttpStatus.OK) :
                ResponseEntity.notFound().build();
    }
}
