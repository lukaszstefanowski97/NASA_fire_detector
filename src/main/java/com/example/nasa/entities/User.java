package com.example.nasa.entities;

import com.example.nasa.dto.FireNotificationDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;

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

    private List<FireNotificationDTO> fireNotificationDTOList = new LinkedList<>();

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
