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

    private Integer cellPhoneNumber;

    private String email;

    private String photo;

    public User(String name, String surname, String password, Integer cellPhoneNumber, String email, String photo) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.email = email;
        this.photo = photo;
    }
}
