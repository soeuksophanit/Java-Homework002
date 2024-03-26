package org.sophanit.service.serviceImp;

import org.sophanit.model.Student;
import org.sophanit.repository.StudentRepository;
import org.sophanit.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAllStudents();
    }
}
