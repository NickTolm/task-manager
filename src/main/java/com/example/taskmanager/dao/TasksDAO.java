package com.example.taskmanager.dao;

import com.example.taskmanager.dto.Task;
import com.example.taskmanager.dto.TaskStatus;
import org.springframework.stereotype.Repository;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class TasksDAO {
    List<Task> allTasksList = new ArrayList<>();
    public void readTasks() throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/tasks")))) {
            while (scanner.hasNextLine()) {
                String[] taskStrings = scanner.nextLine().split(";");
                allTasksList.add(new Task(
                        Integer.parseInt(taskStrings[0]),
                        taskStrings[1],
                        taskStrings[2],
                        TaskStatus.valueOf(taskStrings[3])));
            }
        }
    }

    // getEpicById() getTaskById, getSubtaskById и прочие методы

    //Получение списка всех задач.
    public List<Task> getAllTasks() {
        return this.allTasksList;
    }

    //Удаление всех задач.
    public void deleteAllTasks() throws IOException {
        allTasksList.clear();
        new FileWriter("src/main/resources/tasks", false).close();
    }

    //Получение по идентификатору.
    public Task getTaskById(int taskId) {
        for(Task task: allTasksList) {
            if(task.getId() == taskId) {
                return task;
            }
        }
        return // ???
    }

    //Создание. Сам объект должен передаваться в качестве параметра.
    public void addNewTask(Task task) throws IOException {
        try (FileWriter writer = new FileWriter("src/main/resources/tasks")) {
            writer.write(task.getId());
            writer.write(";");
            writer.write(task.getName());
            writer.write(";");
            writer.write(task.getDescription());
            writer.write(";");
            writer.write(task.getTaskStatus().ordinal());
        }
    }

    // Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
//    public void updateTask(Task task, int newTaskId) {
//        for(Task tasks: allTasksList) {
//            if(tasks == task) {
//                tasks.setId(newTaskId);  //  @Value?
//            }
//        }
//    }

    //Удаление по идентификатору.
    public void deleteTaskById(int taskId) {
        allTasksList.removeIf(task -> task.getId() == taskId);
    }

    }
