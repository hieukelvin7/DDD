package com.demo.dddArchitecture.infrastructure.repository;

import com.demo.dddArchitecture.domain.entities.CompanyChecking;
import com.demo.dddArchitecture.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CompanyCheckingRepository extends JpaRepository<CompanyChecking,Long> {

    @Query("SELECT c FROM CompanyChecking c where c.company_id =:id")
    List<CompanyChecking> findCompanyId(@Param("id") Long id);

    @Query("SELECT c FROM CompanyChecking c where c.employeeList.id = ?1")
    List<CompanyChecking> findEmployeeId(Long id);
}
