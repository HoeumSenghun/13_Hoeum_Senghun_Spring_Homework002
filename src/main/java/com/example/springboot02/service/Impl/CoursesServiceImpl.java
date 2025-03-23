package com.example.springboot02.service.Impl;

import com.example.springboot02.model.dto.request.CourseRequest;
import com.example.springboot02.model.entity.Courses;
import com.example.springboot02.repository.CoursesRepository;
import com.example.springboot02.service.CoursesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    public final CoursesRepository coursesRepository;
    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Courses> getAllCourses(Integer offset, Integer limit) {
        Integer page = (offset - 1) * limit;
        return coursesRepository.getAllCourses(page, limit);
    }

    @Override
    public Courses addCourse(CourseRequest courseRequest) {
        return coursesRepository.addCourses(courseRequest);
    }

    @Override
    public Courses updateCourse(Integer id, CourseRequest courseRequest) {
        return coursesRepository.updateCourse(id, courseRequest);
    }

    @Override
    public Courses getCourseById(Integer id) {
        return coursesRepository.getCourseById(id);
    }

    @Override
    public Courses deleteCourse(Integer id) {
        return coursesRepository.deleteCourse(id);
    }
}
