package com.example.springboot.restapi.Repository;

import com.example.springboot.restapi.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {



}
