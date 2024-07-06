package com.example.taskmanager.dto;

import org.springframework.stereotype.Component;

import java.util.List;


public class Epic extends Task{
    public List<Integer> subTasksID;

    public Epic(String name, String description, int id, TaskStatus status, int[] subTasksID) {
        super(name, description, id, status);
        this.subTasksID = subTasksID;
    }
}
