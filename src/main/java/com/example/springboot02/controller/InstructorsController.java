package com.example.springboot02.controller;

import com.example.springboot02.model.dto.request.InstructorRequest;
import com.example.springboot02.model.entity.Instructors;
import com.example.springboot02.service.InstructorsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorsController {
    private final InstructorsService instructorsService;

    public InstructorsController(InstructorsService instructorsService) {
        this.instructorsService = instructorsService;
    }
    //getAllInstructors
    @GetMapping
    public List<Instructors> getAllInstructors(@RequestParam(defaultValue = "1") Integer offset, @RequestParam(defaultValue = "10") Integer Limit){
        return instructorsService.getAllInstructors();
    }
    //postInstructor
    @PostMapping
    public Instructors createInstructor(@RequestBody InstructorRequest instructorsRequest){
        return instructorsService.createInstructor(instructorsRequest);
    }
    //getInstructorById
    @GetMapping("/{instructor-id}")
    public Instructors getInstructorById(@PathVariable("instructor-id") Integer instructorId){
        return instructorsService.getInstructorById(instructorId);
    }
    //updateInstructorById
    @PutMapping("/{instructor-id}")
    public Instructors updateInstructorById(@RequestBody InstructorRequest instructorsRequest, @PathVariable("instructor-id") Integer instructorId){
        return instructorsService.updateInstructorById(instructorId,instructorsRequest);
    }
    @DeleteMapping("/{instructor-id}")
    public Instructors deleteInstructorById(@PathVariable("instructor-id") Integer id){
        return instructorsService.deleteInstructorById(id);
    }

}
 