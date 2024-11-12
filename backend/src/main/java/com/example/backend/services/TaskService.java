package com.example.backend.services;

import com.example.backend.entities.TaskEntity;
import com.example.backend.exceptions.EntityNotFoundException;
import com.example.backend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> getTasksByIdUser(int id) {
        return taskRepository.findTasksByUserID(id);
    }

    public TaskEntity getTaskById(int id) {
        TaskEntity task = taskRepository.findById(id);
        if (task == null) {
            throw new EntityNotFoundException("Task not found");
        }
        return task;
    }

    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    public TaskEntity updateTask(TaskEntity task) {
        TaskEntity taskEntity = taskRepository.findById(task.getId());
        if (taskEntity == null) {
            throw new EntityNotFoundException("Task not found");
        }
        return taskRepository.update(task);
    }

    public boolean deleteTaskById(int id) {
        TaskEntity task = taskRepository.findById(id);
        if (task == null) {
            throw new EntityNotFoundException("Task not found");
        }
        return taskRepository.delete(task.getId());
    }
}
