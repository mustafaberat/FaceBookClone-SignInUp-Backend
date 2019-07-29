package com.example.FacebookClone.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@EqualsAndHashCode()
public class PersonDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String passwordConfirm;

    public PersonDTO(Long id, String name, String surname, String email, String password, String passwordConfirm) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

}
