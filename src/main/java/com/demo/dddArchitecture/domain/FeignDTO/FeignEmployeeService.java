package com.demo.dddArchitecture.domain.FeignDTO;


import com.demo.dddArchitecture.domain.entities.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@FeignClient(value = "feignDemo",url = "http://localhost:8080/api/v1")
public interface FeignEmployeeService {
    @GetMapping("/employee")
    List<Employee> getEmployee();
    @GetMapping("/employee/{employeeId}")
    Optional<Employee> findEmployeeById(@PathVariable("employeeId") Long id);
    @PutMapping("/employee/{employeeId}")
    ResponseEntity<Employee> updateEmployee (@PathVariable ("employeeId") Long id,
                                             @RequestBody Employee employee);
    @DeleteMapping("/employee/{employeeId}")
    Map<String, Boolean> deleteEmployee(@PathVariable ("employeeId") Long id);
}
