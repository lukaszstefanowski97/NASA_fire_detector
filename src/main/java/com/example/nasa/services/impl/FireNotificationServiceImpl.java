package com.example.nasa.services.impl;

import com.example.nasa.dto.FireNotificationDTO;
import com.example.nasa.entities.FireNotification;
import com.example.nasa.repositories.FireNotificationRepository;
import com.example.nasa.services.FireNotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FireNotificationServiceImpl implements FireNotificationService {

    private final FireNotificationRepository fireNotificationRepository;

    @Override
    public List<FireNotification> getAllFireNotifications() {
        return fireNotificationRepository.findAll();
    }

    @Override
    public FireNotification getFireNotificationById(Long id) {
        Optional<FireNotification> fireNotification = fireNotificationRepository.findById(id);

        return fireNotification.orElse(null);
    }

    @Override
    public FireNotification deleteFireNotificationById(Long id) {
        Optional<FireNotification> fireNotification = fireNotificationRepository.findById(id);

        if (fireNotification.isPresent()) {
            fireNotificationRepository.deleteById(id);
            return fireNotification.get();
        }

        return null;
    }

    @Override
    public FireNotificationDTO editFireNotificationById(Long id, FireNotificationDTO fireNotificationCommand) {
        Optional<FireNotification> fireNotification = fireNotificationRepository.findById(id);

        if (fireNotification.isPresent()) {
            fireNotificationRepository.deleteById(id);
            fireNotificationRepository.save(new FireNotification(fireNotificationCommand.getX(),
                    fireNotificationCommand.getY(), fireNotificationCommand.getStartDate(),
                    fireNotificationCommand.getFireNotificationApproveCounter(),
                    fireNotificationCommand.getFireTeam(), fireNotificationCommand.getIsFire(),
                    fireNotificationCommand.getDescription(), fireNotificationCommand.getFireDepartamentDescription()
                    , fireNotificationCommand.getArePeople(), fireNotificationCommand.getIsWood(),
                    fireNotificationCommand.getIsBuilding(), fireNotificationCommand.getIsHazardousMaterial()));
            return fireNotificationCommand;
        }

        return null;
    }

    @Override
    public FireNotification saveFireNotification(FireNotification fireNotification) {
        fireNotificationRepository.save(fireNotification);
        return fireNotification;
    }
}
