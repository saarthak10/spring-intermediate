package com.learn.cruddemo;

import com.learn.cruddemo.entity.Student;
import com.learn.cruddemo.entity.StudentDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner-> {
			System.out.println("Hello world");
			createNewStudent(studentDao);
		};
	}

	private void createNewStudent(StudentDao studentDao) {
		System.out.println("Start creating new student ");
		Student tempStudent = new Student("Sam","Burnley","sam");


	}
}
