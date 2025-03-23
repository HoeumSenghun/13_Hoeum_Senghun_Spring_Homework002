package com.example.springboot02.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourses {
    private Integer studentCourseId;
    private Integer studentId;
    private Integer courseId;
}
