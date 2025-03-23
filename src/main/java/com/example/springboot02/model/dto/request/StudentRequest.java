package com.example.springboot02.model.dto.request;

import com.example.springboot02.model.entity.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String studentEmail;
    private String phoneNumber;
    private List<Integer> courseId;
}
