package com.example.springboot.restapi.Model;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @SequenceGenerator(
            name="sequence_generator",
            allocationSize = 1,
            sequenceName = "sequence_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_generator"
    )
    private Long id;
    @NotNull
    private String studentName;
    private String studentAddress;
    private Integer rollNumber;
    private Long phoneNumber;

    public Student(String studentName, String studentAddress, Integer rollNumber, Long phoneNumber) {

        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.rollNumber = rollNumber;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Student() {
        super();
    }
}
