package com.example.exercisew8d4.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;


    @NotBlank( message = "The area cant be blank")
    @NotEmpty( message = "The area cant be empty")
    @Size(max = 25, message = "Area must not exceed 25 characters")
    @Column(columnDefinition = "VARCHAR(25) not null")
    private String area;


    @NotBlank( message = "The street cant be blank")
    @NotEmpty( message = "The street cant be empty")
    @Size(max = 25, message = "Street must not exceed 25 characters")
    @Column(columnDefinition = "VARCHAR(25) not null")
    private String street;


    @NotNull(message = "The building number cant be null")
    @Positive(message = "The building number must be positive")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;



}