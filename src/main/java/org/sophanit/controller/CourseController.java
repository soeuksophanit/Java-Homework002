package org.sophanit.controller;

import org.sophanit.model.Course;
import org.sophanit.model.Instructor;
import org.sophanit.model.response.Response;
import org.sophanit.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Course>>> getAllCourses(){
        Response<List<Course>> response = Response.<List<Course>>builder()
                .message("Get data success")
                .payload(courseService.getAllCourses())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Course>> getCourseById(@PathVariable("id") Integer instructorId){
        Response<Course> response = Response.<Course>builder()
                .message("Get Course By ID")
                .payload(courseService.getCourseById(instructorId))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Course>> updateCourseById(@PathVariable("id") Integer instructorId){
        return null;

    }

    @PostMapping("/")
    public ResponseEntity<Response<Course>> addNewCourse(@RequestBody Course course){
        return null;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Course>> deleteCourseById(@PathVariable("id") Integer instructorId){
        return null;

    }
}
