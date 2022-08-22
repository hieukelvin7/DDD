package com.demo.dddArchitecture.domain.service;

import com.demo.dddArchitecture.domain.entities.Employee1;
import com.demo.dddArchitecture.infrastructure.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee1> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee1 registerEmployee(Employee1 employee1) {
        return employeeRepository.save(employee1);
    }

    @Override
    public ResponseEntity<Employee1> updateEmployee(Long id, Employee1 employee1) {
        return ResponseEntity.ok(employeeRepository.save(employee1));
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long id) {
        boolean exist = employeeRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("Id " + id+ " does not exist!!!");
        }
        employeeRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public Optional<Employee1> findEmployeeById(Long id) {
        boolean exist = employeeRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("Id " + id+ " does not exist!!!");
        }
        return employeeRepository.findById(id);
    }
}
