package org.sophanit.controller;

import org.sophanit.model.Instructor;
import org.sophanit.model.request.InstructorRequest;
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
        Instructor getInstructor = instructorService.getInstructorById(instructorId);
        if (getInstructor!=null){
            Response<Instructor> response = Response.<Instructor>builder()
                    .message("Get Instructor By ID")
                    .payload(instructorService.getInstructorById(instructorId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }else {
            Response<Instructor> response = Response.<Instructor>builder()
                    .message("Not Found Instructor")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Instructor>> updateInstructorById(@PathVariable("id") Integer instructorId,@RequestBody InstructorRequest instructorRequest){
        Integer storeId = instructorService.updateInstructor(instructorId,instructorRequest);
        Response<Instructor> response = null;
        if (storeId!=null){
            response = Response.<Instructor>builder()
                    .message("Update Successfully")
                    .payload(instructorService.getInstructorById(storeId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }else {
            response = Response.<Instructor>builder()
                    .message("Update Not Success")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Response<Instructor>> addNewInstructor(@RequestBody InstructorRequest instructorRequest){
        Integer storeNewId = instructorService.addNewInstructor(instructorRequest);
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
        Integer storeId = instructorService.deleteInstructorById(instructorId);
        Response<Instructor> response = null;
        if (storeId!=null){
            response = Response.<Instructor>builder()
                    .message("Delete Successfully")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .httpStatus(HttpStatus.OK)
                    .build();
            return ResponseEntity.ok(response);
        }else {
            response = Response.<Instructor>builder()
                    .message("Delete not Successfully")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(response);
        }


    }
}
