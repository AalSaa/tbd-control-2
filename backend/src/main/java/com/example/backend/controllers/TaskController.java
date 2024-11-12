package com.example.backend.controllers;

import com.example.backend.entities.TaskEntity;
import com.example.backend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<TaskEntity>> getUserTasks(@PathVariable int id) {
        return new ResponseEntity<>(taskService.getTasksByIdUser(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable int id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskEntity task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity task) {
        return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable int id) {
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("success", taskService.deleteTaskById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
