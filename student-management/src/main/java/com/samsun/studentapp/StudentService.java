package com.samsun.studentapp;

import com.samsun.studentapp.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {


    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->
                        new StudentNotFoundException(
                                "Student not found with id: " + id
                        )
                );

    }

    public Student updateStudent(Long id, Student newStudent) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " +id
                        )
                );


            existingStudent.setName(newStudent.getName());
            existingStudent.setEmail(newStudent.getEmail());
            existingStudent.setCourse(newStudent.getCourse());

            return repository.save(existingStudent);


    }

    public void deleteStudent(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " +id
                        )
                );
        repository.delete(student);

    }
}
