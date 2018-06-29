package com.alaythiaproductions.employees.controllers;

import com.alaythiaproductions.employees.models.Department;
import com.alaythiaproductions.employees.models.Person;
import com.alaythiaproductions.employees.service.DepartmentService;
import com.alaythiaproductions.employees.service.PersonService;
import com.alaythiaproductions.employees.utility.USStates;
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
public class UpdatePerson {

    @Autowired
    private PersonService personService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/updateEmployee")
    public String updatePerson(@RequestParam("id") int id, Model model) {
        Person person = personService.getOne(id);
        model.addAttribute("title", person.getFirstName() + " Update");
        model.addAttribute("person", person);
        List<Department> departments = departmentService.findAll();

        if (departments.isEmpty()) {
            model.addAttribute("title", "Add Department");
            model.addAttribute("noDepartments", true);
            model.addAttribute(new Department());
            return "addDepartment";
        }

        model.addAttribute("departments", departments);

        List<String> stateList = USStates.listOfUSStateCode;
        Collections.sort(stateList);
        model.addAttribute("stateList", stateList);

        return "updateEmployee";
    }

    @PostMapping(value = "/updateEmployee")
    public String processUpdatePerson(@Valid @ModelAttribute("person") Person person, Errors errors, Model model) {
        model.addAttribute("title", person.getFirstName() + " Update");
        if (errors.hasErrors()) {
            model.addAttribute("title", person.getFirstName() + " Update");
            model.addAttribute("error", true);
            model.addAttribute("departments", departmentService.findAll());
            return "updateEmployee";
        }
        model.addAttribute("updated", true);
        personService.save(person);
        return "detailEmployee?id=" + person.getId();
    }
}
