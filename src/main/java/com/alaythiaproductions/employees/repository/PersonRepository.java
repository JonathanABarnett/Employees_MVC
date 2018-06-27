package com.alaythiaproductions.employees.repository;

import com.alaythiaproductions.employees.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findById(int id);

}
