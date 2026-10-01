package com.example.exercisew8d4.Controller;

import com.example.exercisew8d4.Api.ApiResponse;
import com.example.exercisew8d4.Model.Teacher;
import com.example.exercisew8d4.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")

public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.status(200).body( teacherService.get());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid Teacher teacher ){
        teacherService.add(teacher);
        return ResponseEntity.status(200).body( new ApiResponse("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid Teacher teacher ){
        teacherService.update(id,teacher);
        return ResponseEntity.status(200).body( new ApiResponse("teacher updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id ){
        teacherService.delete(id);
        return ResponseEntity.status(200).body( new ApiResponse("teacher deleted"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable Integer id ){
        return ResponseEntity.status(200).body( teacherService.getTeacher(id) );
    }


}