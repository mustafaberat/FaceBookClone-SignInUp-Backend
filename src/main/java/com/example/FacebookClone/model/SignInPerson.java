package com.example.FacebookClone.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter //Auto get function
@Setter //Auto set function
public class SignInPerson {
    @NotNull
    String email ;
    @NotNull
    String password;
}
