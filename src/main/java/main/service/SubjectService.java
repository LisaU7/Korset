package main.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import main.dao.SubjectRepository;
import main.entity.Subject;

@ApplicationScoped
public class SubjectService {

	@Inject
	Subject subject;

	@Inject
	SubjectRepository subjectRepository;

	// ADD SUBJECT
	public void addSubject(Subject subject) {
		subjectRepository.persist(subject);
	}

	// GET SUBJECT - ID
	public Subject getSubject(int subjectId) {
		Subject subject = subjectRepository.findById(subjectId);
		return subject;
	}

	// DELETE SUBJECT - ID
	public void deleteSubject(Subject subject) {
		subjectRepository.delete(subject);
	}

	// GET ALL
	public List<Subject> getAllSubjects() {
		return subjectRepository.getAll();
	}

	// GET SUBJECT - TITLE
	public Subject getSubjectTitle(String subjectTitle) {
		Subject subject = subjectRepository.findByName(subjectTitle);
		return subject;
	}
}
