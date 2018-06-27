package com.alaythiaproductions.employees.service;

import com.alaythiaproductions.employees.models.Person;
import com.alaythiaproductions.employees.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void remove(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id);
    }
}
