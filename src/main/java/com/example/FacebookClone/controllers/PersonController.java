package com.example.FacebookClone.controllers;


import com.example.FacebookClone.model.Person;
import com.example.FacebookClone.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") //Local hostun tum portlar alsin diye
@RequiredArgsConstructor
@RestController
public class PersonController {
    private final Logger LOG = LoggerFactory.getLogger(PersonController.class);
    final private PersonService personService;

    @PostMapping("/signUp")
    public void addPerson(@RequestBody Person person){
        LOG.info(person.toString());
        personService.addPerson(person);
    }

    @GetMapping("/people")
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @DeleteMapping("/people/{id}")
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }

//    @GetMapping("/people/{id}")
//    public Person getPersonById(Long id){
//        return personService.getPersonById(id);
//    }
//

}
