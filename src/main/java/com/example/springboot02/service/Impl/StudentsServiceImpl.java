package com.example.springboot02.service.Impl;

import com.example.springboot02.model.entity.Students;
import com.example.springboot02.repository.StudentsRepository;
import com.example.springboot02.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Students> getAllStudents(Integer offset, Integer limit) {
        Integer page = (offset - 1) * limit;
        return studentsRepository.getAllStudents(page, limit);
    }
}
