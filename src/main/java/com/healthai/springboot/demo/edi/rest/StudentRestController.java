/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.healthai.springboot.demo.edi.rest;

import com.healthai.springboot.demo.edi.dao.StudentDAO;
import com.healthai.springboot.demo.edi.dao.StudentDAOImpl;
import com.healthai.springboot.demo.edi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private static final Logger log = LoggerFactory.getLogger(StudentRestController.class);
    private StudentDAO studentDAO;
    private List<Student> theStudents;


    @Autowired
    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;

    }



    //define endpoint for "/students" - return a list of students
    @GetMapping("/getStudents")
    public List<Student> getStudents() {
//        Student s1 = new Student("Ramy","Oubeid","ramy.oubeid@gmail.com");
//        studentDAO.save(s1);
//        Student s2 = new Student("Jean","Vandam","jean@gmail.com");
//        studentDAO.save(s2);
        return studentDAO.findALl();

    }
    //define an endpoint for deleting a student by id and return the number of students deleted
    @GetMapping("/deleteStudent/{id}")
    public Boolean deleteStudent(@PathVariable int id) {

        log.info("Deleting student with id: " + id);

        int count = studentDAO.delete(id);
        //If return true then log.info("Student deleted successfully") else log.info("Student not found")

        return (count > 0);




    }

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel","poornima.patel@gmail.com"));
        theStudents.add(new Student("Mario", "Rossi", "mario.rossi@gmail.com"));
        theStudents.add(new Student("Mary", "Smith", "mary.smith@gmail.com"));
        theStudents.add(new Student("Tom", "Tatters", "tom.tatters@gmail.com"));
    }
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        log.info("Retrieving student with id: " + studentId);
        if (studentId >= theStudents.size() || studentId < 0){
            log.error("Student id not found - " + studentId);
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(Instant.now());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }




}
