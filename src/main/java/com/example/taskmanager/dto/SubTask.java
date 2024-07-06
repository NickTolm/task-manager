package com.example.taskmanager.dto;

import org.springframework.stereotype.Component;

@Component
public class SubTask extends Task {
    private int epicID;

    public SubTask(String name, String description, int id, TaskStatus status, int epicID) {
        super(name, description, id, status);
        this.epicID = epicID;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "epicID=" + epicID +
                ", name='" + this.getName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", id=" + this.getId() +
                ", status=" + this.getStatus() +
                '}';
    }
}
