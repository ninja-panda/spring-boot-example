package spring.boot.jersey.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.boot.jersey.sample.data.Person;
import spring.boot.jersey.sample.data.PersonService;

@Component
@Path("/search")
@Produces("application/json")
public class PersonSearchEndPoint {

	@Autowired
	private PersonService personService;

	@Path("/{personId}")
	@GET
	public Response getById(@PathParam("personId") final int personId) {
		final Person person = personService.getById(personId);
		return Response.ok(person).build();
	}

	@GET
	public Response getAllPersons() {
		return Response.ok(personService.getAllPersons()).build();
	}
}
