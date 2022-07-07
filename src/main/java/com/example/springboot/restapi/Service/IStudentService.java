package com.example.springboot.restapi.Service;

import com.example.springboot.restapi.Model.Student;

import java.util.List;

public interface IStudentService {

    //create
    public Student saveStudent(Student student);

    //retrieve
    public List<Student> getStudents();
    public Student getStudentById(String studentID);

    //update
    public Student updateStudent(Student student);

    //delete
    public void deleteStudent(Student student);
    public void deleteStudentById(String studentID);

}
