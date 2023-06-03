package com.homework.demo.mapper;

import com.homework.demo.dto.StudentDto;
import com.homework.demo.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto toDto(Student student){
        return new StudentDto(student.getId(), student.getFirstName(), student.getAge());
    }

    public Student toEntity(StudentDto dto){
        Student entity = new Student();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setAge(dto.getAge());
        return entity;
    }
}
