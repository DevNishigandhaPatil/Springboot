package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.custom.exception.classes.StudentAlreadyExistException;
import com.student.custom.exception.classes.StudentNotFoundException;
import com.student.dao.StudentDao;
import com.student.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	public Student save(Student stud) {
		Optional<Student> s1 = studentDao.findById(stud.getRoll());
		if (s1.isPresent())
			throw new StudentAlreadyExistException();
		else

			return studentDao.save(stud);

	}

	@Override
	public Student getStudentbyId(long roll) {
		Optional<Student> s1 = studentDao.findById(roll);
		if (s1.isPresent())
			return studentDao.getById(roll);
		else
			throw new StudentNotFoundException();
	}

	public List<Student> getAllStudent() {

		return studentDao.findAll();
	}

	@Override
	public Student update(long roll, Student stud) {
		Student s1 = studentDao.findById(roll).orElseThrow(() -> new StudentNotFoundException());

		s1.setName(stud.getName());
		s1.setCollege_name(stud.getCollege_name());
		studentDao.save(s1);
		return s1;
	}

	@Override
	public void deleteStudentbyId(long roll) {
		Optional<Student> s1 = studentDao.findById(roll);
		if (s1.isPresent())
			studentDao.deleteById(roll);
		else
			throw new StudentNotFoundException();
	}
}
