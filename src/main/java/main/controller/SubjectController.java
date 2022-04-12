package main.controller;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import main.entity.Subject;
import main.service.SubjectService;

@ApplicationScoped
@Controller
@Path("/LIA1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubjectController {

	@Inject
	Subject subject;

	@Inject
	SubjectService subjectService;

	// Använd INTE @PathParam med POST
	// CREATE SUBJECT - SUBJECTTITLE [x]
	@POST
	@Transactional
	@Path("/createSubject")
	public Response createSubject(String subjectTitle) {
		Subject subject = new Subject(subjectTitle);
		subjectService.addSubject(subject);
		return Response.created(URI.create("/Subjects/" + subject.getSubjectId())).build();
	}

	// GET SUBJECT - ID [x]
	@GET
	@Path("/getSubject/{subjectId}")
	public Subject getSubject(@PathParam(value = "subjectId") int subjectId) {
		Subject subject = subjectService.getSubject(subjectId);
		return subject;
	}

	// DELETE SUBJECT - ID [x]
	@DELETE
	@Transactional
	@Path("/deleteSubject/{subjectId}")
	public void deleteSubject(@PathParam(value = "subjectId") int subjectId) {
		Subject subject = subjectService.getSubject(subjectId);
		if (subject == null) {
			throw new NotFoundException();
		} else {
			subjectService.deleteSubject(subject);
		}
	}

	// UPDATE SUBJECT [ ]

	// GET ALL SUBJECTS [ ]
	@GET
	@Path("/getAllSubjects")
	public List<Subject> getAllSubjects() {
		return subjectService.getAllSubjects();
	}
//	@GET
	@Path("/getSubjectTitle")
	public Subject getSubject(String subjectTitle) {
		Subject subject = subjectService.getSubjectTitle(subjectTitle);
		return subject;
	}
}
