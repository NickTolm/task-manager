package com.example.taskmanager.controllers;

import com.example.taskmanager.dto.Epic;
import com.example.taskmanager.services.ManagerEpics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;
@RestController
public class ManagerControllerEpics {
    private final ManagerEpics manager;
    public ManagerControllerEpics(ManagerEpics manager) {
        this.manager = manager;
    }

    @GetMapping("/getAllEpics")
    public List<Epic> printAllEpics() throws FileNotFoundException {
        return manager.getAllEpics();
    }



//    @GetMapping("/findSubTasksOfEpic")
//    public List<Integer> findSubTasksOfEpic (@RequestBody int EpicID) {
//        return manager.findSubTasksOfEpic(EpicID);
//    }
}
