package cz.uhk.teamworkmanager.dao;

import java.util.List;

import cz.uhk.teamworkmanager.model.Task;

public interface TaskDAO {

	public void saveTask(Task task);
	
	public void deleteTask(int taskId);
	
	public void updateTask(Task task);
	
	public Task loadTaskById(int taskId);
	
	public List<Task> listTask() ;
}
