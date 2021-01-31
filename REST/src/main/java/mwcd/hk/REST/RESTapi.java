package mwcd.hk.REST;

import java.sql.Connection;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.server.ResourceConfig;



@Path("")
public class RESTapi extends ResourceConfig  {
	public RESTapi() {
        register(CORSResponseFilter.class);
    }

	
	
	Connection connection = null; 
	
	
	RESTrepository repo = new RESTrepository();
	
//	
	
	//USERS
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		
		System.out.println("getUsers called...");
		
		return repo.getUsers();
	}
	
	
	@GET
	@Path("/users/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id")int id) {
		
		System.out.println("getUsers called...");
		
		return repo.getUser(id);
	}
	
	
	@POST 
	@Path("/users/create") 
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User a1) {
		System.out.println("Creating user attempt executed");
		repo.create(a1);
		
		return a1;
	}
	
	@PUT
	@Path("/users/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(User a1) {

		if(repo.getUser(a1.getId()).getId()==0) {
			System.out.println("Resource you're looking for does not exist");
		} else {
		System.out.println("Editting  user executed");
		repo.update(a1);
		}
		return a1;
	}
	
	@DELETE
	@Path("/users/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteUser(@PathParam("id")int id) {
		
		User a = repo.getUser(id);
		
		if(a.getId()!=0) {
			repo.deleteUser(id);
			System.out.println("Element deleted");
		
		} else {
			System.out.println("Resource you're looking for does not exist");
		}
		return a;
		
	}
	
	
//PROJECTS

	
	@GET
	@Path("/projects")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getProjects() {
		
		System.out.println("getProjects called...");
		
		return repo.getProjects();
	}
	
	@GET
	@Path("/projects/project/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Project getProject(@PathParam("id")int id) {
		
		System.out.println("getProjects called...");
		
		return repo.getProject(id);
	}
	
	
	@POST 
	@Path("/projects") 
	@Consumes(MediaType.APPLICATION_JSON)
	public Project createProject(Project p1) {
		System.out.println("Creating project attempt executed");
		repo.create(p1);
		
		return p1;
	}
	
	@PUT
	@Path("/projects/project{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Project updateProject(Project p1) {

		if(repo.getUser(p1.getId()).getId()==0) {
			System.out.println("Resource you're looking for does not exist");
		} else {
		System.out.println("Editting  project executed");
		repo.update(p1);
		}
		return p1;
	}
	
	@DELETE
	@Path("/projects/project/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Project deleteProject(@PathParam("id")int id) {
		
		Project a = repo.getProject(id);
		
		if(a.getId()!=0) {
			repo.deleteUser(id);
			System.out.println("Element deleted");
		
		} else {
			System.out.println("Resource you're looking for does not exist");
		}
		return a;
		
	}
}
