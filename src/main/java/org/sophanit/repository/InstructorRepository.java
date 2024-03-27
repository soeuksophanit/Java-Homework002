package org.sophanit.repository;

import org.apache.ibatis.annotations.*;
import org.sophanit.model.Instructor;
import org.sophanit.model.request.InstructorRequest;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("SELECT * FROM instructors")
    @Results(
            id = "instructorMapper",
            value = {
                    @Result(property = "instructorId",column = "instructor_id"),
                    @Result(property = "instructorName",column = "instructor_name"),
                    @Result(property = "email",column = "email")
            }
    )
    List<Instructor> getAllInstructor();


    @Select("SELECT * FROM instructors WHERE instructor_id=#{id}")
    @ResultMap("instructorMapper")
    Instructor findInstructorById(Integer id);


    @Select("INSERT INTO instructors VALUES (DEFAULT,#{request.instructor_name},#{request.email}) RETURNING instructor_id")
    Integer addInstructor(@Param("request") InstructorRequest instructorRequest);

    @Select("DELETE FROM instructors WHERE instructor_id=#{id}")
    Integer deleteInstructorById(Integer id);
}
