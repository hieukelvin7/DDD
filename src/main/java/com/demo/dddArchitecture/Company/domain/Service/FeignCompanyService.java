package com.demo.dddArchitecture.Company.domain.Service;

import com.demo.dddArchitecture.Company.domain.Entity.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@FeignClient(value = "FeignCompany", url = "http://localhost:8081/api/v2")
public interface FeignCompanyService {

    @GetMapping(value = "/company")
    List<Company> getAllCompany();

    @PostMapping("/company")
    public Company registerCompany(@RequestBody Company company);

    @DeleteMapping(path = "/company/{companyId}")
    public Map<String, Boolean> deleteCompany(@PathVariable("companyId") Long id);

    @PutMapping(path = "/company/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable ("companyId") Long id, @RequestBody Company company);

    @GetMapping(path = "/company/{companyId}")
    public Optional<Company> findCompanyById (@PathVariable ("companyId") Long id);
}
