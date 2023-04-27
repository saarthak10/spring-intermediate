package com.learn.cruddemo.rest.controller;

import com.learn.cruddemo.rest.entity.StudentDetails;
import com.learn.cruddemo.rest.exception.StudentErrorResponse;
import com.learn.cruddemo.rest.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class DemoApiController {
    ArrayList<StudentDetails> students = new ArrayList<StudentDetails>();
    StudentDetails student = new StudentDetails("Jack","Alison","jack12@yopmail.com");

    public DemoApiController(){

    }

    @PostConstruct
    private void postConstruct(){
        students.add(student);
        student = new StudentDetails("Jim","Carry","jim23@yopmail.com");
        students.add(student);
        student = new StudentDetails("alex","Benjamin","alex11@yopmail.com");
        students.add(student);
    }


    @GetMapping("/students")
    public ArrayList<StudentDetails> getAllStudents() {

        return students;
        //students.add();
    }
    @GetMapping("/students/{studentId}")
    public StudentDetails getStudentInfo(@PathVariable int studentId){

        if (studentId > students.size() -1 || studentId < 0){
            throw new StudentNotFoundException("The student with id " + studentId + " was not found!");
        }

        return students.get(studentId);
    }

    /**
     * These exception handlers are only limited to this controller ,
     * thus we need to create a global exception handler using @ControllerAdvice annotation
     * @param exc
     * @return
     */
  /*  // exception handler for handling student id not found
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
            StudentErrorResponse error = new StudentErrorResponse();
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setMessage(exc.getMessage());
            error.setTimestamp(System.currentTimeMillis());

            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }*/

    //another exception handler for catching all other exceptions
   /* @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }*/

}
