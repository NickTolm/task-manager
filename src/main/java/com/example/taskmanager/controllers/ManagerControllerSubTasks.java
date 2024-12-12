package com.example.taskmanager.controllers;

import com.example.taskmanager.dto.SubTask;
import com.example.taskmanager.services.ManagerSubTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@RestController
public class ManagerControllerSubTasks {
    private final ManagerSubTask manager;
    public ManagerControllerSubTasks(ManagerSubTask manager) {
        this.manager = manager;
    }

    @GetMapping("/getAllSubTasks")
    public List<SubTask> printAllSubTasks() throws FileNotFoundException {
        return manager.getAllSubTasks();
    }

    @GetMapping
    public void deleteAllSubTasks() throws IOException {
        manager.deleteAllSubTasks();
    }


}
