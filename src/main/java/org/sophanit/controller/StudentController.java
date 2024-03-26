package org.sophanit.controller;

import org.sophanit.model.Student;
import org.sophanit.model.response.Response;
import org.sophanit.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/")
    public ResponseEntity<Response<List<Student>>> getAllAuthor(){
        Response<List<Student>> response = Response.<List<Student>>builder()
                .message("Get data success")
                .payload(studentService.getAllStudents())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }
}
