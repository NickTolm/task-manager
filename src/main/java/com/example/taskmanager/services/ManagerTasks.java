package com.example.taskmanager.services;

import com.example.taskmanager.dao.TasksDAO;
import com.example.taskmanager.dto.Task;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class ManagerTasks {
    private final TasksDAO tasksDAO = new TasksDAO();

    public List<Task> getAllTasks() throws FileNotFoundException {
        tasksDAO.readTasks();
        return tasksDAO.getAllTasks();
    }

    public void deleteAllTasks() throws IOException {
        tasksDAO.deleteAllTasks();
    }

//    public Task getTaskById(int taskId) {
//        return tasksDAO.getTaskById(taskId);
//    }

    public void addNewTask(Task task) throws IOException {
        tasksDAO.addNewTask(task);
    }

//    public void updateTask(int taskId, Task task) {
//        tasksDAO.updateTask(task, taskId);
//    }

    public void deleteTaskById(int taskId) {
        tasksDAO.deleteTaskById(taskId);
    }




}
