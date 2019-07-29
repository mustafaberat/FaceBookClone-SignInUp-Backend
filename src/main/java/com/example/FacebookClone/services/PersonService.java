package com.example.FacebookClone.services;

import com.example.FacebookClone.model.Person;
import com.example.FacebookClone.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;

    public void addPerson(Person newPerson){
        this.personRepository.save(newPerson);
    }

    public void deleteById(Long id){
        this.personRepository.deleteById(id);
    }

    @OrderBy()
    public List<Person> getPeople(){
        return personRepository.findAll(Sort.by("id"));
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).get();
    }
}
