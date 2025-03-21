package com.example.springboot02.controller;

import com.example.springboot02.model.entity.Instructors;
import com.example.springboot02.service.InstructorsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorsController {
    private final InstructorsService instructorsService;

    public InstructorsController(InstructorsService instructorsService) {
        this.instructorsService = instructorsService;
    }

    @GetMapping
    public List<Instructors> getAllInstructors(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "5") Integer Limit){
        return instructorsService.getAllInstructors();
    }

}
