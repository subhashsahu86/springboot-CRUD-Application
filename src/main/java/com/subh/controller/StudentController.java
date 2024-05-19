package com.subh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.subh.entity.Student;
import com.subh.repository.StudentRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
//@RequestMapping(value = "/api/ai/academy")
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	//get all the students
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students = repo.findAll();
		
		return students;
	}
	
	//get Student Details By Id
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable Integer id){
		Student student = repo.findById(id).get();
		return student;
	}
	
	//Create Student 
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}
	
	//update student
	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable  Integer id) {
	
		 Student student=repo.findById(id).get();
		student.setName("Anamika");
		student.setPercentage(95.50);
		repo.save(student);
		return student;
	}
	
	//Delete the Student
	@DeleteMapping("/student/delete/{id}")
	public void deleteStudent(@PathVariable Integer id) {
	Student student = repo.findById(id).get();
		 repo.delete(student);
	
	}

}
