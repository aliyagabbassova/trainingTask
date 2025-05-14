package com.example.companyService.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private Long idCompany;
}
