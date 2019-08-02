package com.example.FacebookClone.controllers;

import com.example.FacebookClone.model.Person;
import com.example.FacebookClone.services.PersonService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class PersonControllerTest {

    @InjectMocks // Controller objesini buraya yolluyor
    PersonController personController;

    @Mock //Kullandiginin sahtesini inject ediyor yani service etkisi olmuyor
    PersonService personService;

    @Test
    public void addPerson() {
        Person newperson;
//        when()
    }

    @Test
    public void addMultiPeople() {
    }

    @Test
    public void checkPersonToLogIn() {
    }

    @Test
    public void getPeople() {
    }

    @Test
    public void deleteById() {
    }
}