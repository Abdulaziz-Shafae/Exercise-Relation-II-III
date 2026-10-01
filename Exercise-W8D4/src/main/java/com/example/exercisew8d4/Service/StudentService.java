package com.example.exercisew8d4.Service;

import com.example.exercisew8d4.Api.ApiException;
import com.example.exercisew8d4.Model.Course;
import com.example.exercisew8d4.Model.Student;
import com.example.exercisew8d4.Repository.CourseRepository;
import com.example.exercisew8d4.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> get() {
        return studentRepository.findAll();
    }

    public void add(Student student){

        studentRepository.save(student);

    }

    public void assign(Integer course_id, Integer student_id){

        Course oldCourse = courseRepository.findCourseById(course_id);

        if(oldCourse == null){
            throw new ApiException("No course found");
        }

        Student oldStudent = studentRepository.findStudentById(student_id);

        if(oldStudent == null){
            throw new ApiException("No student found");
        }

        oldCourse.getStudents().add(oldStudent);
        oldStudent.getCourses().add(oldCourse);

        courseRepository.save(oldCourse);
        studentRepository.save(oldStudent);

    }

    public void update(Integer id, Student student){

        Student oldStudent = studentRepository.findStudentById(id);

        if(oldStudent == null){
            throw new ApiException("No student found");
        }

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());

        studentRepository.save(oldStudent);
    }

    public void delete(Integer id){

        Student oldStudent = studentRepository.findStudentById(id);

        if(oldStudent == null){
            throw new ApiException("No student found");
        }

        studentRepository.delete(oldStudent);
    }

    public void changeMajor(Integer student_id, String major){

        Student oldStudent = studentRepository.findStudentById(student_id);

        if(oldStudent == null){
            throw new ApiException("No student found");
        }

        for(Course course : oldStudent.getCourses()){
            course.getStudents().remove(oldStudent);
            courseRepository.save(course);
        }

        oldStudent.getCourses().clear();
        oldStudent.setMajor(major);

        studentRepository.save(oldStudent);
    }
}