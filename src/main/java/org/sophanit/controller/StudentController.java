package org.sophanit.controller;

import org.sophanit.model.Student;
import org.sophanit.model.request.StudentRequest;
import org.sophanit.model.response.Response;
import org.sophanit.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/")
    public ResponseEntity<Response<List<Student>>> getAllStudent(){
        Response<List<Student>> response = Response.<List<Student>>builder()
                .message("Get data success")
                .payload(studentService.getAllStudents())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response<Student>> getStudentById(@PathVariable("id") Integer studentId){
        Student getStudent = studentService.getStudentById(studentId);
        Response<Student> response;
        if (getStudent!=null){
            response = Response.<Student>builder()
                    .message("Get Student By ID")
                    .payload(studentService.getStudentById(studentId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }else {
            response = Response.<Student>builder()
                    .message("Student Not found")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(response);


    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Student>> updateStudentById(@PathVariable("id") Integer studentId,@RequestBody StudentRequest studentRequest){
        Integer storeId = studentService.updateStudent(studentId,studentRequest);
        List<Integer> oldCourseListId = studentService.findOldIdCourse(storeId);
        studentService.updateCourse(storeId,oldCourseListId,studentRequest);
        studentService.addCourseList(storeId,studentRequest.getCourseId());
        Response<Student> response = null;
        if (storeId!=null){
            response = Response.<Student>builder()
                    .message("Updated Successfully")
                    .payload(studentService.getStudentById(storeId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }else {
            response = Response.<Student>builder()
                    .message("Updated not Success")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Response<Student>> addNewStudent(@RequestBody StudentRequest studentRequest){
        Integer storeId = studentService.addNewStudent(studentRequest);
        studentService.addCourseList(storeId,studentRequest.getCourseId());
        Response<Student> response = null;
        if (storeId!=null){
            response = Response.<Student>builder()
                    .message("Adding new Student Successfully")
                    .payload(studentService.getStudentById(storeId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }else {
            response = Response.<Student>builder()
                    .message("Can Not add new student")
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Student>> deleteStudentById(@PathVariable("id") Integer studentId){
        Integer storeId = studentService.deleteStudentById(studentId);
        Response<Student> response = null;
        if (storeId!=null){
            response = Response.<Student>builder()
                    .message("Delete Successfully")
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }else {
            response = Response.<Student>builder()
                    .message("Not found to delete")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }
    }
}
