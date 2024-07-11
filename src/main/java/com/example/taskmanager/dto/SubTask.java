package com.example.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import org.springframework.stereotype.Component;


@Value
@AllArgsConstructor
public class SubTask{
    private final int id;
    private final String name;
    private final String description;
    private final TaskStatus taskStatus;
    private final int epicID;


}
