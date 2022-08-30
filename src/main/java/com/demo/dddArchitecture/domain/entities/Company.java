package com.demo.dddArchitecture.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table()
//name="\"company\""
public class Company {
//    @Id
//    @SequenceGenerator(
//            name = "company_sequence",
//            sequenceName = "company_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//            generator = "company_sequence"
//    )

//    private  Long id;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false,unique = true)
private Long id;


    private String name;

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company() {
    }

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

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
