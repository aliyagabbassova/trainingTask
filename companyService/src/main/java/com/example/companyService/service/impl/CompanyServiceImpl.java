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
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Company companyById = getCompanyById(id);
        companyById.setCompanyId(company.getCompanyId());
        companyById.setEmployeeId(company.getEmployeeId());
        companyById.setCompanyName(company.getCompanyName());
        companyById.setBudget(company.getBudget());
        return companyRepository.save(companyById);
    }

    @Override
    public List<Company> getAllCompanies() {
        return List.of();
    }

    @Override
    public Company addCompany(Company company) {
        return null;
    }

    @Override
    public void deleteCompany(Long id) {

    }
}
