package com.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springboot.beans.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	
	//Get Mapping http://localhost:8080/student
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1,"swathi","packumala");
		//return new ResponseEntity<>(student,HttpStatus.OK);
		return ResponseEntity.ok(student);
		}
	
	//http://localhost:8080/Students
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = new ArrayList();
		students.add(new Student(1,"swathi","Packumala"));
		students.add(new Student(2,"Baby","Packumala"));
		students.add(new Student(3,"Bipin","Packumala"));
		return ResponseEntity.ok(students);
	}
	
	//http://localhost:8080/student/1/swathi/packumala
	@GetMapping("{id}/{firstName}/{lastName}")
	public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
			                           @PathVariable("firstName") String firstName,
			                           @PathVariable("lastName") String lastName){
		Student student = new Student(studentId,firstName,lastName);
		//return new Student(studentId,firstName,lastName);
		return ResponseEntity.ok(student);
	}
	//http://localhost:8080/student/query?id=1&firstName=swathi&lastName=Packumala	
	@GetMapping("query")
	public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
			                               @RequestParam String firstName,
			                               @RequestParam String lastName) {
		Student student = new Student(id,firstName,lastName);
		return ResponseEntity.ok(student);
	}
	@PostMapping("create")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	@PutMapping("{id}/update")
	public ResponseEntity<Student> modifiyStudent(@PathVariable("id") int id,@RequestBody Student student) {
		
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
		}
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		System.out.println("studentId:"+studentId);
		return ResponseEntity.ok("Student deleted sucessfully");
	}
	
	
	
	
	

}
