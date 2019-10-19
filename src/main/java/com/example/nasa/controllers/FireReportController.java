package com.example.nasa.controllers;

import com.example.nasa.dto.FireReportDTO;
import com.example.nasa.dto.UnregisteredUserDTO;
import com.example.nasa.dto.UserDTO;
import com.example.nasa.entities.FireReport;
import com.example.nasa.entities.UnregisteredUser;
import com.example.nasa.messages.FireReportMessages;
import com.example.nasa.services.FireReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fireReports")
@Slf4j
public class FireReportController {

    private final FireReportService fireReportService;

    @GetMapping("")
    public ResponseEntity<List<FireReport>> getAllFireReports() {
        List<FireReport> fireReportList = fireReportService.getAllFireReports();
        log.info(FireReportMessages.GETTING_FIRE_REPORTS);

        return fireReportList.isEmpty() ? new ResponseEntity<>(fireReportList, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(fireReportList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FireReport> getFireReportById(@PathVariable Long id) {
        FireReport fireReport = fireReportService.getFireReportById(id);
        log.info(FireReportMessages.GETTINF_FIRE_REPORT + id);

        return fireReport != null ? new ResponseEntity<>(fireReport, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<FireReportDTO> addFireReport(@RequestBody FireReportDTO fireReportDTO, UserDTO userDTO) {
        FireReport fireReport = new FireReport(fireReportDTO.getReporterId(),
                fireReportDTO.getX(), fireReportDTO.getY(),
                fireReportDTO.getStartDate(), fireReportDTO.getFireReportApproveCounter(),
                fireReportDTO.getFireTeam(), fireReportDTO.getIsFire(),
                fireReportDTO.getDescription(), fireReportDTO.getFireDepartamentDescription(),
                fireReportDTO.getArePeople(), fireReportDTO.getIsWood(),
                fireReportDTO.getIsBuilding(), fireReportDTO.getIsElectricity(),
                fireReportDTO.getIsHazardousMaterial());

        fireReport.setReporterId(userDTO.getId());
        fireReportService.saveFireReport(fireReport);

        log.info(FireReportMessages.SAVED_FIRE_REPORT + fireReport.toString());

        return new ResponseEntity<>(fireReportDTO, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<FireReportDTO> addFireReportUnregistered(@RequestBody FireReportDTO fireReportDTO,
                                                                   UnregisteredUserDTO unregisteredUserDTO) {

        FireReport fireReport = new FireReport(fireReportDTO.getReporterId(),
                fireReportDTO.getX(), fireReportDTO.getY(),
                fireReportDTO.getStartDate(), fireReportDTO.getFireReportApproveCounter(),
                fireReportDTO.getFireTeam(), fireReportDTO.getIsFire(),
                fireReportDTO.getDescription(), fireReportDTO.getFireDepartamentDescription(),
                fireReportDTO.getArePeople(), fireReportDTO.getIsWood(),
                fireReportDTO.getIsBuilding(), fireReportDTO.getIsElectricity(),
                fireReportDTO.getIsHazardousMaterial());

        UnregisteredUser unregisteredUser = new UnregisteredUser(unregisteredUserDTO.getName(),
                unregisteredUserDTO.getSurname(), unregisteredUserDTO.getCellPhoneNumber());

        fireReport.setUnregisteredReporterId(unregisteredUser.getId());
        fireReportService.saveFireReport(fireReport);

        log.info(FireReportMessages.SAVED_FIRE_REPORT_UNREGISTERED_USER + fireReport.toString());

        return new ResponseEntity<>(fireReportDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FireReportDTO> editFireReportById(@PathVariable Long id,
                                                            @RequestBody FireReportDTO fireReportDTO) {

        FireReportDTO fireReportById = fireReportService.editFireReportById(id,
                fireReportDTO);

        log.info(FireReportMessages.EDITED_FIRE_REPORT + id);

        return fireReportById != null ? new ResponseEntity<>(fireReportById, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FireReport> deleteFireReportById(@PathVariable Long id) {
        FireReport removedFireReport = fireReportService.deleteFireReportById(id);

        log.info(FireReportMessages.DELETED_FIRE_REPORT + id);

        return removedFireReport != null ? new ResponseEntity<>(removedFireReport, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}")
    public ResponseEntity<FireReport> changeFireReportStatus(@PathVariable Long id, @RequestBody Boolean status) {
        FireReport editedFireReport = fireReportService.changeFireReportStatus(id, status);

        log.info(FireReportMessages.FIRE_REPORT_STATUS_MESSAGE + id + " " + status);

        return editedFireReport != null ? new ResponseEntity<>(editedFireReport, HttpStatus.OK) :
                ResponseEntity.notFound().build();
    }
}
