package com.example.taskmanager.dao;

import com.example.taskmanager.dto.Epic;
import com.example.taskmanager.dto.TaskStatus;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

@Repository
public class EpicDAO {
    private List<Epic> allEpicsList = new ArrayList<>();

    public void readEpics() throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/epics")))) {
            while (scanner.hasNextLine()) {
                String[] taskStrings = scanner.nextLine().split(";");
                allEpicsList.add(new Epic(
                        parseInt(taskStrings[0]),
                        taskStrings[1],
                        taskStrings[2],
                        TaskStatus.valueOf(taskStrings[3]),
                        Collections.singletonList(parseInt(Arrays.toString((taskStrings[4].split(","))))) // ???
                        ));
            }
        }
    }

    public List<Epic> getAllEpics() {
        return allEpicsList;
    }

    //Удаление всех задач.
    public void deleteAllEpics() {
        allEpicsList.clear();
    }

    //Получение по идентификатору.
//    public Epic getSpecifiedEpicById(int epicId) {
//        for(Epic epic: allEpicsList) {
//            if(epic.getId() == epicId) {
//                return epic;
//            }
//        }
//    }

    //Создание. Сам объект должен передаваться в качестве параметра.
    public void addNewEpic(Epic epic) {
        this.allEpicsList.add(epic);
    }

    // Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
//    public void updateEpic(Epic epic, int newEpicId) {
//        for(Epic epics: allEpicsList) {
//            if(epics == epic) {
//                epics.setId(newEpicId);  //  @Value?
//            }
//        }
//    }

    //Удаление по идентификатору.
    public void deleteSpecifiedEpicByID(int epicId) {
        allEpicsList.removeIf(epic -> epic.getId() == epicId);
    }

    //  Получение списка всех подзадач определённого эпика.
//    public List<Integer>  findSubTasksOfEpic(int EpicId) {
//        for(Epic epic: allEpicsList) {
//            if(epic.getId() == EpicId) {
//                return epic.subTasksID;
//            }
//        }
//    }



}
