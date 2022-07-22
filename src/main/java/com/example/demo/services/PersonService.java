package com.example.demo.services;

import com.example.demo.dtos.PersonDto;
import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    public PersonRepository repo;

    private ModelMapper mapper;

    @Autowired
    public PersonService(PersonRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private PersonDto mapToDTO(Person person) {
        return this.mapper.map(person, PersonDto.class);
    }

    // findAll
    public List<PersonDto> findAll() {
       return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
