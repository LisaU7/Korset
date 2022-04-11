package main.controller;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import main.entity.Value;
import main.service.ValueService;



@ApplicationScoped
@Controller
@Path("/LIA1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ValueController {
	@Inject
	Value value;
	
	@Inject
	ValueService valueService;
	
	//CREATE VALUE
	
	@POST
	@Transactional
	@Path("/createValue")
	public Response createValue(Value exvalue) {
//		Value value = new Value(valuey,valuex);
		valueService.addValue(exvalue);
		return Response.ok(exvalue).build();
//return Response.created(URI.create("/Values/" + value.getValueId())).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@POST
//	@Transactional
//	@Path("/createValue/{valuey}/{valuex}")
//	public Response createValue(@PathParam(value="valuey") int valuey, 
//			@PathParam(value="valuex") int valuex) {
//		Value value = new Value(valuey,valuex);
//		valueService.addValue(value);
//		return Response.created(URI.create("/Values/" + value.getValueId())).build();
//	}
	
	@GET
	@Path("/getValue/{valueId}")
	public Value getValue(@PathParam(value = "valueId") int valueId) {
		Value value = valueService.getValue(valueId);
		return value;
	}
	
	@GET
	@Path("/getAllValues")
	public List<Value> getAllValues(){
		return valueService.getAllValues();
	}
	


}
