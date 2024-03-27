package org.sophanit.service;

import org.sophanit.model.Course;
import org.sophanit.model.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(Integer id);

    Integer addNewCourse(CourseRequest courseRequest);
    Integer updateCourseById(CourseRequest courseRequest,Integer id);
    Integer deleteCourse(Integer id);
}
