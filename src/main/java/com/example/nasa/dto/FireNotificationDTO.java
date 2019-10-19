package com.example.nasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireNotificationDTO {

    private Long id;

    private Float x;

    private Float y;

    private Date startDate;

    private Integer fireNotificationApproveCounter;

    private Boolean fireTeam;

    private Boolean isFire;

    private List<Long> participatedUsersId = new LinkedList<>();

    private String description;

    private String fireDepartamentDescription;

    private Boolean arePeople;

    private Boolean isWood;

    private Boolean isBuilding;

    private Boolean isElectricity;

    private Boolean isHazardousMaterial;
}
