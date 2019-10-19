package com.example.nasa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private String password;

    private String cellPhoneNumber;

    private String email;

    private String photo;

    private Long notificationRangeInMeters;
    private Double x;

    private Double y;

    public User(String name, String surname, String password, String cellPhoneNumber, String email, String photo, Double x, Double y) {

        this.name = name;
        this.surname = surname;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.email = email;
        this.photo = photo;
        this.x = x;
        this.y = y;
    }
}
