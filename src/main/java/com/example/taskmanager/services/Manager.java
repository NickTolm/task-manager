package com.example.taskmanager.services;

import com.example.taskmanager.dao.TasksDAO;
import com.example.taskmanager.dto.Epic;
import com.example.taskmanager.dto.Task;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Manager {
    private TasksDAO tasksDAO;
    public Map<Integer, Task> taskMap;

    public Manager(Map<Integer, Task> taskMap, TasksDAO tasksDAO) {
        this.taskMap = taskMap;
        this.tasksDAO = tasksDAO;
    }

    //Получение списка всех задач.
    public Map<Integer, Task> getAllTasks() {
        return taskMap;
    }

    //Удаление всех задач.
    public void deleteAllTasks() {
        taskMap.clear();
    }

    //Получение по идентификатору.
    public Map<Integer, Task> printSpecifiedTasksType(int TasksType) {
        return taskMap.entrySet().stream()
                .filter(a -> a.getKey()  == TasksType)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    //Создание. Сам объект должен передаваться в качестве параметра.
    public void addNewTask(int TasksType, Task task) {
        this.taskMap.put(TasksType, task);
    }

    // Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    public void updateTasks(int TasksType, Task task) {

    }

    //Удаление по идентификатору.
    public Map<Integer, Task> deleteSpecifiedTasksType(int TasksType) {
        for(Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            taskMap.remove(TasksType);
        }
        return taskMap;
    }

    // Получение списка всех подзадач определённого эпика.
    public int[] findSubTasksOfEpic(int EpicID) {
        for(Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if(entry.getValue().id == EpicID) {
                return (Epic)entry.getValue().subTasksID;
            }
        }
    }











}
