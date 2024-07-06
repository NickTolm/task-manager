package com.example.taskmanager.dto;

import lombok.Value;

@Value
public class Task {
    private final String name;
    private final String description;
    private final int id;
    private final TaskStatus status;
}
