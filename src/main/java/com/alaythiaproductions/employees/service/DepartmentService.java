package com.alaythiaproductions.employees.service;


import com.alaythiaproductions.employees.models.Department;
import com.alaythiaproductions.employees.models.Person;

import java.util.List;

public interface DepartmentService {

    Department save(Department department);

    List<Department> findAll();

    Department findById(int id);

    List<Person> findEmployees(Department department);
}
