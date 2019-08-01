package com.example.FacebookClone.controllers;


import com.example.FacebookClone.model.Person;
import com.example.FacebookClone.model.SignInPerson;
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

    @PostMapping("/signIn")
    public String checkPersonToLogIn(@RequestBody SignInPerson signInPerson){
        LOG.info(signInPerson.toString());
        if(getPersonByEmail(signInPerson) != null){ //Email found
            Person logInPerson = getPersonByEmail(signInPerson);
            if(logInPerson.getPassword().equals(PersonService.getHash(signInPerson.getPassword()
                    + signInPerson.getEmail()))){
                return "Correct";
            } else {
                return "FailPassword";
            }
        }
        else { //Email not found
            return "FailEmail";
        }
    }

    @GetMapping("/people")
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @DeleteMapping("/people/id")
    public void deleteById(@RequestBody Long id){
        personService.deleteById(id);
    }

    private Person getPersonByEmail(@RequestBody SignInPerson signInPerson){
        return personService.getPersonByEmail(signInPerson.getEmail());
    }


}
