package org.sophanit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    @GetMapping("/")
    public ResponseEntity<?> getAllInstructors(){

        return ResponseEntity.ok(null);
    }
}
