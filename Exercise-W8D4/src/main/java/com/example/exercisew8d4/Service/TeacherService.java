package com.example.exercisew8d4.Service;

import com.example.exercisew8d4.Api.ApiException;
import com.example.exercisew8d4.Model.Teacher;
import com.example.exercisew8d4.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> get(){
        return teacherRepository.findAll();
    }

    public void add(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void update(Integer id , Teacher teacher){

        Teacher oldTeacher= teacherRepository.findTeacherById(id);

        if(oldTeacher==null){
            throw new ApiException("Wrong id");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setAddress(teacher.getAddress());

        teacherRepository.save(oldTeacher);
    }

    public void delete(Integer id){

        Teacher oldTeacher= teacherRepository.findTeacherById(id);

        if(oldTeacher==null){
            throw new ApiException("Wrong id");
        }

        teacherRepository.delete(oldTeacher);
    }

    public Teacher getTeacher(Integer id){

        Teacher oldTeacher= teacherRepository.findTeacherById(id);

        if(oldTeacher==null){
            throw new ApiException("Wrong id");
        }

        return oldTeacher;
    }
}