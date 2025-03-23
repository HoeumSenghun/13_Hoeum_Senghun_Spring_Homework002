package com.example.springboot02.service.Impl;

import com.example.springboot02.model.dto.request.InstructorRequest;
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
    public List<Instructors> getAllInstructors(Integer offset, Integer limit) {
        Integer page = (offset - 1) * limit;
        return instructorsRepository.getAllInstructors(page,limit);
    }

    @Override
    public Instructors createInstructor(InstructorRequest instructorRequest) {
        return instructorsRepository.createInstructor(instructorRequest);
    }

    @Override
    public Instructors getInstructorById(Integer id) {
        return instructorsRepository.getInstructorById(id);
    }

    @Override
    public Instructors updateInstructorById(Integer instructorId, InstructorRequest instructorsRequest) {
        return instructorsRepository.updateInstructorById(instructorId,instructorsRequest);
    }

    @Override
    public Instructors deleteInstructorById(Integer id) {
        return instructorsRepository.deleteInstructorById(id);
    }


}
