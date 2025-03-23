package com.example.springboot02.controller;

import com.example.springboot02.model.dto.request.StudentRequest;
import com.example.springboot02.model.entity.StudentCourses;
import com.example.springboot02.model.entity.Students;
import com.example.springboot02.service.StudentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {
    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    //getAllStudents
    @GetMapping
    public List<Students> getAllStudents(@RequestParam(defaultValue = "1") Integer offset, @RequestParam(defaultValue = "10") Integer Limit) {
        return studentsService.getAllStudents(offset, Limit);
    }
    //getStudentById
    @GetMapping("/{student-id}")
    public Students getStudentById(@PathVariable ("student-id") Integer studentId) {
        return studentsService.getStudentById(studentId);
    }
    //AddStudent
//    @PostMapping
//    public Students addStudent(@RequestBody StudentRequest studentRequest) {
//        return null;
//    }
    //deleteStudentById
    @DeleteMapping("/{student-id}")
    public Students deleteStudentById(@PathVariable ("student-id") Integer studentId) {
        return studentsService.deleteStudentById(studentId);
    }
}
