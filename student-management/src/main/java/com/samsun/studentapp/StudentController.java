package com.samsun.studentapp;

import com.samsun.studentapp.dto.StudentRequest;
import com.samsun.studentapp.dto.StudentResponse;
import com.samsun.studentapp.mapper.StudentMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService service;

    private final StudentMapper mapper;

    public StudentController(StudentService service,
                             StudentMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> saveStudent(
            @Valid @RequestBody StudentRequest request) {


        Student student = mapper.toEntity(request);

        Student savedStudent= service.saveStudent(student);

        // Conversion code
        StudentResponse response = mapper.toResponse(savedStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(savedStudent));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {

        List<Student> students = service.getAllStudents();

        List<StudentResponse> responses = students.stream()
                .map(student -> mapper.toResponse(student))
                .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(
            @PathVariable Long id) {

        Student student = service.getStudentById(id);

        StudentResponse response = mapper.toResponse(student);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id,
                                                 @Valid @RequestBody StudentRequest request) {

        Student updatedStudent = mapper.toEntity(request);

        Student savedStudent = service.updateStudent(id, updatedStudent);

        StudentResponse response = mapper.toResponse(savedStudent);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {
        
        service.deleteStudent(id);

        return ResponseEntity.noContent().build();

    }
}
