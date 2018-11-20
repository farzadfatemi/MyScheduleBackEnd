package com.fartech.myschedule.controller;

import com.fartech.myschedule.model.Company;
import com.fartech.myschedule.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class CompanyController {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @CrossOrigin
    @GetMapping("/allCompanies")
    public List<Company> getAllCompanies() {
        System.out.println("All Companies is called ...");
        return companyRepository.findAll(new Sort(Sort.Direction.ASC, "companyId"));
    }
    @CrossOrigin
    @PostMapping("/addCompany")
    public Company addCompany(@Valid @RequestBody Company company) {
        System.out.println("Add Company is called ..." + company.toString());
        return companyRepository.save(company);
    }
}
