package com.example.springboot02.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructors {
    private int instructorId;
    private String instructorName;
    private String instructorEmail;
}