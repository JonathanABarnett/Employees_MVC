package com.alaythiaproductions.employees.repository;

import com.alaythiaproductions.employees.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {


}
