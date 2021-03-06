package com.alaythiaproductions.employees.service;

import com.alaythiaproductions.employees.models.Department;
import com.alaythiaproductions.employees.models.Person;
import com.alaythiaproductions.employees.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

//    @Override
//    public Department findById(int id) {
//        return departmentRepository.findById(id);
//    }

    @Override
    public List<Person> findEmployees(Department department) {
        return department.getPersonList();
    }

//    @Override
//    public Department getOne(int id) {
//        return departmentRepository.getOne(id);
//    }

    @Override
    public Department getOne(int id) {
        return departmentRepository.getOne(id);
    }
}
