package com.example.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Value
@AllArgsConstructor
public class Task {
    private final int id;
    private final String name;
    private final String description;
    private final TaskStatus taskStatus;

}
