package com.example.nasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Long id;

    private String name;

    private String surname;

    private String cellPhoneNumber;

    private String email;

    private String photo;

    private Long notificationRangeInMeters;

    private Double x;

    private Double y;
}
