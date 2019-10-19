package com.example.nasa.entities;

import com.example.nasa.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FireNotification {

    @Id
    @GeneratedValue
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

    private Boolean isReal;

    public FireNotification(Float x, Float y, Date startDate, Integer fireNotificationApproveCounter, Boolean fireTeam,
                            Boolean isFire, List<Long> participatedUsersId, String description,
                            String fireDepartamentDescription,
                            Boolean arePeople, Boolean isWood, Boolean isBuilding, Boolean isElectricity,
                            Boolean isHazardousMaterial) {
        this.x = x;
        this.y = y;
        this.startDate = startDate;
        this.fireNotificationApproveCounter = fireNotificationApproveCounter;
        this.fireTeam = fireTeam;
        this.isFire = isFire;
        this.participatedUsersId = participatedUsersId;
        this.description = description;
        this.fireDepartamentDescription = fireDepartamentDescription;
        this.arePeople = arePeople;
        this.isWood = isWood;
        this.isBuilding = isBuilding;
        this.isElectricity = isElectricity;
        this.isHazardousMaterial = isHazardousMaterial;
    }
}
