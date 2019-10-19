package com.example.nasa.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FireUnregisteredUserReportDOT {

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

    private String address;

    private String userName;

    private String userSurname;

    private String userCellPhoneNumber;
}
