package com.example.userservice.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class CompanyDto {
    private Long id;
    private String companyName;
    private List<UserDto> users;
}


