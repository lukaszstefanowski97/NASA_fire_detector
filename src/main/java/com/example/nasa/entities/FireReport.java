package com.example.nasa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class FireReport {

    @Id
    @GeneratedValue
    private Long id;

    private Long reporterId;

    private Long unregisteredReporterId;

    private Double x;

    private Double y;

    @CreationTimestamp
    private Date startDate;

    private Integer fireReportApproveCounter;

    private Boolean fireTeam;

    private Boolean isActiveFire;

    private String description;

    private String fireDepartamentDescription;

    private Boolean arePeople;

    private Boolean isWood;

    private Boolean isBuilding;

    private Boolean isElectricity;

    private Boolean isHazardousMaterial;

    private Boolean isReal;

    private byte[] photo;

    private String address;

    public FireReport(Long reporterId, Double x, Double y, Date startDate, Integer fireReportApproveCounter,
                      Boolean fireTeam, Boolean isActiveFire, String description, String fireDepartamentDescription,
                      Boolean arePeople, Boolean isWood, Boolean isBuilding, Boolean isElectricity,
                      Boolean isHazardousMaterial, byte[] photo, String address) {
        this.reporterId = reporterId;
        this.x = x;
        this.y = y;
        this.startDate = startDate;
        this.fireReportApproveCounter = fireReportApproveCounter;
        this.fireTeam = fireTeam;
        this.isActiveFire = isActiveFire;
        this.description = description;
        this.fireDepartamentDescription = fireDepartamentDescription;
        this.arePeople = arePeople;
        this.isWood = isWood;
        this.isBuilding = isBuilding;
        this.isElectricity = isElectricity;
        this.isHazardousMaterial = isHazardousMaterial;
        this.photo = photo;
        this.address = address;
    }
}
