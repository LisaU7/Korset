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

	// CREATE SUBJECT - SUBJECTTITLE [x]
	@POST
	@Transactional
	@Path("/createSubject/{subjectTitle}")
	public Response createSubject(@PathParam(value = "subjectTitle") String subjectTitle) {
		Subject subject = new Subject(subjectTitle);
		subjectService.addSubject(subject);
		return Response.created(URI.create("/Subjects/" + subject.getSubjectId())).build();
	}

	// GET SUBJECT - ID //DUMT MED STRING? [x]
	@GET
	@Path("/getSubject/{subjectId}")
	public String getSubject(@PathParam(value = "subjectId") int subjectId) {
		Subject subject = subjectService.getSubject(subjectId);
		return subject.toString();
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

}
