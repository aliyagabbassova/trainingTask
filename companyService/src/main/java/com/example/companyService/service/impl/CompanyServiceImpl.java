package com.example.companyService.service.impl;

import com.example.companyService.model.Company;
import com.example.companyService.repository.CompanyRepository;
import com.example.companyService.service.CompanyService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;


    @Override
    public Company createUser(Company user) {
        return companyRepository.save(user);
    }

    @Override
    public Company getUserById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company updateUser(Long id, Company company) {
        Company companyById = getUserById(id);
        companyById.setCompanyId(company.getCompanyId());
        companyById.setEmployeeId(company.getEmployeeId());
        companyById.setCompanyName(company.getCompanyName());
        companyById.setBudget(company.getBudget());
        return companyRepository.save(companyById);
    }

//Уточнить!!!!
    @Override
    public List<Company> getAllUsers() {
        return companyRepository.findAll();
    }

    @Override
    public Company addUser(Company user) {
        return companyRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        Company userById = getUserById(id);
        companyRepository.delete(userById);
    }
}
