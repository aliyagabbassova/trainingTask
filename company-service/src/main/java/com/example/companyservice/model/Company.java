package com.example.companyservice.model;

import com.example.companyservice.dto.UserDto;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

import javax.persistence.Transient; // Важно!

@Data
@Entity
@Table(name = "company_db")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Для PostgreSQL
    @Column(name = "company_id")
    private Long company_id;

//    @ElementCollection
//    @CollectionTable(name = "company_employee_ids", joinColumns = @JoinColumn(name = "company_id"))
//    @Column(name = "employee_id")
    @Transient
    private List<Long> employeeId;

    @Transient
    private List<UserDto> employees;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private int budget;
}
