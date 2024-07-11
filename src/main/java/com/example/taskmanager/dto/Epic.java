package com.example.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class Epic{
    private final int id;
    private final String name;
    private final String description;
    private final TaskStatus taskStatus;
    public List<Integer> subTasksID;

}
