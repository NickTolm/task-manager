package com.example.taskmanager.services;

import com.example.taskmanager.dao.EpicDAO;
import com.example.taskmanager.dto.Epic;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class ManagerEpics {
    private final EpicDAO epicDAO = new EpicDAO();

    public List<Epic> getAllEpics() throws FileNotFoundException {
        epicDAO.readEpics();
        return epicDAO.getAllEpics();
    }

    public void deleteAllEpics() throws IOException {
        epicDAO.deleteAllEpics();
    }
}
