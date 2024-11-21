package com.example.lab7.Model1;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatintModel {

    @NotEmpty(message = "Id cannot be null")
    private String id;
    @NotEmpty(message = "name cannot be null")
    @Size(min = 3 ,message = "the name must be more than 3")
    private String name;

    @NotNull(message = "The Age cannot be null")
    @Min(value = 10, message = "The age must be more than 10")
    @Max(value = 80, message = "The age must be less than 80")
    private Integer age;

    @NotEmpty(message = "Password cannot be empty!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and be between 8 and 20 characters long.")
    private String password;

    @Email(message = "Entry Valid Email")
    private String email;

    @Pattern(regexp = "^(doctor|patient)$", message = "Type of Users must be either 'doctor' or 'patient' only")
    private String typeUser;

    private boolean isADHD=false;
}

