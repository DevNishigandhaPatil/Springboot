package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
 public Student save(Student stud);
 public Student getStudentbyId(long roll);
 public List<Student> getAllStudent();
public Student update(long roll, Student stud);
public void deleteStudentbyId(long roll);
}
