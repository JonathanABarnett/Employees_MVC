package com.alaythiaproductions.employees.controllers;

import com.alaythiaproductions.employees.models.Department;
import com.alaythiaproductions.employees.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DetailDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/detailDepartment")
    public String detailDepartment(@ModelAttribute("id") int id, Model model) {
        Department department = departmentService.getOne(id);
        model.addAttribute("title", department.getName() + " Description");
        model.addAttribute("department", department);
        model.addAttribute("personList", departmentService.findEmployees(department));
        return "detailDepartment";
    }
}
