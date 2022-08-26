package com.demo.dddArchitecture.Interfaces.controller;

import com.demo.dddArchitecture.domain.entities.Company;
import com.demo.dddArchitecture.domain.FeignDTO.FeignCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private FeignCompanyService feignCompanyService;

    private KafkaTemplate<String, String> kafkaTemplate;

    public CompanyController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

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
//    @PostMapping("/kafka")
//    public ResponseEntity<String> demokafka(@RequestBody MessageRequest request){
//        kafkaTemplate.send("topic1", request.massage());
//        return ResponseEntity.ok("Message sent to the topic");
//    }
}
