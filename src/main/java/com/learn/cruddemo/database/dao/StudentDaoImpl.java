package com.learn.cruddemo.database.dao;

import com.learn.cruddemo.database.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student update(Student theStudent) {
        return entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }
}
