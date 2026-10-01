package com.example.exercisew8d4.Repository;

import com.example.exercisew8d4.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course, Integer> {
    Course findCourseById(Integer id);

}
