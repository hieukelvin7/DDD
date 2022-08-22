package com.demo.dddArchitecture.infrastructure.repository;

import com.demo.dddArchitecture.domain.entities.Employee1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee1, Long> {
}
