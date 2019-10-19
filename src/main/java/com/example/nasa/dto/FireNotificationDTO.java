package com.example.nasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireNotificationDTO {

    private Long id;

    private Long reporterId;

    private Double x;

    private Double y;

    private Date startDate;

    private Integer fireNotificationApproveCounter;

    private Boolean fireTeam;

    private Boolean isFire;

    private String description;

    private String fireDepartamentDescription;

    private Boolean arePeople;

    private Boolean isWood;

    private Boolean isBuilding;

    private Boolean isElectricity;

    private Boolean isHazardousMaterial;
}
