package com.example.exercisew8d4.Repository;

import com.example.exercisew8d4.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);

}