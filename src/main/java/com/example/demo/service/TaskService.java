package com.example.demo.service;

import com.example.demo.dao.TaskRepository;
import com.example.demo.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task saveTask(Task task) {
       return  taskRepository.save(task);
    }
    public void deleteTaskById(int id){
         taskRepository.deleteById(id);
    }
    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}
