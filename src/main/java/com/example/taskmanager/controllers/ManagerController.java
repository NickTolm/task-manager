package com.example.taskmanager.controllers;

import com.example.taskmanager.services.Manager;
import com.example.taskmanager.dto.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ManagerController {
    private final Manager manager;
    public ManagerController(Manager manager) {
        this.manager = manager;
    }

    @GetMapping("/printAllTasks")
    public Map<Integer, Task> printAllTasks() {
        return manager.printAllTasks();
    }

    @GetMapping("/deleteAllTasks")
    public void deleteAllPasks() {
        manager.deleteAllTasks();
    }

    @GetMapping("/printSpecifiedTasksType")
    public Map<Integer, Task> printSpecifiedTasksType (@RequestParam("TasksType") int TasksType) {
        return manager.printSpecifiedTasksType(TasksType);
    }

    @GetMapping("/addNewTask")
    public void addNewTask (@RequestParam("TasksType") int TasksType, @RequestParam("task") Task task) {
        manager.addNewTask(TasksType, task);
    }

    @GetMapping("/updateTasks")
    public void updateTasks (@RequestParam("TasksType") int TasksType, @RequestParam("task") Task task) {
        manager.updateTasks(TasksType, task);
    }

    @GetMapping("/deleteSpecifiedTasksType")
    public Map<Integer, Task> deleteSpecifiedTasksType (@RequestParam("TasksType") int TasksType) {
        return manager.deleteSpecifiedTasksType(TasksType);
    }

    @GetMapping("/findSubTasksOfEpic")
    public int[] findSubTasksOfEpic (@RequestParam("TasksType") int EpicID) {
        return manager.findSubTasksOfEpic(EpicID);
    }
}
