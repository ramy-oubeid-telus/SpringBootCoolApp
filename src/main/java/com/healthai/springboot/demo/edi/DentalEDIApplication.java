package com.healthai.springboot.demo.edi;

import com.healthai.springboot.demo.edi.dao.StudentDAO;
import com.healthai.springboot.demo.edi.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DentalEDIApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalEDIApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO student) {

		return runner -> {
			createStudent(student);

		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//create a new student
//		System.out.println("Creating student...");
//		Student tempStudent= new Student("John", "Dao", "johnDao@gmail.com");
//		//save the student in the data base
//		studentDAO.save(tempStudent);
//		//display id of the saved student
//		Student tempStudent2 = studentDAO.getStudentById(2);
//		System.out.println("Student with id 2: " + tempStudent2.toString());
		System.out.println(studentDAO.findALl().toString());



	}

}
