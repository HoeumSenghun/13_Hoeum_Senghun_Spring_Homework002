package com.example.springboot02.repository;

import com.example.springboot02.model.entity.Courses;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CoursesRepository {

    @Select("""
    SELECT * FROM courses;
""")
    @Results(id = "coursesMapper", value = {
            @Result(property= "courseId", column = "course_id"),
            @Result(property= "courseName", column = "course_name"),
            @Result(property= "description", column = "description")
    })
    public List<Courses> getAllCourses();
}
