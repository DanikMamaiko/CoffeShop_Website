package com.dessert.project.dessert.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="consumers_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consumers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="name")
    @Size(min=2, message = "Name must be 2 symbols")
    private String name;

    @Column(name="surname")
    @Size(min=2, message = "Name must be 2 symbols")
    private String surname;

    @Column(name="sex")
    @Size(min=1, message = "Error sex")
    private String sex;

    @Column(name="age")
    @Max(value=100, message = "Error age")
    private int age;

    @Column(name ="phoneNumber")
    private String phoneNumber;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "consumer")
    List<Orders> ordersList;

    public Consumers(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
