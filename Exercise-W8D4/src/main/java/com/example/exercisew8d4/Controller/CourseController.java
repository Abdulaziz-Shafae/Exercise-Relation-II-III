package com.example.exercisew8d4.Controller;

import com.example.exercisew8d4.Api.ApiResponse;
import com.example.exercisew8d4.Model.Course;
import com.example.exercisew8d4.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")

public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body( courseService.get());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid Course course ){
        courseService.add(course);
        return ResponseEntity.status(200).body( new ApiResponse("course added"));
    }

    @PostMapping("/add/b1/{teacher_id}")
    public ResponseEntity<?> addB1(@PathVariable Integer teacher_id,@RequestBody @Valid Course course){
        courseService.addB1(teacher_id, course);
        return ResponseEntity.status(200).body(new ApiResponse("course added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid Course course ){
        courseService.update(id,course);
        return ResponseEntity.status(200).body( new ApiResponse("course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id ){
        courseService.delete(id);
        return ResponseEntity.status(200).body( new ApiResponse("course deleted"));
    }

    @GetMapping("/teacher/{course_id}")
    public ResponseEntity<?> getTeacherName(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(courseService.getTeacherName(course_id));
    }

    @GetMapping("/students/{course_id}")
    public ResponseEntity<?> getStudents(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(courseService.getStudents(course_id));
    }

}
