package com.alaythiaproductions.employees.controllers;

import com.alaythiaproductions.employees.models.Person;
import com.alaythiaproductions.employees.service.PersonService;
import com.alaythiaproductions.employees.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = {"/", "/index"})
    public String indexPage(Model model) {
        model.addAttribute("title", "Employees");
        return "index";
    }

    @GetMapping(value = "/list")
    public String processRemoveName(Model model) {
        model.addAttribute("title", "List");
        model.addAttribute("names", personService.findAll());
        return "list";
    }

    @GetMapping(value = "/add")
    public String displayAddName(Model model) {
        model.addAttribute("title", "Add Person");
        model.addAttribute(new Person());
        return "add";
    }

    @PostMapping(value = "/add")
    public String processAddName(Model model, @ModelAttribute @Valid Person person, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Name");
            model.addAttribute("error", true);
            return "add";
        }
        model.addAttribute("added", true);
        personService.save(person);
        model.addAttribute("names", personService.findAll());
        return "list";
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
            return "list";
        } else {
            model.addAttribute("names", personService.findAll());
            return "remove";
        }

        }


    }
