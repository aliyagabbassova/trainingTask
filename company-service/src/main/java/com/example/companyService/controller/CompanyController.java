package com.example.companyService.controller;

import com.example.companyService.dto.UserDto;
import com.example.companyService.model.Company;
import com.example.companyService.service.CompanyService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Data
public class CompanyController {

    private final CompanyService companyService;
    private final RestTemplate restTemplate;

    @GetMapping("/company/user/{userId}")
    public ResponseEntity<UserDto> getUserFromUserService(@PathVariable Long userId) {
        String url = "http://user-service/users/" + userId;
        UserDto user = restTemplate.getForObject(url, UserDto.class);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/company")
    public String hello() {
        return "Companies";
    }

    @PostMapping("/create")                                //Создание пользователя
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return new ResponseEntity<>(companyService.createCompany(company), HttpStatus.CREATED);
    }

    @PostMapping   ("/company")                                //Добавление пользователя
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return new ResponseEntity<>(companyService.addCompany(company), HttpStatus.OK);
    }

    @GetMapping                   //Просмотр всех пользователей
    public ResponseEntity<List<Company>> getAll(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
        Company companyById;
        try {
            companyById = companyService.getCompanyById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Company());
        }
        return new ResponseEntity<>(companyById, HttpStatus.OK);
    }

    @PutMapping("/company/{id}")                 //Редактирование пользователя
    public ResponseEntity<Company> updateCompanyById(@PathVariable("id") Long id,
                                               @RequestBody Company user) {
        Company updatedCompany;
        try {
            updatedCompany = companyService.updateCompany(id, user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Company());
        }
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }


    @DeleteMapping("/company/{id}")                     //Удаление пользователя
    public ResponseEntity <Void> deleteCompany(@PathVariable ("id") Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}
