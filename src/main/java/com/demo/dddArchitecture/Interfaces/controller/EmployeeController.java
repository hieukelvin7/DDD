package com.demo.dddArchitecture.Interfaces.controller;

import com.demo.dddArchitecture.domain.FeignDTO.FeignEmployeeService;
import com.demo.dddArchitecture.domain.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private FeignEmployeeService feignEmployeeService;

    @GetMapping("/")
    public List<Employee> getEmployee(){
       return feignEmployeeService.getEmployee();
    }
    @GetMapping("/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable("employeeId") Long id){
        return feignEmployeeService.findEmployeeById(id);
    }
    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable ("employeeId") Long id, @RequestBody Employee employee){
        return feignEmployeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/{employeeId}")
    public Map<String, Boolean> deleteEmployee(@PathVariable ("employeeId") Long id){
        return feignEmployeeService.deleteEmployee(id);
    }
}
