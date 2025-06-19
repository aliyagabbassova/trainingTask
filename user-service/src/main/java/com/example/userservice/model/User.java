package com.example.userservice.model;
import lombok.Data;
import org.hibernate.annotations.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Data
@Entity
@Table(name="users")
public class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column (nullable = false)
    private String lastName;
    @Column (nullable = false)
    private int phoneNumber;
    @Column (nullable = false)
    private Long idCompany;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
