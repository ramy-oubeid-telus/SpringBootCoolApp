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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private static final Logger log = LoggerFactory.getLogger(StudentRestController.class);
    public StudentDAO studentDAO;

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

        return count > 0;

    }


}
