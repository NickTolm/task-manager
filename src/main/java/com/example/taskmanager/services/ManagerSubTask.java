package com.example.taskmanager.services;

import com.example.taskmanager.dao.SubTaskDAO;
import com.example.taskmanager.dto.SubTask;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class ManagerSubTask {
    private final SubTaskDAO subTaskDAO = new SubTaskDAO();

    public List<SubTask> getAllSubTasks() throws FileNotFoundException {
        subTaskDAO.readSubTasks();
        return subTaskDAO.getAllSubTasks();
    }

    public void deleteAllSubTasks() throws IOException {
        subTaskDAO.deleteAllSubTasks();
    }
}
