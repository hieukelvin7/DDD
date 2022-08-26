package com.demo.dddArchitecture.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="\"employee\"")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Employee implements Serializable {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "employee_sequence"
    )
    private  Long id;
    private String name;
    private String email;
    private String address;
    private Integer age;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Employee(String name, String email, String address, Integer age, Company company) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.age = age;
        this.company = company;
    }

    public Employee() {
    }

//    public Employee(Long id, String name, String email, String address, Integer age) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.address = address;
//        this.age = age;
//    }

//    public Employee(String name, String email, String address, Integer age) {
//        this.name = name;
//        this.email = email;
//        this.address = address;
//        this.age = age;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", address='" + address + '\'' +
//                ", age=" + age +
//                '}';
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", company=" + company +
                '}';
    }
}
