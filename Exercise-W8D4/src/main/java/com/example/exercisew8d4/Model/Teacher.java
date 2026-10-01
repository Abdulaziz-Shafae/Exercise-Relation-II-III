package com.example.exercisew8d4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank( message = "The name cant be blank")
    @NotEmpty( message = "The name cant be empty")
    @Size(max = 25, message = "Name must not exceed 25 characters")
    @Column(columnDefinition = "VARCHAR(25) not null")
    private String name;


    @NotNull(message = "The age cant be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Column(columnDefinition = "int not null")
    private Integer age;


    @Email(message = "The email must have @")
    @NotBlank( message = "The email cant be blank")
    @NotEmpty( message = "The email cant be empty")
    @Size(max = 25, message = "Email must not exceed 25 characters")
    @Column(columnDefinition = "VARCHAR(25) not null")
    private String email;


    @NotNull(message = "The salary cant be null")
    @Positive(message = "The salary must be positive")
    @Column(columnDefinition = "double not null")
    private Double salary;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;

}