package com.example.companyservice.model;

import com.example.companyservice.dto.UserDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="company_db")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CompanyId;

    @ElementCollection
    private List<Long> employeeId;

    @Transient
    private List<UserDto> employees;

    @Column(nullable = false)
    private String firstName;

    @Column (nullable = false)
    private String companyName;

    @Column (nullable = false)
    private int budget;
    @javax.persistence.Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
