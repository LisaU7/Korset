package main.entity;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
@Named
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;

	@Column(name = "subjectTitle")
	private String subjectTitle;

	// CONTRUCTORS
	public Subject() {
		super();
	}

	public Subject(String subjectTitle) {
		super();
		this.subjectTitle = subjectTitle;
	}

	// GETTER SETTERS
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectTitle=" + subjectTitle + "]";
	}

}
