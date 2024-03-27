package org.sophanit.controller;

import org.sophanit.model.Course;
import org.sophanit.model.Instructor;
import org.sophanit.model.request.CourseRequest;
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
    public ResponseEntity<Response<Course>> getCourseById(@PathVariable("id") Integer courseId){
        Response<Course> response = Response.<Course>builder()
                .message("Get Course By ID")
                .payload(courseService.getCourseById(courseId))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Course>> updateCourseById(@PathVariable("id") Integer courseId,@RequestBody CourseRequest courseRequest){
        Integer storeId = courseService.updateCourseById(courseRequest,courseId);
        Response<Course> response = null;
        if (storeId!=null){
            response = Response.<Course>builder()
                    .message("Update Successfully")
                    .payload(courseService.getCourseById(storeId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return null;

    }

    @PostMapping("/")
    public ResponseEntity<Response<Course>> addNewCourse(@RequestBody CourseRequest courseRequest){
        Integer storeId = courseService.addNewCourse(courseRequest);
        Response<Course> response = null;
        if (storeId!=null){
            response = Response.<Course>builder()
                    .message("Add new course successfully")
                    .payload(courseService.getCourseById(storeId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
        return null;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Course>> deleteCourseById(@PathVariable("id") Integer courseId){

        return null;

    }
}
