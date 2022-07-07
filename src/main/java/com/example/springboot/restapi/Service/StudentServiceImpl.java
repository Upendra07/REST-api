package com.example.springboot.restapi.Service;

import com.example.springboot.restapi.Exception.BusinessException;
import com.example.springboot.restapi.Exception.ErrorCode;
import com.example.springboot.restapi.Model.Student;
import com.example.springboot.restapi.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {


        if(student.getStudentName().isEmpty() || student.getStudentName() == null )
            throw new BusinessException(ErrorCode.NONAME.getCode(), ErrorCode.NONAME.getDescription());

        try{
            return studentRepository.save(student);
        }catch (IllegalArgumentException e){
            throw new BusinessException(ErrorCode.ILLEGALARG.getCode(), ErrorCode.ILLEGALARG.getDescription());
        }catch (Exception e){
            throw new BusinessException(ErrorCode.GENERALERROR.getCode(), ErrorCode.GENERALERROR.getDescription());
        }

    }

    @Override
    public List<Student> getStudents(){

        if(studentRepository.findAll().isEmpty()) throw new BusinessException(ErrorCode.NOTAVAILABLE.getCode(),ErrorCode.NOTAVAILABLE.getDescription());
        return studentRepository.findAll();

    }

    @Override
    public Student getStudentById(String studentID) {

        Optional<Student> student = studentRepository.findById(Long.parseLong(studentID));
        if(student.isEmpty()){
            throw new BusinessException(ErrorCode.NOTAVAILABLE.getCode(),ErrorCode.NOTAVAILABLE.getDescription());
        }
        return student.get();
    }

    @Override
    public Student updateStudent(Student student) {

        if(student.getStudentName().isEmpty() || student.getStudentName() == null )
            throw new BusinessException(ErrorCode.NONAME.getCode(), ErrorCode.NONAME.getDescription());

        try{
            return studentRepository.save(student);
        }catch (IllegalArgumentException e){
            throw new BusinessException(ErrorCode.ILLEGALARG.getCode(), ErrorCode.ILLEGALARG.getDescription());
        }catch (Exception e){
            throw new BusinessException(ErrorCode.GENERALERROR.getCode(), ErrorCode.GENERALERROR.getDescription()+e.getLocalizedMessage());
        }

    }

    @Override
    public void deleteStudent(Student student) {

        try {
            studentRepository.delete(student);
        }catch (Exception e){
            throw new BusinessException(ErrorCode.GENERALERROR.getCode(), ErrorCode.GENERALERROR.getDescription()+e.getLocalizedMessage());
        }

    }

    @Override
    public void deleteStudentById(String studentID) {
        try {
            studentRepository.deleteById(Long.parseLong(studentID));
        }catch (NumberFormatException ne){
            throw new BusinessException(ErrorCode.CASTINGERROR.getCode(), ErrorCode.CASTINGERROR.getDescription());
        } catch (Exception e){
            throw new BusinessException(ErrorCode.GENERALERROR.getCode(), ErrorCode.CASTINGERROR.getDescription());
        }
    }


}
