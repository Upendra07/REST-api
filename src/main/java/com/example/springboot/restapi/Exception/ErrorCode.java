package com.example.springboot.restapi.Exception;

public enum ErrorCode {

    NOTAVAILABLE("Not_available","Resource requested is not available"),
    CASTINGERROR("casting_error","Please give valid input"),
    GENERALERROR("General","Something went wrong"),
    ILLEGALARG("Illegal_arg","Illegal argument error"),
    NONAME("no_student_name","student name must not be empty")
    ;

    final String code;
    final String description;

    ErrorCode(String code,String description){
        this.description = description;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
