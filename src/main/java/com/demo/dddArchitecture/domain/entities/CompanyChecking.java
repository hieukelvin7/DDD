package com.demo.dddArchitecture.domain.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name="\"companyChecking\"")
public class CompanyChecking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

//    @ManyToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name = "company_id", nullable = false)
//    private Company company;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employeeList;


    public CompanyChecking(UUID uuid, List<Employee> employeeList) {
        this.uuid = uuid;
        this.employeeList = employeeList;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public CompanyChecking() {
    }

    @Override
    public String toString() {
        return "CompanyChecking{" +
                "id=" + id +
                ", uuid=" + uuid +
                '}';
    }
}
