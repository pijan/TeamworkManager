package cz.uhk.teamworkmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.teamworkmanager.dao.TaskDAO;
import cz.uhk.teamworkmanager.model.Task;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
    private TaskDAO taskDAO;
        
    public void save(Task task) {
        taskDAO.saveTask(task);
    }
 
    public void delete(int taskId){
    	taskDAO.deleteTask(taskId);
    }
    
    public Task get(int taskId){
    	return taskDAO.loadTaskById(taskId);
    }
    
    public void update(Task task){
    	taskDAO.updateTask(task);
    }
    
    public List<Task> list() {
        return taskDAO.listTask();
    }
	
}
