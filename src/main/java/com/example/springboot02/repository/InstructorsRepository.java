package com.example.springboot02.repository;

import com.example.springboot02.model.entity.Instructors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InstructorsRepository {

    @Select("""
    SELECT * FROM instructors;
""")
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "instructorEmail", column = "email")

    })
    public List<Instructors> getAllInstructors();
}
