package com.example.FacebookClone.repository;

import com.example.FacebookClone.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    public List<Person> findByEmail(String email);
}
