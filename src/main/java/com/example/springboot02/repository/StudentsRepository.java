package com.example.springboot02.repository;

import com.example.springboot02.model.dto.request.CourseRequest;
import com.example.springboot02.model.dto.request.StudentRequest;
import com.example.springboot02.model.entity.Courses;
import com.example.springboot02.model.entity.StudentCourses;
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

//    @Select("""
//    INSERT INTO students (student_name, student_email, phone_number) VALUES (#{studentName}, #{studentEmail}, #{phoneNumber});
//    RETURNING *;
//""")
//    @ResultMap("studentMapper")
//    Students addStudent(StudentRequest studentRequest);
//    @Select("""
//    INSERT INTO student_course (student_id, course_id) VALUES (#{studentId},#{courseId});
//    RETURNING *;
//""")
//    @ResultMap("studentMapper")
//    StudentCourses addCourse(Integer studentId, Integer courseId);

    @Select("""
    DELETE FROM students
    WHERE student_id = #{id}
    RETURNING *
""")
    @ResultMap("studentMapper")
    public Students deleteStudentById(Integer id);
}
