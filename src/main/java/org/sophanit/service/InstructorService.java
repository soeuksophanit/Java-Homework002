package org.sophanit.service;

import org.sophanit.model.Instructor;
import org.sophanit.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor();
    Instructor getInstructorById(Integer id);

    Integer addNewInstructor(InstructorRequest instructorRequest);

    Integer deleteInstructorById(Integer id);
}
