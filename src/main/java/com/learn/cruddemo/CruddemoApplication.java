package com.learn.cruddemo;

import com.learn.cruddemo.entity.Student;
import com.learn.cruddemo.dao.StudentDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            System.out.println("Hello world");
            //createNewStudent(studentDao);
            //readStudentData(studentDao);
            //readAllStudents(studentDao);
            //updateSingleStudent(studentDao);
            deleteStudent(studentDao);
        };
    }

    private void deleteStudent(StudentDao studentDao) {
        int id = 2;
        studentDao.delete(id);
    }

    private void updateSingleStudent(StudentDao studentDao) {
        //specify the studentId
        int studentId = 1;
        //retrieve details of the student
        Student studentData = studentDao.findById(studentId);

        studentData.setFirstName("James");
        Student updatedDetails = studentDao.update(studentData);
        System.out.println("studentDao = Updated Student Details " + updatedDetails);
    }

    private void readAllStudents(StudentDao studentDao) {
        List<Student> students = studentDao.findAll();
        System.out.println("Generated id of  saved student:" + students);
    }

    private void readStudentData(StudentDao studentDao) {

        System.out.println("Start creating new student ");
        Student tempStudent = new Student("Jack", "Ma", "jack@yopmail.com");
        studentDao.save(tempStudent);

        System.out.println("studentDao = Reading Data....");
        Student studentData = studentDao.findById(tempStudent.getId());
        System.out.println("The student's info is" + studentData);
    }

    private void createNewStudent(StudentDao studentDao) {
        System.out.println("Start creating new student ");
        Student tempStudent = new Student("Sam", "Burnley", "sam123@yopmail.com");
        studentDao.save(tempStudent);

        //display id of saved student
        System.out.println("Generated id of  saved student:" + tempStudent.getId());

    }
}
