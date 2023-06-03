package com.homework.demo.controller;

import com.homework.demo.dto.StudentDto;
import com.homework.demo.mapper.StudentMapper;
import com.homework.demo.model.Student;
import com.homework.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(value = "id") final Integer id) {

        StudentDto studentFound = studentMapper.toDto(studentService.getById(id));
        return ResponseEntity
                .ok()
                .body(studentFound);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<StudentDto>> getAll(){

        List<StudentDto> list = studentService.getAll().stream().map(studentMapper::toDto).toList();
        return ResponseEntity
                .ok()
                .body(list);
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<StudentDto> saveNewStudent(@RequestBody StudentDto studentDto) {

        Student savedStudent = studentService.save(studentMapper.toEntity(studentDto));
        return ResponseEntity
                .ok()
                .body(studentMapper.toDto(savedStudent));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Integer> deleteById(@PathVariable(value = "id") final Integer id){

        studentService.deleteById(id);
        return ResponseEntity
                .ok()
                .body(id);
    }

    @PatchMapping(produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {

        Student updatedStudent = studentService.save(studentMapper.toEntity(studentDto));
        return ResponseEntity
                .ok()
                .body(studentMapper.toDto(updatedStudent));
    }

}
