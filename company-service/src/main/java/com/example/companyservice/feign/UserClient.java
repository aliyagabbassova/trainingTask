package com.example.companyservice.feign;




import com.example.userservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/users/company/{companyId}")
    List<UserDto> getUsersByCompanyId(@PathVariable Long companyId);
}