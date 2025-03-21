package com.example.springboot02.repository;

import com.example.springboot02.model.dto.request.InstructorRequest;
import com.example.springboot02.model.entity.Instructors;
import org.apache.ibatis.annotations.*;

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

    @Select("""
    INSERT INTO instructors(instructor_name, email) VALUES(#{request.instructorName}, #{request.instructorEmail})
    returning *
""")
    @ResultMap("instructorMapper")
    public Instructors createInstructor(@Param("request" ) InstructorRequest instructorRequest);
}
