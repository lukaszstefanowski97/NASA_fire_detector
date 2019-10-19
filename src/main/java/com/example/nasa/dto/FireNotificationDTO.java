package com.example.nasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireNotificationDTO {

    Float x;

    Float y;

    Date startDate;

    Integer fireNotificationApproveCounter;

    Boolean fireTeam;

    Boolean isFire;

    String description;

    String fireDepartamentDescription;

    Boolean arePeople;

    Boolean isWood;

    Boolean isBuilding;

    Boolean isHazardousMaterial;
}
