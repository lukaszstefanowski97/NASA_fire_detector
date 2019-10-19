package com.example.nasa.repositories;

import com.example.nasa.entities.FireReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireReportRepository extends JpaRepository<FireReport, Long> {

}
