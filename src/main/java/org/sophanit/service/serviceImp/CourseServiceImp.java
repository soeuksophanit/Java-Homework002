package org.sophanit.service.serviceImp;

import org.sophanit.model.Course;
import org.sophanit.model.request.CourseRequest;
import org.sophanit.repository.CourseRepository;
import org.sophanit.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.findCourseById(id);
    }

    @Override
    public Integer addNewCourse(CourseRequest courseRequest) {
        return courseRepository.addNewCourse(courseRequest);
    }

    @Override
    public Integer updateCourseById(CourseRequest courseRequest,Integer id) {
        return courseRepository.updateCourse(courseRequest,id);
    }
}
