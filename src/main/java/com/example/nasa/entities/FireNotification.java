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

    private Boolean isReal;

    public FireNotification(Long reporterId, Double x, Double y, Date startDate, Integer fireNotificationApproveCounter,
                            Boolean fireTeam, Boolean isFire, String description, String fireDepartamentDescription,
                            Boolean arePeople, Boolean isWood, Boolean isBuilding, Boolean isElectricity,
                            Boolean isHazardousMaterial) {
        this.reporterId = reporterId;
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
        this.isElectricity = isElectricity;
        this.isHazardousMaterial = isHazardousMaterial;
    }
}
