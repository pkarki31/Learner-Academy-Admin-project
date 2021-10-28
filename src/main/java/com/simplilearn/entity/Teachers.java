package com.simplilearn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teachers")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teachersID;
	private String teachersName;
	private String classTeacher;
	private String subject;
	private int age;
	private String teacherClasses;
	
	public Teachers() {
		
		
	}

	public int getTeachersID() {
		return teachersID;
	}

	public void setTeachersID(int teachersID) {
		this.teachersID = teachersID;
	}

	public String getTeachersName() {
		return teachersName;
	}

	public void setTeachersName(String teachersName) {
		this.teachersName = teachersName;
	}

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeacherClasses() {
		return teacherClasses;
	}

	public void setTeacherClasses(String teacherClasses) {
		this.teacherClasses = teacherClasses;
	}
	
	

}
