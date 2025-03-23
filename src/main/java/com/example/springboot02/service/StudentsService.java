package com.example.springboot02.service;

import com.example.springboot02.model.entity.Students;

import java.util.List;

public interface StudentsService {
    public List<Students> getAllStudents(Integer offset, Integer limit);
    public Students getStudentById(Integer id);
}
