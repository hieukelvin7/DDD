package com.demo.dddArchitecture.domain.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table()
public class CompanyChecking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_list_id")
    private Employee employeeList;

//    @OneToMany(cascade = CascadeType.MERGE)
//    @Column(name = "company_list")
//    private List<Employee> employeeList;

    //@ManyToOne(cascade = CascadeType.MERGE)
//    @Column(name = "company_list")
    //private Long company_list_id;
    //@ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "employee_list_id")
    private Long company_id;


    public CompanyChecking(Employee employeeList, Long company_id) {
        this.employeeList = employeeList;
        this.company_id = company_id;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public Employee getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Employee employeeList) {
        this.employeeList = employeeList;
    }

    public CompanyChecking() {
    }

    @Override
    public String toString() {
        return "CompanyChecking{" +
                "id=" + id +
                ", employeeList=" + employeeList +
                ", company_id=" + company_id +
                '}';
    }
}
