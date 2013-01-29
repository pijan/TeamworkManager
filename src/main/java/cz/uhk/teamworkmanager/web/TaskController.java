package cz.uhk.teamworkmanager.web;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.teamworkmanager.model.Task;
import cz.uhk.teamworkmanager.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
    TaskService taskService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String taskList(Model model) {
		
		Task task = new Task();
		task.setDateCreated(new Timestamp(System.currentTimeMillis()));
		taskService.save(task);
		
		List<Task> result = taskService.list();
		 
		model.addAttribute("taskList", result); 
				
		return "tasks"; 
	} 
}
