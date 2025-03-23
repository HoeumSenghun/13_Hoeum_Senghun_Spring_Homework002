package com.example.springboot02.service;

import com.example.springboot02.model.dto.request.CourseRequest;
import com.example.springboot02.model.entity.Courses;

import java.util.List;

public interface CoursesService {
    public List<Courses> getAllCourses(Integer offset, Integer limit);

    public Courses addCourse(CourseRequest courseRequest);

//    public Courses updateCourse(Integer id, CourseRequest courseRequest);
}
