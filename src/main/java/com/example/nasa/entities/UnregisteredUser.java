package com.example.nasa.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class UnregisteredUser {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private String cellPhoneNumber;

    public UnregisteredUser(String name, String surname, String cellPhoneNumber) {
        this.name = name;
        this.surname = surname;
        this.cellPhoneNumber = cellPhoneNumber;
    }
}
