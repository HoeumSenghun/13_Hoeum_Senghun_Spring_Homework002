package com.example.springboot02.service;

import com.example.springboot02.model.dto.request.InstructorRequest;
import com.example.springboot02.model.entity.Instructors;

import java.util.List;

public interface InstructorsService {
    public List<Instructors> getAllInstructors();
    public Instructors createInstructor(InstructorRequest instructorRequest);
    public Instructors getInstructorById(Integer id);
}
