package com.example.demo.controllers;

import com.example.demo.dtos.PersonDto;
import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageController {

    private PersonService service;

    @Autowired
    public PageController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/thymeleaf")
    public String demoPage (Model model) {
        List<PersonDto> personList = service.findAll();
        model.addAttribute("personList", personList);
        return "thymeleaf.html";
    }

    @GetMapping("/javaScript")
    public String demoPage2 () {
        return "javaScript.html";
    }
}
