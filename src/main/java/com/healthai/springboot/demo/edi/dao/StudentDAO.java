package com.healthai.springboot.demo.edi.dao;

import com.healthai.springboot.demo.edi.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student getStudentById(int i);

    List<Student> findALl();
    List<Student> getStudentsByName(String s);
    Student getStudentByLastName(String s);
    void update(Student student);
    void delete(Student student);
    void deleteAllByLastName(String lastName);
    int deleteAll();

    int delete(int id);
}
