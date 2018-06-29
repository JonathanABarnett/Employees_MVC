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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class UpdateDepartment {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/updateDepartment")
    public String updateDepartment(@RequestParam("id") int id, Model model) {
        Department department = departmentService.getOne(id);
        System.out.println(department.getId() + " " + department.getName());
        model.addAttribute("title", "Update "  + department.getName());
        model.addAttribute("department", department);
        return "updateDepartment";
    }


    @PostMapping(value = "/updateDepartment")
    public String processUpdateDepartment(@Valid @ModelAttribute("department") Department department, Errors errors, Model model) {
        model.addAttribute("title", "Update " + department.getName());
        if (errors.hasErrors()) {
            model.addAttribute("title", "Update "  + department.getName());
            model.addAttribute("error", true);
            return "updateDepartment";
        }

        System.out.println(department.getId() + " " + department.getName());
        departmentService.save(department);
        model.addAttribute("updated", true);
        return "detailDepartment?id=" + department.getId();
    }
}
