package com.example.task7;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CreateForm {
    @NotBlank
    @Length(max = 20)
    private String name;
    private final String birthday;

    public CreateForm(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
