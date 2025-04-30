package com.example.companyService.model;

import com.example.companyService.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="company_b")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CompanyId;

    @ElementCollection
    private List<Long> employeeId;

    @Transient
    private List<UserDto> employees;

    @Column (nullable = false)
    private String companyName;

    @Column (nullable = false)
    private int budget;

}
