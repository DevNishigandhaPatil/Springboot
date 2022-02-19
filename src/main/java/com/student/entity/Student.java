package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
//@Component
@Entity
@Table(name = "student")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roll;
	@Column
	private String name;
	@Column
	private String college_name;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getRoll() {
		return roll;
	}

	public void setRoll(long roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public Student(long roll, String name, String college_name) {
		super();
		this.roll = roll;
		this.name = name;
		this.college_name = college_name;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", college_name=" + college_name + "]";
	}
	
}
