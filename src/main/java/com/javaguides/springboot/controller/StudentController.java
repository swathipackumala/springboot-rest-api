package com.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springboot.beans.Student;

@RestController
public class StudentController {
	
	//Get Mapping http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		Student student = new Student(1,"swathi","packumala");
		return student;
		
	}
	//http://localhost:8080/Students
	@GetMapping("/Students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList();
		students.add(new Student(1,"swathi","Packumala"));
		students.add(new Student(2,"Baby","Packumala"));
		students.add(new Student(3,"Bipin","Packumala"));
		return students;
	}
	
	//http://localhost:8080/student/1/swathi/packumala
	@GetMapping("student/{id}/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("id") int studentId,
			                           @PathVariable("firstName") String firstName,
			                           @PathVariable("lastName") String lastName){
		return new Student(studentId,firstName,lastName);
	}
	//http://localhost:8080/student/query?id=1&firstName=swathi&lastName=Packumala	
	@GetMapping("/student/query")
	public Student studentRequestVariable(@RequestParam int id,
			                               @RequestParam String firstName,
			                               @RequestParam String lastName) {
		return new Student(id,firstName,lastName);
	}
	@PostMapping("student/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	@PutMapping("student/{id}/update")
	public Student modifiyStudent(@PathVariable("id") int id,@RequestBody Student student) {
		
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
		}
	@DeleteMapping("student/{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		System.out.println("studentId:"+studentId);
		return "Student deleted sucessfully";
	}
	
	
	

}
