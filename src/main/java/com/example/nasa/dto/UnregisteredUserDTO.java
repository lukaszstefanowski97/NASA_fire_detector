package com.example.nasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnregisteredUserDTO {

    private String name;

    private String surname;

    private String cellPhoneNumber;
}
