package com.example.taskmanager.services;

import com.example.taskmanager.dto.Epic;
import com.example.taskmanager.dto.SubTask;
import com.example.taskmanager.dto.Task;
import com.example.taskmanager.dto.TaskStatus;

import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {

        Task task = new Task("name", "description", 1, TaskStatus.IN_PROGRESS);
        SubTask subTask = new SubTask("name", "description", 2, TaskStatus.IN_PROGRESS, 13);
        int[] array = {1,2,3,4,5};
        Epic epic = new Epic("name", "description", 2, TaskStatus.NEW, array);

        Map<Integer, Task> taskMap = new HashMap<>();
        taskMap.put(Task.taskType,task);
        taskMap.put(SubTask.taskType,subTask);
        taskMap.put(Epic.taskType,epic);

        Manager manager = new Manager(taskMap);

        System.out.println(manager.taskMap);
        System.out.println(manager.printSpecifiedTasksType(2));
    }
}
