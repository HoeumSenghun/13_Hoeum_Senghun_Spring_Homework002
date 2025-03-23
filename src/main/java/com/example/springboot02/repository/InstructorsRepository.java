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

    @Select("""
    SELECT * FROM instructors WHERE instructor_id = #{id}
""")
    @ResultMap("instructorMapper")
    public Instructors getInstructorById(Integer id);


    @Select("""
    UPDATE instructors 
    SET instructor_name = #{request.instructorName}, email = #{request.instructorEmail}
    WHERE instructor_id = #{id} RETURNING *
""")
    @ResultMap("instructorMapper")
    public Instructors updateInstructorById(Integer id,@Param("request") InstructorRequest instructorsRequest);

    @Select("""
    DELETE FROM instructors 
    WHERE instructor_id = #{id} RETURNING *
""")
    @ResultMap("instructorMapper")
    public Instructors deleteInstructorById(Integer id);
}
