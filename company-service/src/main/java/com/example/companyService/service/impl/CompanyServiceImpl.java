package com.example.companyService.service.impl;

import com.example.companyService.model.Company;
import com.example.companyService.repository.CompanyRepository;
import com.example.companyService.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

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
        return companyRepository.findAll();
    }

    @Override
    public Company addCompany(Company company) {
        return  companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            companyRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Компания с id " + id + " не найдена");
        }
    }
}
