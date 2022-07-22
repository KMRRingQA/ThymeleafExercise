package com.example.demo.controllers;

import com.example.demo.dtos.PersonDto;
import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PersonDto>> findAllPersons() {
        return new ResponseEntity<List<PersonDto>>(this.service.findAll(), HttpStatus.OK);
    }

}
