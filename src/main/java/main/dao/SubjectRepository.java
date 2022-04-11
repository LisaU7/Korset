package main.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import main.entity.Subject;

@ApplicationScoped
public class SubjectRepository implements PanacheRepository<Subject> {

	// FIND BY ID
	public Subject findById(int subjectId) {
		return find("subjectId", subjectId).firstResult();
	}

	// FIND BY SUBJECTTITLE
	public Subject findByName(String subjectTitle) {
		return find("subjectTitle", subjectTitle).firstResult();
	}

	// GET ALL
	public List<Subject> getAll() {
		return findAll().list();
	}

}
