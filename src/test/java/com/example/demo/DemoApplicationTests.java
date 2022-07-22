package com.example.demo;

import com.example.demo.dtos.PersonDto;
import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	private PersonService personService;

	@Autowired
	public DemoApplicationTests(PersonService personService) {
		this.personService = personService;
	}

	@Test
	void findAllPersons() {
		List<PersonDto> personList = personService.findAll();
		System.out.println(personList);
	}

}
