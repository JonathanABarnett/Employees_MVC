package com.alaythiaproductions.employees.controllers;

import com.alaythiaproductions.employees.models.Department;
import com.alaythiaproductions.employees.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/addDepartment")
    public String addDescriptionForm(Model model) {
        model.addAttribute("title", "Add Department");
        model.addAttribute(new Department());
        return "addDepartment";
    }

    @PostMapping(value = "/addDepartment")
    public String processAddDescriptionForm(Model model, @ModelAttribute @Valid Department department, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Department");
            model.addAttribute("error", true);
            return "addDepartment";
        }
        model.addAttribute("added", true);
        departmentService.save(department);
        model.addAttribute("departments", departmentService.findAll());
        return "listDepartment";
    }

    @GetMapping(value = "/listDepartment")
    public String listOfDepartments(Model model) {
        model.addAttribute("title", "Department List");
        model.addAttribute("departments", departmentService.findAll());
        return "listDepartment";
    }
}
