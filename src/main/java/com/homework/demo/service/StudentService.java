package com.homework.demo.service;

import com.homework.demo.dto.StudentDto;
import com.homework.demo.model.Student;
import com.homework.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getById(Integer id){
        return studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                "Student with given id was not found"));
    }

    public List<Student> getAll(){
        return (List<Student>) studentRepository.findAll();
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public void deleteById(Integer id){
        studentRepository.deleteById(id);
    }

}
