package org.sophanit.service;

import org.sophanit.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(Integer id);
}
