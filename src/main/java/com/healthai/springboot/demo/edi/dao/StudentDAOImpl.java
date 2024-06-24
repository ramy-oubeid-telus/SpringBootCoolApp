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
        return entityManager.createQuery("from Student order by id desc", Student.class).getResultList();
    }

    @Override
    public List<Student> getStudentsByName(String lastName) {
        return entityManager.createQuery("from Student where lastName=:lastName", Student.class).setParameter("lastName", lastName).getResultList();
    }

    @Override
    public Student getStudentByLastName(String lastName) {
        return entityManager.createQuery("from Student where lastName=:lastName", Student.class).setParameter("lastName", lastName).getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
         entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public void deleteAllByLastName(String lastName) {
      int n=  entityManager.createQuery("DELETE FROM Student where lastName=:lastName").setParameter("lastName", lastName).executeUpdate();
        System.out.println("Number of records delected:" +
                ""+n);

    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();

    }

    @Override
    @Transactional
    public int delete(int id) {
        return entityManager.createQuery("DELETE FROM Student where id=:id").setParameter("id", id).executeUpdate();
    }


}
