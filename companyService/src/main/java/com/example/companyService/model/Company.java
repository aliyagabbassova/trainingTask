package com.example.companyService.model;

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
    private List<Long> employeeIds;

    @Transient
    private List<User> employees;

    @Column (nullable = false)
    private String companyName;

    @Column (nullable = false)
    private int budget;
}
