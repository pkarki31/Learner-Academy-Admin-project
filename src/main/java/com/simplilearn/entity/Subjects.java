package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class Subjects {
	
	@Id
	@Column(name="subjectID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectID;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="subjectTeachers")
	private String subjectTeachers;
	
	@Column(name="subjectClasses")
	private String subjectClasses;
	
	
	public Subjects() {
		
	}


	public int getSubjectID() {
		return subjectID;
	}


	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getSubjectTeachers() {
		return subjectTeachers;
	}


	public void setSubjectTeachers(String subjectTeachers) {
		this.subjectTeachers = subjectTeachers;
	}


	public String getSubjectClasses() {
		return subjectClasses;
	}


	public void setSubjectClasses(String subjectClasses) {
		this.subjectClasses = subjectClasses;
	}
	
	

}
