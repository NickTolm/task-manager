package com.example.taskmanager.dao;

import com.example.taskmanager.dto.SubTask;
import com.example.taskmanager.dto.TaskStatus;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class SubTaskDAO {
    private List<SubTask> allSubTasksList = new ArrayList<>();
    public void readSubTasks() throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/subtasks")))) {
            while (scanner.hasNextLine()) {
                String[] subTaskStrings = scanner.nextLine().split(";");
                allSubTasksList.add(new SubTask(
                        Integer.parseInt(subTaskStrings[0]),
                        subTaskStrings[1],
                        subTaskStrings[2],
                        TaskStatus.valueOf(subTaskStrings[3]),
                        Integer.parseInt(subTaskStrings[4])));
            }
        }
    }

    //Получение списка всех задач.
    public List<SubTask> getAllSubTasks() {
        return this.allSubTasksList;
    }

    //Удаление всех задач.
    public void deleteAllSubTasks() {
        allSubTasksList.clear();
    }

    //Получение по идентификатору.
//    public SubTask getSpecifiedSubTaskById(int subTaskId) {
//        for(SubTask subTask: allSubTasksList) {
//            if(subTask.getId() == subTaskId) {
//                return subTask;
//            }
//        }
//    }

    //Создание. Сам объект должен передаваться в качестве параметра.
    public void addNewSubTask(SubTask subTask) {
        this.allSubTasksList.add(subTask);
    }

    // Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
//    public void updateSubTasks(SubTask subTask, int newSubTaskId) {
//        for(SubTask subTasks: allSubTasksList) {
//            if(subTasks == subTask) {
//                subTasks.setId(newSubTaskId); // @Value?
//
//            }
//        }
//    }

    //Удаление по идентификатору.
    public void deleteSpecifiedSubTaskById(int subTaskId) {
        allSubTasksList.removeIf(subTask -> subTask.getId() == subTaskId);
    }

}
