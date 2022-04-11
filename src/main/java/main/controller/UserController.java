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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.springframework.stereotype.Controller;

import main.entity.User;
import main.service.UserService;

@ApplicationScoped
@Controller
@Path("/LIA1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

	@Inject
	User user;

	@Inject
	UserService userService;

	// CREATE USER - USERNAME [x]
	@POST
	@Transactional
	@Path("/createUser/{userName}")
	public Response createUser(@PathParam(value = "userName") String userName) {
		User user = new User(userName);
		userService.addUser(user);
		return Response.created(URI.create("/Users/" + user.getUserId())).build();
	}

	// GET USER - ID //DUMT ATT ANVÄNDA STRING? [x]
	@GET
	@Path("/getUser/{userId}")
	public String getUser(@PathParam(value = "userId") int userId) {
		User user = userService.getUser(userId);
		return user.toString();
	}

	// DELETE USER - ID [x]
	@DELETE
	@Transactional
	@Path("/deleteUser/{userId}")
	public void deleteUser(@PathParam(value = "userId") int userId) {
		User user = userService.getUser(userId);
		if (user == null) {
			throw new NotFoundException();
		} else {
			userService.deleteUser(user);
		}
	}

	// UPDATE USER [ ]
//	@PUT
//	@Transactional
//	@Path("/updateUser/{userId}")
//	public User update(@PathParam(value = "userId") int userId, User user) {
//		User
//		
//	}

	// GET ALL USERS [ ]
	@GET
	@Path("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
