package com.example.exercisew8d4.Service;

import com.example.exercisew8d4.Api.ApiException;
import com.example.exercisew8d4.Model.Course;
import com.example.exercisew8d4.Model.Student;
import com.example.exercisew8d4.Model.Teacher;
import com.example.exercisew8d4.Repository.CourseRepository;
import com.example.exercisew8d4.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course>  get(){
        return courseRepository.findAll();
    }

    public void add(Course course){
        courseRepository.save(course);
    }

    public void addB1(Integer teacher_id, Course course){

        Teacher teacher = teacherRepository.findTeacherById(teacher_id);

        if(teacher==null){
            throw new ApiException("No teacher found");
        }

        course.setTeacher(teacher);

        courseRepository.save(course);

    }

    public void update(Integer id , Course course){
        Course oldcourse= courseRepository.findCourseById(id);

        if(oldcourse == null ){
            throw new ApiException("Wrong id");
        }

        oldcourse.setName(course.getName());

        courseRepository.save(oldcourse);
    }

    public void delete(Integer id){
        Course oldcourse= courseRepository.findCourseById(id);

        if(oldcourse == null ){
            throw new ApiException("Wrong id");
        }

        courseRepository.delete(oldcourse);
    }

    public String getTeacherName( Integer course_id){

        Course course= courseRepository.findCourseById(course_id);

        if(course == null ){
            throw new ApiException("Wrong id");
        }

        return course.getTeacher().getName();

    }

    public Set<Student> getStudents(Integer course_id){

        Course course = courseRepository.findCourseById(course_id);

        if(course == null){
            throw new ApiException("No course found");
        }

        return course.getStudents();
    }

}
