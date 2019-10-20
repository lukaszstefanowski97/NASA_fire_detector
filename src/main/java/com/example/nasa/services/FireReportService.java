package com.example.nasa.services;

import com.example.nasa.dto.FireReportDTO;
import com.example.nasa.entities.FireReport;

import java.util.List;

public interface FireReportService {

    List<FireReport> getAllFireReports();

    FireReport getFireReportById(Long id);

    FireReport deleteFireReportById(Long id);

    FireReportDTO editFireReportById(Long id, FireReportDTO fireReportDTO);

    FireReport saveFireReport(FireReport fireReport);

    FireReport changeFireReportStatus(Long id, Boolean status);

    FireReport incrementFireReportApproveCounter(Long id);
}
