package com.example.companyservice.model;

import lombok.Data;
import org.example.UserDto;

import javax.persistence.*;
import java.util.List;

import javax.persistence.Transient; // Важно!

@Data
@Entity
@Table(name = "company_db")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "company_employee_ids", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "employee_id")
    private List<Long> employeeId;

    @Transient
    private List<UserDto> employees;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private int budget;
}
