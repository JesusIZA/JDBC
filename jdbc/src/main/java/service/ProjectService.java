package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bl.Util;
import dao.ProjectDAO;
import entity.Project;

public class ProjectService extends Util implements ProjectDAO{
	
	Connection connection = getConnection();
	
	public void add(Project project) {
		PreparedStatement preparedStatement = null;
		
		String sql = "INSERT INTO PROJECT (ID, TITLE) VALUES (?, ?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, project.getId());
			preparedStatement.setString(2, project.getTitle());
			
			preparedStatement.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Project> getAll() {
		List<Project> projectList = new ArrayList<Project>();
		
		String sql = "SELECT ID, TITLE FROM PROJECT";
		
		Statement statement = null;
		try{
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()){
				Project project = new Project();
				project.setId(resultSet.getLong("ID"));
				project.setTitle(resultSet.getString("TITLE"));
				
				projectList.add(project);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return projectList;
	}

	public Project getById(Long id) {
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT ID, TITLE FROM PROJECT WHERE ID=?";
		
		Project project = new Project();
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			
			ResultSet resulrSet = preparedStatement.executeQuery();
			
			project.setId(resulrSet.getLong("ID"));
			project.setTitle(resulrSet.getString("TITLE"));
			
			preparedStatement.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return project;
	}

	public void update(Project project) {

		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE PROJECT SET TITLE=? WHERE ID=?";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, project.getTitle());
			preparedStatement.setLong(2, project.getId());
			
			preparedStatement.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void delete(Project project) {

		PreparedStatement preparedStatement = null;
		
		String sql = "DELETE FROM PROJECT WHERE ID=?";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, project.getId());
			
			preparedStatement.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
