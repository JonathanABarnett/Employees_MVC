package com.alaythiaproductions.employees.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotNull
    @Size(min = 3, message = "Please enter full department name.")
    private String name;
    @NotNull
    @Size(min = 2, message = "Please enter location ID.")
    private String locationId;
    @NotNull
    @Size(min = 3, message = "Please enter description of department.")
    private String description;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Person> personList;

    public Department() {}

    public Department(String name, String locationId, String description) {
        this.name = name;
        this.locationId = locationId;
        this.description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
