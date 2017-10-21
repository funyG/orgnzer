package model;

import java.security.cert.Extension;
import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;

import dao.Project;
import dto.FeedObjects;

public class ProjectManager {
	
	
	public ArrayList<FeedObjects> GetAgentDetails(String agent_id)throws Exception {
		ArrayList<FeedObjects> feeds = null;
		try {
			    Database database= new Database();
			    Connection connection = database.Get_Connection();
				Project project= new Project();
				feeds=project.getAgentDetails(connection, agent_id);
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}

	public ArrayList<FeedObjects> GetAllAgents() throws Exception {
		ArrayList<FeedObjects> feeds = null;
		try {
			Database database = new Database();
			Connection connection = database.Get_Connection();
			Project project = new Project();
			feeds = project.AgentList(connection);
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}

}
