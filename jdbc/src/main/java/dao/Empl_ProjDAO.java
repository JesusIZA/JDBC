package dao;

import java.util.List;

import entity.Empl_Proj;

public interface Empl_ProjDAO {

	//create
	void add(Empl_Proj empl_proj);
	
	//read
	List<Empl_Proj> getAll();
	
	Empl_Proj getByEmployeeIdAndProjectId(Long employeeId, Long projectId);
	
	//update
	void update(Empl_Proj empl_proj);
	
	//delete
	void delete(Empl_Proj empl_proj);
	

}
