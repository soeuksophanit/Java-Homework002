package org.sophanit.service;

import org.sophanit.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor();
    Instructor getInstructorById(Integer id);

    Integer addNewInstructor(Instructor instructor);
}
