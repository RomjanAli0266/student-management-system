package com.samsun.studentapp.mapper;

import com.samsun.studentapp.Student;
import com.samsun.studentapp.dto.StudentRequest;
import com.samsun.studentapp.dto.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {

        Student student = new Student();

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setCourse(request.getCourse());

        return student;
    }

    public StudentResponse toResponse(Student student) {

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }
}
