package com.example.exercisew8d4.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    @NotBlank( message = "The area cant be blank")
    @NotEmpty( message = "The area cant be empty")
    @Size(max = 25, message = "Area must not exceed 25 characters")
    private String area;


    @NotBlank( message = "The street cant be blank")
    @NotEmpty( message = "The street cant be empty")
    @Size(max = 25, message = "Street must not exceed 25 characters")
    private String street;


    @NotNull( message = "The building number cant be empty")
    @Positive(message = "The building number must be positive")
    private Integer buildingNumber;

}