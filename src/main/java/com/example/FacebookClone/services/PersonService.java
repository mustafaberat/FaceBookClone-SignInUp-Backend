package com.example.FacebookClone.services;

import com.example.FacebookClone.model.Person;
import com.example.FacebookClone.repository.PersonRepository;
import javassist.bytecode.ByteArray;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;

    private MessageDigest messageDigest ;

    private String getHash(String password){
        try {
            StringBuffer hexString = new StringBuffer(); //String yaratiyor
            messageDigest = MessageDigest.getInstance("SHA-256"); //Hash fonksiyonu
            byte[] byteArray = messageDigest.digest(password.getBytes());
            for (byte myByte:byteArray){
                hexString.append(myByte);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addPerson(Person newPerson){
        newPerson.setPassword(getHash(newPerson.getPassword() + newPerson.getEmail()));
        this.personRepository.save(newPerson);
    }

    @OrderBy()
    public List<Person> getPeople(){
        return personRepository.findAll(Sort.by("id"));
    }


    public void deleteById(Long id){
        this.personRepository.deleteById(id);
    }

//
//    public Person getPersonById(Long id){
//        return personRepository.findById(id).get();
//    }
}
