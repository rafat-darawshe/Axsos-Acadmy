package com.rafat.Log.Registr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafat.Log.Registr.Repository.TaskRepository;
import com.rafat.Log.Registr.models.Project;
import com.rafat.Log.Registr.models.Task;
import com.rafat.Log.Registr.models.User;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	private ProjectService projServ;

	@Autowired
	private UserService userServ;

	public void createTask(Task newTask, Long projId, Long userId) {
		Project project = projServ.findProjectById(projId);
		User user = userServ.findUserById(userId);
		newTask.setId(null);
		newTask.setUser(user);
		newTask.setProject(project);
		taskRepo.save(newTask);
	}
}
