package com.healthai.springboot.demo.edi.dao;

import com.healthai.springboot.demo.edi.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;


    //inject the entity manager


    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement the save student method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);


    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findALl() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }
}
