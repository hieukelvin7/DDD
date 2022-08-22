package com.demo.dddArchitecture.domain.service;


import com.demo.dddArchitecture.domain.entities.Employee1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface EmployeeService {
    public List<Employee1> getEmployee();
    Employee1 registerEmployee(@RequestBody Employee1 employee1);

    ResponseEntity<Employee1> updateEmployee(@PathVariable("employeeId") Long id, @RequestBody Employee1 employee1);
    Map<String, Boolean> deleteEmployee(@PathVariable ("employeeId") Long id);
    Optional<Employee1> findEmployeeById (@PathVariable ("employeeId") Long id);

}
