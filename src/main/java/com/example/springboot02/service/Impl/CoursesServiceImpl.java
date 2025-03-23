package com.example.springboot02.service.Impl;

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
    public List<Courses> getAllCourses() {
        return coursesRepository.getAllCourses();
    }
}
