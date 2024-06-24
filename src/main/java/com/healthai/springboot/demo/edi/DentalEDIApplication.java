package com.healthai.springboot.demo.edi;

import com.healthai.springboot.demo.edi.dao.StudentDAO;
import com.healthai.springboot.demo.edi.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DentalEDIApplication {

	private static final Logger log = LogManager.getLogger(DentalEDIApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DentalEDIApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(StudentDAO student) {
//
//		return runner -> {
//			createStudent(student);
//
//		};
//	}

//	private void createStudent(StudentDAO studentDAO) {
////		System.out.println("Creating student...");
////		Student tempStudent= new Student("MOHAMED", "BNEIJARA", "MOHAMEDBENEIJARA@gmail.com");
////		//save the student in the data base
////		studentDAO.save(tempStudent);
////		//display id of the saved student
////		Student tempStudent2 = studentDAO.getStudentById(2);
////		System.out.println("Student with id 2: " + tempStudent2.toString());
////		//Get all student
////		List<Student> students = studentDAO.findALl();
////		students.forEach(student -> {
////			System.out.println(student);
////		});
////		List<Student> students = studentDAO.getStudentByName("OUBEID");
////		students.forEach(student -> {
////			System.out.println(student.toString());
////		});
//
////		Student theStudent = studentDAO.getStudentByLastName("BNEIJARA");
////		theStudent.setLastName("LEBIDE");
////		studentDAO.update(theStudent);
////		List<Student> students = studentDAO.getStudentsByName("LEBIDE");
////		students.forEach(student -> {
////			System.out.println(student.toString());
////		});
//
//		try {
//			int n= studentDAO.deleteAll();
//			System.out.println("Deleted " + n + " students");
//
//		}catch (Exception e) {
//			log.error(e);
//		}
//
//
//
//
//
//
//	}

}
