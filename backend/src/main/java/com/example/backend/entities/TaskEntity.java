package com.example.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    private int id;
    private int id_user;
    private String title;
    private String description;
    private Date due_date;
    private boolean status;
}
