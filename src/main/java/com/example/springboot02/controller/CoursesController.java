package com.example.springboot02.controller;

import com.example.springboot02.model.entity.Courses;
import com.example.springboot02.service.CoursesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {
    public final CoursesService coursesService;
    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }
    //getAllCourses
    @GetMapping
    public List<Courses> getAllCourses(@RequestParam(defaultValue = "1") Integer offset, @RequestParam(defaultValue = "10") Integer Limit) {
        return coursesService.getAllCourses(offset, Limit);
    }
}
