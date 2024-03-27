package org.sophanit.service;

import org.sophanit.model.Student;
import org.sophanit.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    Integer deleteStudentById(Integer id);

    Integer addNewStudent(StudentRequest studentRequest);

    void addCourseList(Integer storeId,List<Integer> listCourses);

    Integer updateStudent(Integer id,StudentRequest studentRequest);

    void updateCourse(Integer id,List<Integer> oldId,StudentRequest studentRequest);

    List<Integer> findOldIdCourse(Integer id);
}
