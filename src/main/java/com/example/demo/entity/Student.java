package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;



    public Student() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

}
