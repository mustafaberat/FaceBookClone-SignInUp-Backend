package com.example.FacebookClone.model;


import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Allow to write on Database
@Getter //Auto get function
@Setter //Auto set function
@ToString
@NoArgsConstructor //Auto empty constructor
@AllArgsConstructor //Auto full parameter constructor
@Table(name = "People")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String passwordConfirm;
}
