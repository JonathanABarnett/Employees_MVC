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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private PersonService personService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = {"/", "/index"})
    public String indexPage(Model model) {
        model.addAttribute("title", "Employees");
        return "index";
    }

    @GetMapping(value = "/listEmployee")
    public String processRemoveName(Model model) {
        model.addAttribute("title", "List");
        List<Person> personList = personService.findAll();
            model.addAttribute("names", personList);
            return "listEmployee";
    }

    @GetMapping(value = "/addEmployee")
    public String displayAddName(Model model) {
        model.addAttribute("title", "Add Person");
        model.addAttribute(new Person());
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

        return "addEmployee";
    }

    @PostMapping(value = "/addEmployee")
    public String processAddName(Model model, @ModelAttribute @Valid Person person, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Name");
            model.addAttribute("error", true);
            model.addAttribute("departments", departmentService.findAll());
            return "addEmployee";
        }
        model.addAttribute("added", true);
        personService.save(person);
        model.addAttribute("names", personService.findAll());
        return "listEmployee";
    }

    @GetMapping(value = "/remove")
    public String displayRemoveName(Model model) {
        model.addAttribute("title", "Delete Person");
        model.addAttribute("names", personService.findAll());
        return "remove";
    }

    @PostMapping(value = "/remove")
    public String processRemoveName(Model model, @RequestParam(required = false) int[] ids) {

        model.addAttribute("title", "Delete Person");
        if (ids != null) {
            for (int id : ids) {
                personService.remove(id);
            }
            model.addAttribute("names", personService.findAll());
            return "listEmployee";
        } else {
            model.addAttribute("names", personService.findAll());
            return "remove";
        }

        }


    }
