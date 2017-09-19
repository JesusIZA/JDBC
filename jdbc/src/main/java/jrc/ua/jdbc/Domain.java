package jrc.ua.jdbc;


import java.util.Calendar;
import java.util.List;

import entity.Address;
import entity.Empl_Proj;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.Empl_ProjService;
import service.EmployeeService;
import service.ProjectService;

public class Domain {

	public static void main(String[] args) {
		
//		Util util = new Util();
//		util.getConnection();
		
		AddressService addressService = new AddressService();
		EmployeeService employeeService = new EmployeeService();
		ProjectService projectService = new ProjectService();
		Empl_ProjService empl_ProjService = new Empl_ProjService();
		
		Address address = new Address();
		address.setId(1L);
		address.setCountry("US");
		address.setCity("Rome");
		address.setStreet("happyST");
		address.setPostCode("12345");
		
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirsName("Abrahem");
		employee.setLastName("Linkoln");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1935, Calendar.MAY, 1);
		
		employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
		employee.setAddressID(address.getId());
		
		Project project = new Project();
		project.setId(1L);
		project.setTitle("New Title");
		
		Empl_Proj empl_proj = new Empl_Proj();
		empl_proj.setEmployeeId(employee.getId());
		empl_proj.setPrijectId(project.getId());
		/*
		addressService.add(address);
		employeeService.add(employee);
		projectService.add(project);
		empl_ProjService.add(empl_proj);
		*/
		List<Address> addressL = addressService.getAll();
		for(Address a: addressL){
			System.out.println(a);
		}
	}

}
