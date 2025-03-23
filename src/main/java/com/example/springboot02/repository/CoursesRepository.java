package com.example.springboot02.repository;

import com.example.springboot02.model.dto.request.CourseRequest;
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

    @Select("""
    INSERT INTO courses(course_name, description ,instructor_id) VALUES (#{courseName}, #{description}, #{instructorId})
    RETURNING *
""")
    @ResultMap("coursesMapper")
    public Courses addCourses(CourseRequest courseRequest);

//    @Select("""
//    UPDATE courses SET courese_name = #{request.courseName}, description = #{request.description}, instructor_id = #{request.instructorId}
//    WHERE course_id = #{id}
//    RETURNING *
//""")
//    Courses updateCourse(Integer id, @Param("request")  CourseRequest courseRequest);
}
