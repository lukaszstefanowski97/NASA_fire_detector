package com.example.nasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireReportDTO {

    private Long id;

    private Long reporterId;

    private Double x;

    private Double y;

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

    private byte[] photo;
}
