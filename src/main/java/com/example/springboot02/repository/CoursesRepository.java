package com.example.springboot02.repository;

import com.example.springboot02.model.entity.Courses;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CoursesRepository {

    @Select("""
    SELECT * FROM courses
    offset #{page} limit #{limit}
""")
    @Results(id = "coursesMapper", value = {
            @Result(property= "courseId", column = "course_id"),
            @Result(property= "courseName", column = "course_name"),
            @Result(property= "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id", one = @One (select = "com.example.springboot02.repository.InstructorsRepository.getInstructorById"))
    })
    public List<Courses> getAllCourses(Integer page, Integer limit);
}
