package com.alaythiaproductions.employees.service;


import com.alaythiaproductions.employees.models.Department;

import java.util.List;

public interface DepartmentService {

    Department save(Department department);

    List<Department> findAll();

    Department findById(int id);
}
