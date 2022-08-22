package com.demo.dddArchitecture.presentation.controllers;

import com.demo.dddArchitecture.domain.entities.Employee1;
import com.demo.dddArchitecture.domain.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee")
    public List<Employee1> getEmployee(){
        return employeeService.getEmployee();
    }
    @PostMapping("/employee")
    public Employee1 createCustomer(@RequestBody Employee1 employee1) {
        logger.info("Inside CustomerController........");
        return employeeService.registerEmployee(employee1);
    }
    @DeleteMapping(path = "/employee/{employeeId}")
    public Map<String, Boolean> deleteEmployee(@PathVariable ("employeeId") Long id){
        return  employeeService.deleteEmployee(id);
    }
    @PutMapping(path = "/employee/{employeeId}")
    public ResponseEntity<Employee1> updateEmployee(@PathVariable ("employeeId") Long id,
                                                    @RequestBody Employee1 employee1){
        return employeeService.updateEmployee(id, employee1);
    }

    @GetMapping(path = "/employee/{employeeId}")
    public Optional<Employee1> findEmployeeById (@PathVariable ("employeeId") Long id){
        return employeeService.findEmployeeById(id);
    }
}
