package com.example.springboot02.controller;

import com.example.springboot02.model.entity.Students;
import com.example.springboot02.service.StudentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
