package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
@Autowired
StudentService studentService;

@PostMapping("/student")
public ResponseEntity<Student> save(@RequestBody Student stud)
{
	//Student stud2=new Student(1L,"ram","abc");
	
	System.out.println(stud);
	Student stud1 =studentService.save(stud);
	return new ResponseEntity<Student>(stud1,HttpStatus.CREATED);
}

@GetMapping("/student/{roll}")
public Student getStudentbyId(@PathVariable("roll") long roll)
{
	System.out.println(roll);
Student s1=studentService.getStudentbyId(roll);
return s1; 
}

@GetMapping("/students")
public List<Student> getAllStudent()
{
return 	studentService.getAllStudent();
}

@PutMapping("/student/{roll}")
public ResponseEntity<Student> update(@PathVariable("roll") long roll,@RequestBody Student stud)
{
	 Student stud1=studentService.update(roll,stud);
	return new ResponseEntity<Student>(stud1 ,HttpStatus.OK);
}
@DeleteMapping("/student/{roll}")
public ResponseEntity deleteStudentbyId(@PathVariable("roll") long roll)
{
     studentService.deleteStudentbyId(roll); 
     return ResponseEntity.ok("Delete record Succefully");
     
}
}