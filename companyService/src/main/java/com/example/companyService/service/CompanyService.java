package com.example.companyService.service;

import com.example.companyService.model.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company user);
    Company getCompanyById(Long id);
    Company updateCompany (Long id, Company user);
    List<Company> getAllCompanies();
    Company addCompany(Company user);
    void deleteCompany(Long id);

}
