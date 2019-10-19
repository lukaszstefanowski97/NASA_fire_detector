package com.example.nasa.services.impl;

import com.example.nasa.dto.FireReportDTO;
import com.example.nasa.entities.FireReport;
import com.example.nasa.repositories.FireReportRepository;
import com.example.nasa.services.FireReportService;
import com.example.nasa.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FireReportServiceImpl implements FireReportService {

    private final FireReportRepository fireReportRepository;
    private final NotificationService notificationService;

    @Override
    public List<FireReport> getAllFireReports() {
        return fireReportRepository.findAll();
    }

    @Override
    public FireReport getFireReportById(Long id) {
        Optional<FireReport> fireReport = fireReportRepository.findById(id);

        return fireReport.orElse(null);
    }

    @Override
    public FireReport deleteFireReportById(Long id) {
        Optional<FireReport> fireReport = fireReportRepository.findById(id);

        if (fireReport.isPresent()) {
            fireReportRepository.deleteById(id);
            return fireReport.get();
        }

        return null;
    }

    @Override
    public FireReportDTO editFireReportById(Long id, FireReportDTO fireReportDTO) {
        Optional<FireReport> fireReport = fireReportRepository.findById(id);

        if (fireReport.isPresent()) {
            fireReportRepository.deleteById(id);
            fireReportRepository.save(new FireReport(fireReportDTO.getReporterId(),
                    fireReportDTO.getX(), fireReportDTO.getY(),
                    fireReportDTO.getStartDate(), fireReportDTO.getFireReportApproveCounter(),
                    fireReportDTO.getFireTeam(), fireReportDTO.getIsActiveFire(),
                    fireReportDTO.getDescription(), fireReportDTO.getFireDepartamentDescription(),
                    fireReportDTO.getArePeople(), fireReportDTO.getIsWood(),
                    fireReportDTO.getIsBuilding(), fireReportDTO.getIsElectricity(),
                    fireReportDTO.getIsHazardousMaterial(), fireReportDTO.getPhoto(),
                    fireReportDTO.getAddress()));

            return fireReportDTO;
        }

        return null;
    }

    @Override
    public FireReport saveFireReport(FireReport fireReport) {
        notificationService.sendNotification(fireReport);
        return fireReportRepository.save(fireReport);
    }

    @Override
    public FireReport changeFireReportStatus(Long id, Boolean status) {
        Optional<FireReport> fireReport = fireReportRepository.findById(id);

        if (fireReport.isPresent()) {
            FireReport fn = fireReport.get();
            fn.setIsReal(status);
            return fireReportRepository.save(fn);
        }

        return null;
    }
}
