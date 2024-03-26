package org.sophanit.service.serviceImp;

import org.sophanit.model.Instructor;
import org.sophanit.repository.InstructorRepository;
import org.sophanit.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImp implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImp(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.getAllInstructor();
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.findInstructorById(id);
    }

    @Override
    public Integer addNewInstructor(Instructor instructor) {
        return instructorRepository.addInstructor(instructor);
    }
}
