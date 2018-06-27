package com.alaythiaproductions.employees.service;

import com.alaythiaproductions.employees.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    void save(Person person);

    void remove(int id);

}
