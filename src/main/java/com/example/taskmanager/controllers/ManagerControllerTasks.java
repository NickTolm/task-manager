package com.example.taskmanager.controllers;

import com.example.taskmanager.dto.Task;
import com.example.taskmanager.services.ManagerTasks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class ManagerControllerTasks {
    private final ManagerTasks manager;
    public ManagerControllerTasks(ManagerTasks manager) {
        this.manager = manager;
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks() throws FileNotFoundException {
        return manager.getAllTasks();
    }

    @GetMapping("/deleteAllTasks")
    public void deleteAllTasks() throws IOException {
        manager.deleteAllTasks();
    }

//    @GetMapping("/getTaskById")
//    public Task getTaskById (@RequestBody int taskId) {
//        return manager.getTaskById(taskId);
//    }


    // Cannot deserialize value of type `com.example.taskmanager.dto.Task`
    @PostMapping("/addNewTask")
    public void addNewTask(@RequestBody Task task) throws IOException {
        manager.addNewTask(task);
    }


//    @GetMapping("/updateTasks")
//    public void updateTasks (@RequestBody int taskId, @RequestBody Task task) {
//        manager.updateTask(taskId, task);
//    }

    @GetMapping("/deleteTaskById")
    public void deleteTaskById (@RequestBody int tasksId) {
        manager.deleteTaskById(tasksId);
    }


}
