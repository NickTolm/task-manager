package com.example.taskmanager.dao;

import com.example.taskmanager.dto.Epic;
import com.example.taskmanager.dto.SubTask;
import com.example.taskmanager.dto.Task;
import com.example.taskmanager.dto.TaskStatus;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class TasksDAO {
    /// getEpicById() getTaskById, getSubtaskById и прочие методы
    public void readTasks() throws FileNotFoundException {
        List<Task> allTasksList = new ArrayList<>();
        List<Epic> epics;
        List<SubTask> subTasks;

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/tasks")))) {
            while (scanner.hasNextLine()) {
                String[] taskStrings = scanner.nextLine().split(";");
                if(Integer.parseInt(taskStrings[0]) == 0) {
                    allTasksList.add(new SubTask(
                            taskStrings[1],
                            taskStrings[2],
                            Integer.parseInt(taskStrings[3]),
                            TaskStatus.valueOf(taskStrings[4]),
                            Integer.parseInt(taskStrings[5])));
                } else if(Integer.parseInt(taskStrings[0]) == 1) {
                    allTasksList.add(new Task(
                            taskStrings[1],
                            taskStrings[2],
                            Integer.parseInt(taskStrings[3]),
                            TaskStatus.valueOf(taskStrings[4])));
                } else if(Integer.parseInt(taskStrings[0]) == 2) {
                    allTasksList.add(new Task(
                            taskStrings[1],
                            taskStrings[2],
                            Integer.parseInt(taskStrings[3]),
                            TaskStatus.valueOf(taskStrings[4]))

                    );


                    // считать в массив?
                }
            }

        }



    }

}
