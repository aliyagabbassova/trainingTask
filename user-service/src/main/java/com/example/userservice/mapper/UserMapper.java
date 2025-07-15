package com.example.userservice.mapper;


import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
//        dto.setPhoneNumber(String.valueOf(Integer.parseInt(user.getPhoneNumber())));
        dto.setPhoneNumber(String.valueOf((user.getPhoneNumber())));
        dto.setCompanyId(user.getCompanyId());
        return dto;
    }

    public List<UserDto> toDtoList(List<User> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }
}
