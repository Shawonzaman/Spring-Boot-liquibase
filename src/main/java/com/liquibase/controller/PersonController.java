package com.liquibase.controller;

import com.liquibase.entity.Person;
import com.liquibase.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @PostMapping("/add")
    public String createPerson(@RequestParam String name, @RequestParam String email, @RequestParam String phone_number, @RequestParam String address){
        personRepository.save(new Person(name, email, phone_number, address));
        return "saved successfully";
    }
    @GetMapping("/all")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
