package com.alaythiaproductions.employees.service;

import com.alaythiaproductions.employees.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    void save(Person person);

    void remove(int id);

    Person findById(int id);

    Person getOne(int id);

}
