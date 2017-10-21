package webService;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import model.ProjectManager;

import com.google.gson.Gson;

import dto.FeedObjects;

@Path("/Agents")
public class FeedService {
	
	@GET
	@Path("/Agent/{id}")
	@Produces("application/json")
	public Response feed(@PathParam("id") String id)
	{
		String feeds  = null;
		try 
		{
			ArrayList<FeedObjects> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.GetAgentDetails(id);
			//StringBuffer sb = new StringBuffer();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return Response.status(200)
				.header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
				.header("Access-Control-Allow-Methods", "GET, POST")
				.header("Access-Control-Allow-Origin", "http://localhost:4200")
				.entity(feeds).build();
	}
	@GET
	@Path("/AllAgents/")
	@Produces("application/json")
	public Response agents()
	{
		String feeds  = null;
		try
		{
			ArrayList<FeedObjects> feedData = null;
			ProjectManager projectManager= new ProjectManager();
			feedData = projectManager.GetAllAgents();
			//StringBuffer sb = new StringBuffer();
			Gson gson = new Gson();
			System.out.println(gson.toJson(feedData));
			feeds = gson.toJson(feedData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return Response.status(200)
				.header("Access-Control-Request-Headers", "X-Requested-With, accept, content-type")
				.header("Access-Control-Allow-Methods", "GET, POST")
				.header("Access-Control-Allow-Origin", "http://localhost:4200")
				.entity(feeds).build();
	}





}
