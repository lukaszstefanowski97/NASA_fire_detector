package com.example.nasa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class FireNotification {

    @Id
    @GeneratedValue
    Long id;

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

    Boolean isReal;

    public FireNotification(Float x, Float y, Date startDate, Integer fireNotificationApproveCounter, Boolean fireTeam,
                            Boolean isFire, String description, String fireDepartamentDescription, Boolean arePeople,
                            Boolean isWood, Boolean isBuilding, Boolean isHazardousMaterial) {
        this.x = x;
        this.y = y;
        this.startDate = startDate;
        this.fireNotificationApproveCounter = fireNotificationApproveCounter;
        this.fireTeam = fireTeam;
        this.isFire = isFire;
        this.description = description;
        this.fireDepartamentDescription = fireDepartamentDescription;
        this.arePeople = arePeople;
        this.isWood = isWood;
        this.isBuilding = isBuilding;
        this.isHazardousMaterial = isHazardousMaterial;
    }
}
