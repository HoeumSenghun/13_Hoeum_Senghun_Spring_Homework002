package com.example.springboot02.repository;

import com.example.springboot02.model.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentsRepository {

    @Select("""
    SELECT st.student_id, st.student_name, st.email, st.phone_number, sc.course_id 
    FROM student_course sc 
        INNER JOIN students st ON sc.student_id = st.student_id
    offset #{page} limit #{limit}
""")
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentEmail", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "course_id",
            many= @Many(select = "com.example.springboot02.repository.CoursesRepository.getCourseById")
            )
    })
    List<Students> getAllStudents(Integer page, Integer limit);

    @Select("""
    SELECT st.student_id, st.student_name, st.email, st.phone_number, sc.course_id 
    FROM student_course sc 
        INNER JOIN students st ON sc.student_id = st.student_id WHERE st.student_id = #{id}
""")
    @ResultMap("studentMapper")
    Students getStudentById(Integer id);

}
