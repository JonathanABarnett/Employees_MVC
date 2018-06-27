package com.alaythiaproductions.employees.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Please enter your first name.")
    @Size(min = 3, message = "Please enter your full first name.")
    private String firstName;
    @NotNull(message = "Please enter your last name.")
    @Size(min = 3, message = "Please enter your full last name.")
    private String lastName;
    @NotNull(message = "Please enter your email address.")
    @Size(min = 3, message = "Please enter your correct email address.")
    private String email;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
