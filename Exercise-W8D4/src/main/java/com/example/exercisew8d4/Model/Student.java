package com.example.exercisew8d4.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "The name cant be blank")
    @NotEmpty(message = "The name cant be empty")
    @Size(max = 25, message = "Name must not exceed 25 characters")
    @Column(columnDefinition = "VARCHAR(25) not null")
    private String name;


    @NotNull(message = "The age cant be null")
    @Min(value = 1, message = "Age must be at least 1")
    @Column(columnDefinition = "int not null")
    private Integer age;


    @NotBlank(message = "The major cant be blank")
    @NotEmpty(message = "The major cant be empty")
    @Size(max = 25, message = "Major must not exceed 25 characters")
    @Column(columnDefinition = "VARCHAR(25) not null")
    private String major;


    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

}