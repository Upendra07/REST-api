package com.example.springboot.restapi.Controller;


import com.example.springboot.restapi.Exception.BusinessException;
import com.example.springboot.restapi.Model.Student;
import com.example.springboot.restapi.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student){

        try{

            Student st = studentService.saveStudent(student);
            return new ResponseEntity<Student>(st, HttpStatus.ACCEPTED);

        }catch (BusinessException e){

            return new ResponseEntity<BusinessException>(e,HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping
    public ResponseEntity<?> getStudents(){

        try {

            return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);

        }catch (BusinessException e){

            return new ResponseEntity<BusinessException>(e, HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/{studentID}")
    public ResponseEntity<?> getStudentById(@PathVariable String studentID){

        try{
            return new ResponseEntity<Student>(studentService.getStudentById(studentID), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity<BusinessException>(e,HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping
    public ResponseEntity<?> putStudent(@RequestBody Student student){

        try{
            return new ResponseEntity<Student>(studentService.updateStudent(student),HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity<BusinessException>(e,HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestBody Student student){

        try{
            studentService.deleteStudent(student);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity<BusinessException>(e,HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("{studentID}")
    public ResponseEntity<?> deleteStudentByID(@PathVariable String studentID){
        try {
            studentService.deleteStudentById(studentID);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity<BusinessException>(e,HttpStatus.BAD_REQUEST);
        }
    }

}
