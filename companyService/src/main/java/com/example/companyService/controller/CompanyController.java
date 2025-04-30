package com.example.companyService.controller;

import com.example.companyService.dto.UserDto;
import com.example.companyService.model.Company;
import com.example.companyService.service.CompanyService;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Data
public class CompanyController {
    private final CompanyService userService;
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    private final RestTemplate restTemplate;

    @GetMapping("/company/user/{userId}")
    public ResponseEntity<UserDto> getUserFromUserService(@PathVariable Long userId) {
        String url = "http://user-service/users/" + userId;
        UserDto user = restTemplate.getForObject(url, UserDto.class);
        return ResponseEntity.ok(user);
    }
}
