package com.example.FacebookClone.controllers;


import com.example.FacebookClone.model.Person;
import com.example.FacebookClone.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public class PersonController {
    final private PersonService personService;

    @PostMapping("/signUp")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping("/people")
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @GetMapping("/people/{id}")
    public Person getPersonById(Long id){
        return personService.getPersonById(id);
    }

    @DeleteMapping("/people/{id}")
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }
}
