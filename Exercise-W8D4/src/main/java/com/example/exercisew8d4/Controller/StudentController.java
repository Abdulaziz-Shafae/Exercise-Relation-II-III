package com.example.exercisew8d4.Controller;

import com.example.exercisew8d4.Api.ApiResponse;
import com.example.exercisew8d4.Model.Student;
import com.example.exercisew8d4.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body(studentService.get());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid Student student){
        studentService.add(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid Student student){
        studentService.update(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("student updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        studentService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted"));
    }

    @PostMapping("/assign/course/{course_id}/student/{student_id}")
    public ResponseEntity<?> assignCS(@PathVariable Integer course_id, @PathVariable Integer student_id){
        studentService.assign(course_id, student_id);
        return ResponseEntity.status(200).body(new ApiResponse("course-student added"));
    }

    @PutMapping("/major/{student_id}/{major}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer student_id, @PathVariable String major){

        studentService.changeMajor(student_id, major);

        return ResponseEntity.status(200).body(new ApiResponse("student major changed"));
    }


}