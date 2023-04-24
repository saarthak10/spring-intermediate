package com.learn.cruddemo.dao;

import com.learn.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    //method for saving the data to database
    void save(Student theStudent);
    //method for retrieving data on basis of id
    Student  findById(int id);

    //method for fetching records on basis of JPAQL
    List<Student> findAll();

    //method for updating a student
    Student update(Student theStudent);

    //method for deleting a student
    void delete(int id);
}
