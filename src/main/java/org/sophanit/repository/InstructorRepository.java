package org.sophanit.repository;

import org.apache.ibatis.annotations.*;
import org.sophanit.model.Instructor;

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


    @Select("INSERT INTO instructors VALUES (DEFAULT,#{instructor.instructorName},#{instructor.email}) RETURNING instructor_id")
    @ResultMap("instructorMapper")
    Integer addInstructor(Instructor instructor);
}
