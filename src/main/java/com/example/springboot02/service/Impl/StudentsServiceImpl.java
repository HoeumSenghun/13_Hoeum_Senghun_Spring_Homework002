package com.example.springboot02.service.Impl;

import com.example.springboot02.model.dto.request.StudentRequest;
import com.example.springboot02.model.entity.Students;
import com.example.springboot02.repository.CoursesRepository;
import com.example.springboot02.repository.StudentsRepository;
import com.example.springboot02.service.StudentsService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;
    private final CoursesRepository coursesRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository, CoursesRepository coursesRepository) {
        this.studentsRepository = studentsRepository;
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Students> getAllStudents(Integer offset, Integer limit) {
        Integer page = (offset - 1) * limit;
        return studentsRepository.getAllStudents(page, limit);
    }

    @Override
    public Students getStudentById(Integer id) {
        return studentsRepository.getStudentById(id);
    }

//    @Override
//    public Students addStudent(StudentRequest studentRequest) {
//        Students students = studentsRepository.addStudent(studentRequest);
//        for (Integer courseId : studentRequest.getCourseId()){
//            coursesRepository.addCourses(studentRequest.getCourseId());
//        }
//        return studentsRepository.addStudent(studentRequest);
//    }
    @Override
    public Students deleteStudentById(Integer id) {
        return studentsRepository.getStudentById(id);
    }

}
