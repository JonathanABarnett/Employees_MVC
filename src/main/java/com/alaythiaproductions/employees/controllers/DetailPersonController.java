package com.alaythiaproductions.employees.controllers;

import com.alaythiaproductions.employees.models.Person;
import com.alaythiaproductions.employees.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class DetailPersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/detailEmployee")
    public String employeeDetail(@PathParam("id") int id, Model model) {
        Person emp = personService.findById(id);
        model.addAttribute("title", emp.getFirstName() + " Description");
        model.addAttribute("person", emp);
        return "detailEmployee";
    }
}
