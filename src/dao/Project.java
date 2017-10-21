package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.FeedObjects;



public class Project {

	
	public ArrayList<FeedObjects> getAgentDetails(Connection connection, String id) throws Exception  {
		ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
		try
		{
			//String uname = request.getParameter("uname");
			PreparedStatement ps = connection.prepareStatement("SELECT id, firstname, lastname, hours, group_id, proffesion FROM agent WHERE id=" + id);
			//ps.setString(1,uname);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FeedObjects feedObject = new FeedObjects();
				feedObject.setFirstname(rs.getString("firstname"));
				feedObject.setLastname(rs.getString("lastname"));
				feedObject.setHours(rs.getString("hours"));
				feedObject.setProffesion(rs.getString("proffesion"));
				feedObject.setGroup_id(rs.getString("group_id"));
				feedObject.setId(rs.getString("id"));
				feedData.add(feedObject);
			}
			return feedData;

		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public ArrayList<FeedObjects> AgentList(Connection connection) throws Exception  {
		ArrayList<FeedObjects> feedData = new ArrayList<FeedObjects>();
		try
		{
			//String uname = request.getParameter("uname");
			PreparedStatement ps = connection.prepareStatement("SELECT id, firstname, lastname, hours, group_id, proffesion FROM agent");
			//ps.setString(1,uname);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FeedObjects agentList = new FeedObjects();
				agentList.setFirstname(rs.getString("firstname"));
				agentList.setLastname(rs.getString("lastname"));
				agentList.setHours(rs.getString("hours"));
				agentList.setProffesion(rs.getString("proffesion"));
				agentList.setGroup_id(rs.getString("group_id"));
				agentList.setId(rs.getString("id"));
				feedData.add(agentList);
			}
			return feedData;

		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
}
