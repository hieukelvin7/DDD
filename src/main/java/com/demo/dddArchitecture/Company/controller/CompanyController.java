package com.demo.dddArchitecture.Company.controller;

import com.demo.dddArchitecture.Company.domain.Entity.Company;
import com.demo.dddArchitecture.Company.domain.Service.FeignCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private FeignCompanyService feignCompanyService;

    @GetMapping("/")
    public List<Company> getAllCompany(){
        return feignCompanyService.getAllCompany();
    }

    @GetMapping("/{companyId}")
    public Optional<Company> getCompanyById(@PathVariable("companyId") Long id){
        return feignCompanyService.findCompanyById(id);
    }
    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateEmployee(@PathVariable ("companyId") Long id, @RequestBody Company company){
        return feignCompanyService.updateCompany(id,company);
    }
    @DeleteMapping("/{companyId}")
    public Map<String, Boolean> deleteCompany(@PathVariable ("companyId") Long id){
        return feignCompanyService.deleteCompany(id);
    }

}
