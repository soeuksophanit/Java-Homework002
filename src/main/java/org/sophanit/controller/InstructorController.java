package org.sophanit.controller;

import org.sophanit.model.Instructor;
import org.sophanit.model.response.Response;
import org.sophanit.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Instructor>>> getAllInstructors(){
        Response<List<Instructor>> response = Response.<List<Instructor>>builder()
                .message("Get data success")
                .payload(instructorService.getAllInstructor())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Instructor>> getInstructorById(@PathVariable("id") Integer instructorId){
        Response<Instructor> response = Response.<Instructor>builder()
                .message("Get Instructor By ID")
                .payload(instructorService.getInstructorById(instructorId))
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Instructor>> updateInstructorById(@PathVariable("id") Integer instructorId){
        return null;

    }

    @PostMapping("/")
    public ResponseEntity<Response<Instructor>> addNewInstructor(@RequestBody Instructor instructor){
        Integer storeNewId = instructorService.addNewInstructor(instructor);
        Response<Instructor> response = null;
        if (storeNewId != null){
            response = Response.<Instructor>builder()
                    .message("Add new Instructor")
                    .payload(instructorService.getInstructorById(storeNewId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);

        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Instructor>> deleteInstructorById(@PathVariable("id") Integer instructorId){
        return null;

    }
}
