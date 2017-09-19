package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bl.Util;
import dao.EmployeeDAO;
import entity.Employee;

public class EmployeeService extends Util implements EmployeeDAO{
	
	Connection connection = getConnection();

	public void add(Employee employee) {

		PreparedStatement preparedStatement = null;
		
		String sql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID) VALUES (?, ?, ?, ?, ?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, employee.getId());
			preparedStatement.setString(2, employee.getFirsName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setDate(4, employee.getBirthday());
			preparedStatement.setLong(5, employee.getAddressID());
			
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

	public List<Employee> getAll() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID FROM EMPLOYEE";
		
		Statement statement = null;
		try{
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()){
				Employee employee = new Employee();
				employee.setId(resultSet.getLong("ID"));
				employee.setFirsName(resultSet.getString("FIRST_NAME"));
				employee.setLastName(resultSet.getString("LAST_NAME"));
				employee.setBirthday(resultSet.getDate("BIRTHDAY"));
				employee.setAddressID(resultSet.getLong("ADDRESS_ID"));
				
				employeeList.add(employee);
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
		return employeeList;
	}

	public Employee getById(Long id) {

		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID FROM EMPLOYEE WHERE ID=?";
		
		Employee employee = new Employee();
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			
			ResultSet resulrSet = preparedStatement.executeQuery();
			
			employee.setId(resulrSet.getLong("ID"));
			employee.setFirsName(resulrSet.getString("FIRST_NAME"));
			employee.setLastName(resulrSet.getString("LAST_NAME"));
			employee.setBirthday(resulrSet.getDate("BIRTHDAY"));
			employee.setAddressID(resulrSet.getLong("ADDRESS_ID"));
			
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
		return employee;
	}

	public void update(Employee employee) {

		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE EMPLOYEE SET FIRST_NAME=?, LAST_NAME=?, BIRTHDAY=?, ADDRESS_ID=? WHERE ID=?";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, employee.getFirsName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setDate(3, employee.getBirthday());
			preparedStatement.setLong(4, employee.getAddressID());
			preparedStatement.setLong(5, employee.getId());
			
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

	public void delete(Employee employee) {

		PreparedStatement preparedStatement = null;
		
		String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, employee.getId());
			
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
