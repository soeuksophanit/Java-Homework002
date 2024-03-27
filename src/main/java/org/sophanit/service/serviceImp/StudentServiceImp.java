package org.sophanit.service.serviceImp;

import org.sophanit.model.Student;
import org.sophanit.model.request.StudentRequest;
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

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public Integer deleteStudentById(Integer id) {
        return studentRepository.deleteStudentById(id);
    }

    @Override
    public Integer addNewStudent(StudentRequest studentRequest) {
        return studentRepository.addNewStudent(studentRequest);
    }

    @Override
    public void addCourseList(Integer storeId, List<Integer> listCourses) {
        for (Integer course_id : listCourses){
            studentRepository.addCourseList(storeId,course_id);
        }
    }

    @Override
    public Integer updateStudent(Integer id, StudentRequest studentRequest) {
        return studentRepository.updateStudent(id,studentRequest);
    }

    @Override
    public void updateCourse(Integer id, List<Integer> oldId, StudentRequest studentRequest) {
        for (Integer newCourseId:studentRequest.getCourseId()){
            for (Integer old_id :oldId){
                studentRepository.updateCourse(id,old_id,newCourseId);
                break;
            }
        }
    }

//    @Override
//    public void updateCourse(Integer id, StudentRequest studentRequest) {
//        for (Integer newCourseId : studentRequest.getCourseId()){
////            studentRepository.updateCourse(id)
//        }
//    }

    @Override
    public List<Integer> findOldIdCourse(Integer id) {
        return studentRepository.findOldCourseId(id);
    }

}
