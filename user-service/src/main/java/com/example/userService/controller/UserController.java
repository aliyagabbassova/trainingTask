package com.example.userService.controller;

import com.example.userService.model.User;
import com.example.userService.service.UserService;
import com.example.userService.service.impl.UserServiceImpl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
public class UserController {
//    private final UserService userService;

    private final UserServiceImpl userService;

    // Конструктор с аннотацией @Autowired (или просто без неё в новых версиях Spring)
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Users";
    }

    @PostMapping("/create")                                //Создание пользователя
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping   ("/users")                                //Добавление пользователя
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @GetMapping                   //Просмотр всех пользователей
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User userById;
        try {
            userById = userService.getUserById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new User());
        }
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PutMapping("/{id}")                 //Редактирование пользователя
    public ResponseEntity<User> updateUserById(@PathVariable("id") Long id,
                                               @RequestBody User user) {
        User updatedUser;
        try {
            updatedUser = userService.updateUser(id, user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new User());
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")                      //Удаление пользователя
    public ResponseEntity <Void> deleteUser(@PathVariable ("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
