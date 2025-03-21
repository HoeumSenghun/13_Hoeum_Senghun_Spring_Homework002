package com.example.springboot02.service.Impl;

import com.example.springboot02.model.entity.Instructors;
import com.example.springboot02.repository.InstructorsRepository;
import com.example.springboot02.service.InstructorsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorsServiceImpl implements InstructorsService {
    private final InstructorsRepository instructorsRepository;
    public InstructorsServiceImpl (InstructorsRepository instructorsRepository){
        this.instructorsRepository = instructorsRepository;
    }
    @Override
    public List<Instructors> getAllInstructors() {
        return instructorsRepository.getAllInstructors();
    }
}
