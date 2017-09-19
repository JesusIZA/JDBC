package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bl.Util;
import dao.Empl_ProjDAO;
import entity.Empl_Proj;

public class Empl_ProjService extends Util implements Empl_ProjDAO{
	
	Connection connection = getConnection();

	public void add(Empl_Proj empl_proj) {

		PreparedStatement preparedStatement = null;
		
		String sql = "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES (?, ?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, empl_proj.getEmployeeId());
			preparedStatement.setLong(2, empl_proj.getPrijectId());
			
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

	public List<Empl_Proj> getAll() {

		List<Empl_Proj> empl_projList = new ArrayList<Empl_Proj>();
		
		String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ";
		
		Statement statement = null;
		try{
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()){
				Empl_Proj empl_proj = new Empl_Proj();
				empl_proj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
				empl_proj.setPrijectId(resultSet.getLong("PROJECT_ID"));
				
				empl_projList.add(empl_proj);
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
		return empl_projList;
	}

	public Empl_Proj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) {

		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";
		
		Empl_Proj empl_proj = new Empl_Proj();
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, employeeId);
			preparedStatement.setLong(2, projectId);
			
			ResultSet resulrSet = preparedStatement.executeQuery();
			
			empl_proj.setEmployeeId(resulrSet.getLong("EMPLOYEE_ID"));
			empl_proj.setPrijectId(resulrSet.getLong("PROJECT_ID"));
			
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
		return empl_proj;
	}

	public void update(Empl_Proj empl_proj) {


		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE EMPL_PROJ SET EMPLOYEE_ID=?, PROJECT_ID=?";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, empl_proj.getEmployeeId());
			preparedStatement.setLong(5, empl_proj.getPrijectId());
			
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

	public void delete(Empl_Proj empl_proj) {

		PreparedStatement preparedStatement = null;
		
		String sql = "DELETE FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, empl_proj.getEmployeeId());
			preparedStatement.setLong(1, empl_proj.getPrijectId());
			
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
