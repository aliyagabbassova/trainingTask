package com.example.companyService.service;

import com.example.companyService.model.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company company);
    Company getCompanyById(Long id);
    Company updateCompany (Long id, Company company);
    List<Company> getAllCompanies();
    Company addCompany(Company company);
    void deleteCompany(Long id);
}
