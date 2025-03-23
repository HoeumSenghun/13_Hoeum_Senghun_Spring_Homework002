package com.example.springboot02.controller;

import com.example.springboot02.model.dto.request.CourseRequest;
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
    //post
    @PostMapping
    public Courses addCourse(@RequestBody CourseRequest courseRequest) {
        return coursesService.addCourse(courseRequest);
    }
    //update
    @PutMapping("/{course-id}")
    public Courses updateCourse(@PathVariable ("course-id") Integer id, @RequestBody CourseRequest courseRequest) {
        return coursesService.updateCourse(id,courseRequest);
    }
//    getcourseid
    @GetMapping("/{course-id}")
    public Courses getCourseById(@PathVariable ("course-id") Integer id) {
        return coursesService.getCourseById(id);
    }
    //delete
//    @DeleteMapping("/{course-id}")
//    public Courses deleteCourse(@PathVariable ("course-id") Integer id) {
//        return coursesService.deleteCourse(id);
//    }
}
