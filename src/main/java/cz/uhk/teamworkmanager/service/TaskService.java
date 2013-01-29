package cz.uhk.teamworkmanager.service;

import java.util.List;

import cz.uhk.teamworkmanager.model.Task;

public interface TaskService {
	
	public void save(Task task);
 
    public void delete(int taskId);
    
    public Task get(int taskId);
    
    public void update(Task task);
    
    public List<Task> list();
}
