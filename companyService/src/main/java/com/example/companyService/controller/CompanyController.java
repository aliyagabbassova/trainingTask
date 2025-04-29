package com.example.companyService.controller;

import com.example.companyService.model.Company;
import com.example.companyService.service.CompanyService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
public class CompanyController {
    private final CompanyService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Users";
    }

    @PostMapping("/create")                                //Создание пользователя
    public ResponseEntity<Company> createUser(@RequestBody Company user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping   ("/users")                                //Добавление пользователя
    public ResponseEntity<Company> addUser(@RequestBody Company user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @GetMapping                   //Просмотр всех пользователей
    public ResponseEntity<List<Company>> getAll(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getUserById(@PathVariable("id") Long id) {
        Company userById;
        try {
            userById = userService.getUserById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Company());
        }
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PutMapping("/{id}")                 //Редактирование пользователя
    public ResponseEntity<Company> updateUserById(@PathVariable("id") Long id,
                                                  @RequestBody Company user) {
        Company updatedUser;
        try {
            updatedUser = userService.updateUser(id, user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Company());
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")                      //Удаление пользователя
    public ResponseEntity <Void> deleteUser(@PathVariable ("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
